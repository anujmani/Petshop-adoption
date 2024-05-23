import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from '../helper';
import { Observable } from 'rxjs';
import { Pet } from '../model/pets';
import { PaginatedResponse } from '../model/paginatedResponse';
import { FilterParam } from '../model/FilterParam';

@Injectable({
  providedIn: 'root'
})
export class PetsService {
 
  constructor(private http: HttpClient) { }
  getPetTypes(): Observable<string[]> {
    return this.http.get<string[]>(`${baseUrl}/pets/types`);
  }

  getAllPetsByName(title: any): Observable<any> {
    return this.http.get(`${baseUrl}/pets/getPets/${title}`);
  }

  createPets(petData: FormData): Observable<any> {
    return this.http.post(`${baseUrl}/pets/create`, petData);
  }

  getPets(pageNumber: number = 0, filterParam?: FilterParam): Observable<PaginatedResponse> {
    const pageSize: number = 10; // Correctly declare pageSize variable

    let params = new HttpParams()
      .set('pageNumber', pageNumber.toString()) // Convert to string
      .set('pageSize', pageSize.toString()); // Convert to string

    if (filterParam?.name) {
      params = params.set('name', filterParam.name);
    }
    if (filterParam?.color) {
      params = params.set('color', filterParam.color);
    }
    if (filterParam?.age) {
      params = params.set('age', filterParam.age.toString());
    }

    return this.http.get<PaginatedResponse>(`${baseUrl}/pets/getPetsList`, { params });
  }
}
