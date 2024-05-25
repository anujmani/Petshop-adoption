import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import baseUrl from 'src/app/helper';
import { ProductFilterParam } from 'src/app/model/ProductFilterParam';
import { PaginatedResponse } from 'src/app/model/paginatedResponse';
import { Product } from 'src/app/model/product';
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
   createProduct(petData: FormData): Observable<any> {
    return this.http.post(`${baseUrl}/product/create`, petData);
  }
  getProducts(pageNumber: number = 0, filterParam?: ProductFilterParam): Observable<Product[]> {


    let params = new HttpParams()
    
    if (filterParam?.name) {
      params = params.set('name', filterParam.name);
    }
    if (filterParam?.description) {
      params = params.set('description', filterParam.description);
    }
    if (filterParam?.price !== undefined) {
      params = params.set('price', filterParam.price.toString());
    }

    return this.http.get<Product[]>(`${baseUrl}/product/getProductsList`, { params });
  }
  
}
