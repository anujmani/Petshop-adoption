import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import baseUrl from 'src/app/helper';
import { LoginServiceService } from 'src/app/services/login-service.service';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http: HttpClient) {
  
   }
   addCategory(categoryDto: any): Observable<any>{
    return this.http.post(baseUrl + 'api/admin/category', categoryDto,{
      headers: this.createAuthorizationHeader(),
    })
   }
   getCategory(): Observable<any>{
    return this.http.get(baseUrl + 'api/admin/getCategory',{
      headers: this.createAuthorizationHeader(),
    })
   }
   private createAuthorizationHeader(): HttpHeaders{
    return new HttpHeaders().set(
      'Authorization','Bearer'+ localStorage.getItem('token')
      
    )
   }
}
