import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { PetsService } from 'src/app/services/pets.service';
import { Pet } from 'src/app/model/pets';

@Component({
  selector: 'app-create-pets',
  templateUrl: './create-pets.component.html',
  styleUrls: ['./create-pets.component.css']
})
export class CreatePetsComponent implements OnInit {
  petForm!: FormGroup;
  listOfCategories: any =[];
  selectedFile!: File ;
  imagePreview!: string | ArrayBuffer|null;
  constructor(private fb: FormBuilder,
    private router: Router,
    private petService: PetsService){}

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
      this.petForm= this.fb.group(
        {
          categoryId:[null,[Validators.required]],
          name:[null,[Validators.required]],
          price:[null,[Validators.required]],
          description:[null,[Validators.required]],
          
        }

      );
    }
    addPets(): void{
      try{
      this.petService.createPets(this.petForm);
      }
      catch{
        alert("Not working");
      }

    }

}
