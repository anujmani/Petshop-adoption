import { Component, OnInit } from '@angular/core';
import { LoginServiceService } from '../services/login-service.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  isLoggedIn = false;
  user: any;
  userRoles: any;

  constructor(public login: LoginServiceService) {}

  ngOnInit(): void {
    this.isLoggedIn = this.login.isLoggedIn();
    this.user = this.login.getUser();
    this.userRoles = this.login.getUserRole();
  }

  public logout(): void {
    this.login.logout();
    this.isLoggedIn = false; // Update isLoggedIn property
    this.user = null;
    window.location.reload();
  }
  public isUser() {
    if (this.userRoles === 'ROLE_USER') {
      console.log(this.userRoles);
      return true;
    } else {
      console.log(this.userRoles);
      return false;
    }
  }
}
