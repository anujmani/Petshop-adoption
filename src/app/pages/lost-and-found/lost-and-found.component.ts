import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { LostPet } from 'src/app/model/LostPet';
import { LostPetService } from 'src/app/services/lost-pet.service';

@Component({
  selector: 'app-lost-and-found',
  templateUrl: './lost-and-found.component.html',
  styleUrls: ['./lost-and-found.component.css']
})

export class LostAndFoundComponent implements OnInit {
  lostPetForm: FormGroup;
  lostPets: LostPet[] = [];
  selectedImage!: File; // Corrected variable name
  imagePreview!: string | ArrayBuffer | null;

  constructor(private fb: FormBuilder, private lostPetService: LostPetService, private router: Router) {
    this.lostPetForm = this.fb.group({
      name: ['', Validators.required],
      description: ['', Validators.required],
      location: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.loadLostPets();
  }

  onFileSelected(event: any) {
    this.selectedImage = event.target.files[0];
    if (this.selectedImage) {
      this.previewImage(this.selectedImage); // Pass selectedImage instead of file
    }
  }

  previewImage(file: File) {
    const reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = () => {
      this.imagePreview = reader.result;
    };
  }

  loadLostPets(): void {
    this.lostPetService.getLostPets().subscribe((pets: LostPet[]) => {
      this.lostPets = pets;
    });
  }

  onSubmit(): void {
    const formData = new FormData();
    formData.append('name', this.lostPetForm.get('name')!.value);
    formData.append('description', this.lostPetForm.get('description')!.value);
    formData.append('location', this.lostPetForm.get('location')!.value);
  
    if (this.selectedImage) {
      formData.append('picture', this.selectedImage);
    }
  
    // Assuming you have a pet service named 'lostPetService' with a method named 'postLostPet'
    this.lostPetService.postLostPet(formData).subscribe(
      (response) => {
        console.log('Lost pet added successfully', response);
        this.loadLostPets();
        // Adjust the redirection path according to your requirements
        this.router.navigate(['/lost-and-found']); 
      },
      (error) => {
        console.error('Error adding lost pet', error);
        alert('Error adding lost pet. Please try again.');
      }
    );
  }
}
