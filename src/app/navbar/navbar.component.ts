import { Component, OnInit } from '@angular/core';
import { LoginServiceService } from '../services/login-service.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  isLoggedIn = false;
  user: any;
  userRoles: any;

  constructor(public login: LoginServiceService) { }

  ngOnInit(): void {
    this.isLoggedIn = this.login.isLoggedIn();
    this.user = this.login.getUser();
    this.userRoles= this.login.getUserRole();
    console.log(this.isLoggedIn);
    
    
  }

  public logout(): void {
    this.login.logout();
    this.isLoggedIn = false; // Update isLoggedIn property
    this.user = null;
    window.location.reload();
  }
  public isUser(){
    if(this.userRoles=== 'ROLE_USER' ){
      return true;
    }
    else{
      return false;
    }
    
  }
}
