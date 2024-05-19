import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-products',
  templateUrl: './add-products.component.html',
  styleUrls: ['./add-products.component.css']
})
export class AddProductsComponent {
  productForm!: FormGroup;
  listOfCategories: any =[];
  selectedFile!: File ;
  imagePreview!: string | ArrayBuffer|null;
  constructor(private fb: FormBuilder,
    private router: Router,
    private adminService: AdminService){}

    onFileSelected(event: any){
      this.selectedFile = event.target.files[0];
      this.previewImage();
    }

    previewImage(){
      const reader = new FileReader();
      reader.onload =()=>{
        this.imagePreview = reader.result;
      }
      reader.readAsDataURL(this.selectedFile);
    }
    ngOnInit(): void{
      this.productForm= this.fb.group(
        {
          categoryId:[null,[Validators.required]],
          name:[null,[Validators.required]],
          price:[null,[Validators.required]],
          description:[null,[Validators.required]],
        }
      );
      this.getAllCategories();
    }
    getAllCategories(){
      this.adminService.getCategory().subscribe(res=>{
        this.listOfCategories = res;
      })
    }
    addProduct(): void{

    }

}
