import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-products',
  templateUrl: './add-products.component.html',
  styleUrls: ['./add-products.component.css'],
})
export class AddProductsComponent {
  productForm!: FormGroup;
  listOfCategories: any = [];
  selectedFile!: File;
  imagePreview!: string | ArrayBuffer | null;
  constructor(
    private fb: FormBuilder,
    private router: Router,
    private adminService: AdminService
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
    this.productForm = this.fb.group({
      name: [null, [Validators.required]],
      price: [null, [Validators.required]],
      description: [null, [Validators.required]],
    });
  }

  addProduct(): void {
    const formData = new FormData();
    formData.append('picture', this.selectedFile);
    formData.append('name', this.productForm.get('name')!.value);
    formData.append('price', this.productForm.get('price')!.value);
    formData.append('description', this.productForm.get('description')!.value);

    if (this.selectedFile) {
      formData.append('image', this.selectedFile, this.selectedFile.name);
    }

    this.adminService.createProduct(formData).subscribe(
      (response) => {
        console.log('Pet created successfully', response);
        this.router.navigate(['/admin']); // Adjust the path to where you want to navigate after creation
      },
      (error) => {
        console.error('Error creating pet', error);
        alert('Error creating pet. Please try again.');
      }
    );
  }
}
