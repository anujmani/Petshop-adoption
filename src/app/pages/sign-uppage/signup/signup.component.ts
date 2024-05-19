import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SignupserviceService } from 'src/app/signupservice.service';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  signupform:any=FormGroup;
  constructor(private formbuilder: FormBuilder,
     private service:SignupserviceService,
   ){}
  ngOnInit(): void {
    this.signupform= this.formbuilder.group({
      name:[null,[Validators.required]],
      address:[null,[Validators.required]],
      email: [null, [Validators.required],Validators.email],
      password: [null, [Validators.required]],
      confirmPassword: [null, [Validators.required]]
    });
  }

  
  onSubmit() {
    const confirmPassword = this.signupform.get('confirmPassword').value;
  
    const formData = {
      name: this.signupform.get('name').value,
      address: this.signupform.get('address').value,
      email: this.signupform.get('email').value,
      password: this.signupform.get('password').value
    };
  
    if (confirmPassword !== formData.password) {
      alert('Passwords do not match');
      return; // Abort the submission if passwords don't match
    }
  
    this.service.addUser(formData).subscribe(
      (data) => {
        console.log(data);
        
        alert('Registered successfully');
      },
      (error) => {
        console.log(error);
        alert('Something went wrong');
      }
    );
  }
}