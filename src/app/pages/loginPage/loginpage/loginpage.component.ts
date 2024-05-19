import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginServiceService } from 'src/app/services/login-service.service';

@Component({
  selector: 'app-loginpage',
  templateUrl: './loginpage.component.html',
  styleUrls: ['./loginpage.component.css']
})
export class LoginpageComponent implements OnInit {
  loginSubmitform:any=FormGroup;
  
  constructor(private formBuilder: FormBuilder, private login: LoginServiceService, private router: Router) {}

  ngOnInit(): void {
    this.loginSubmitform = this.formBuilder.group({
      name: [null, Validators.required],
      password: [null, Validators.required]
    });
  }

  async formSubmit() {
    console.log(this.loginSubmitform.value); // Use .value to get the form data

    if (this.loginSubmitform.invalid) {
      alert('User and Password are required');
      return;
    }
    const formData = {
      name: this.loginSubmitform.get('name').value,
      password: this.loginSubmitform.get('password').value
    };

    this.login.generateToken(formData).subscribe(
      (data: any) => {
        console.log("Success:", data);
        this.login.loginUser(data.token);
        this.login.getCurrentUser().subscribe(
          (user: any) => {
            this.login.setUser(user);
            this.login.isLoggedIn();
            console.log(user);
            if (this.login.getUserRole() == "ROLE_ADMIN") {
              // this.router.navigateByUrl('/admin');
              window.location.href='/admin'
            
            } else if (this.login.getUserRole() == "ROLE_USER") {
              // this.router.navigateByUrl('/admin');
              window.location.href='/'
             
            } else {
              this.login.logout();
            }
          }
        )
      },
      (error) => {
        console.error('Error:', error);
        alert('Invalid user credentials');
      }
    );
  }
}
