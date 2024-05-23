import { Injectable } from '@angular/core';
import baseUrl from '../helper';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FormGroup } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class UserBuyService {
  buyProducts(data: any): Observable<any> {
    return this.http.post<any>(`${baseUrl}/products/buy`, data);
  }
  
  

  constructor(private http: HttpClient) { }
  

  adoptPets(data: any): Observable<any> {
    return this.http.post<any>(`${baseUrl}/adopt/adopt`, data);
  }

   
}
