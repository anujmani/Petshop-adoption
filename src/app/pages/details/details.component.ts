import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { CartserviceService } from 'src/app/cartservice.service';
import { Comment } from 'src/app/model/comment';
import { Pet } from 'src/app/model/pets';
import { PetsService } from 'src/app/services/pets.service';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css'],
})
export class DetailsComponent implements OnInit {
  pet!: Pet;
  comments: Comment[] = [];
  commentForm: FormGroup;
  constructor(
    private route: ActivatedRoute,
    private cart: CartserviceService,
    private petService: PetsService,
    private fb: FormBuilder
  ) {
    this.commentForm = this.fb.group({
      comment: ['', Validators.required],
    });
  }
  ngOnInit(): void {
    const routeParams = this.route.snapshot.paramMap;
    const petIdFromRoute = Number(routeParams.get('petId'));
    this.getPet(petIdFromRoute);
    this.loadComment(petIdFromRoute);
    
    
    console.log('log is the' + this.pet);
  }
  getPet(petIdFromRoute: number) {
    this.petService.getPetById(petIdFromRoute).subscribe(
      (data) => {
        data.picture = 'data:image/jpeg;base64,' + data.picture;
        this.pet = data;
      },
      (error) => {
        console.error('Error fetching pet details', error);
      }
    );
  }
  onAdd(pet: any) {
    console.log(pet);
    this.cart.addToCart(pet);
    alert(pet.name + ' is added to the cart');
  }
  submitComment(): void {
    if (this.commentForm.valid) {
      const newComment: Comment = {
        comment: this.commentForm.value.comment,
        commentedBy: 'User',
        petId: this.pet.petsId!,
        date: new Date() // Assuming this.pet contains the pet ID
         // Assuming you have a way to identify the commenter
      };

      // Call the service method to save the comment
      this.petService.savePetComment(newComment).subscribe(
        (response) => {
          console.log('Comment saved successfully:', response);
          // Retrieve comments by pet ID after saving the new comment
         this.loadComment(this.pet.petsId!);
          this.commentForm.reset(); // Reset the form after successful submission
        },
        (error) => {
          console.error('Error saving comment:', error);
        }
      );
    }
  }
  loadComment(petIdFromRoute: number){
    this.petService.getByPetId(petIdFromRoute).subscribe(
      (commentsList) => {
        console.log('Comments for pet:', commentsList);
        this.comments = commentsList; // Update the comments array with the retrieved comments
      },
      (error) => {
        console.error('Error retrieving comments:', error);
      }
    );
  }
}
