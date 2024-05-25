import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import baseUrl from '../helper';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http: HttpClient) { }

  // Method to fetch all orders
  getOrders(): Observable<any[]> {
    return this.http.get<any[]>(`${baseUrl}/sales/getAllSales`);
  }
}
