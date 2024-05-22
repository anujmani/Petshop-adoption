import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { PetsService } from 'src/app/services/pets.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-create-pets',
  templateUrl: './create-pets.component.html',
  styleUrls: ['./create-pets.component.css']
})
export class CreatePetsComponent implements OnInit {
  petForm!: FormGroup;
  listOfCategories: any = [];
  selectedFile!: File;
  imagePreview!: string | ArrayBuffer | null;
  types: string[] = [];

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private petService: PetsService,
    private http: HttpClient
  ) {}

  onFileSelected(event: any) {
    this.selectedFile = event.target.files[0];
    this.previewImage();
  }

  previewImage() {
    const reader = new FileReader();
    reader.onload = () => {
      this.imagePreview = reader.result;
    };
    reader.readAsDataURL(this.selectedFile);
  }

  ngOnInit(): void {
    this.getPetTypes();
    this.petForm = this.fb.group({
     
      age: [''],
      reason: [''],
      type: [''],
      color: [null, [Validators.required]],
      name: [null, [Validators.required]],
      price: [null],
      petDescription: [null, [Validators.required]]
    });
  }
  getPetTypes() {
    this.petService.getPetTypes().subscribe((data: string[]) => {
      this.types = data;
    }, error => {
      console.error('Error fetching pet types', error);
    });
  }

  addPets(): void {
    const formData = new FormData();
    formData.append('picture', this.selectedFile);
    formData.append('age', this.petForm.get('age')!.value);
    formData.append('color', this.petForm.get('color')!.value);
    formData.append('name', this.petForm.get('name')!.value);
    formData.append('price', this.petForm.get('price')!.value);
    formData.append('reason', this.petForm.get('reason')!.value);
    formData.append('description', this.petForm.get('petDescription')!.value);

    if (this.selectedFile) {
      formData.append('image', this.selectedFile, this.selectedFile.name);
    }

    this.petService.createPets(formData).subscribe(
      (response) => {
        console.log('Pet created successfully', response);
        this.router.navigate(['/path-to-redirect']); // Adjust the path to where you want to navigate after creation
      },
      (error) => {
        console.error('Error creating pet', error);
        alert('Error creating pet. Please try again.');
      }
    );
  }
}
