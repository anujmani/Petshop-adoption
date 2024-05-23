import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import baseUrl from '../helper';

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  constructor(private http:HttpClient) { 
    
  }

  public getCurrentUser(){
    return this.http.get(`${baseUrl}/user/current-user`)
  }
  public generateToken(logindata:any){
      return this.http.post(`${baseUrl}/user/authenticate`, logindata)
  }

   //set userDetail
   public setUser(user: any){
    localStorage.setItem('user',JSON.stringify(user));
  }

  public loginUser(token: string){
    console.log('setting token in localstorage'+token);
    
    localStorage.setItem('token',token.toString());
   
    console.log("set the token"+localStorage.getItem);

    return true;
  }
  //isLogin: user is logged r not
  public isLoggedIn(){
    let tokenStr= localStorage.getItem('token');
    console.log(tokenStr);
    if(tokenStr== undefined || tokenStr==''|| tokenStr== null){
      return false;
    }
    else{
      return true;
    }
  }
  public logout(){
    localStorage.removeItem("token")
    localStorage.removeItem("user");
    return true;
  }

  //get token
  public getToken(){
    return localStorage.getItem('token');
  }

 

  public getUser(){
    let userStr= localStorage.getItem("user");
    console.log(userStr);
    if(userStr!=null){
      return JSON.parse(userStr);

    }
    else{
      this.logout();
      return null;
    }
  }

  
  //get user role
  public getUserRole(){
    let user=this.getUser();
    console.log(user)
    console.log(user.authorities[0].authority)
    return user.authorities[0].authority;
  }

  public isAdminLoggedIn(): boolean {
    if(this.getToken=== null){
      return false;
    }
    const role: string = this.getUserRole();
    return role == 'ADMIN';
  }

  public isUserLoggedIn(): boolean {
    if(this.getToken=== null){
      return false;
    }
    const role: string = this.getUserRole();
    return role == 'USER';
  }
  
}


