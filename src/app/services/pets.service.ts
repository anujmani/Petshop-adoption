import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from '../helper';
import { Observable } from 'rxjs';
import { Pet } from '../model/pets';
import { PaginatedResponse } from '../model/paginatedResponse';
import { FilterParam } from '../model/FilterParam';
import { Comment } from '../model/comment';

@Injectable({
  providedIn: 'root'
})
export class PetsService {
  getPetById(petId:number): Observable<Pet> {
    return this.http.get<Pet>(`${baseUrl}/pets/getPetsById/${petId}`);
  }
 
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

  getPets( filterParam?: FilterParam): Observable<Pet[]> {

    return this.http.post<Pet[]>(`${baseUrl}/pets/getPetsList`, filterParam);
  }
  savePetComment(comment: Comment): Observable<Comment> {
    return this.http.post<Comment>(`${baseUrl}/api/save`, comment);
  }

  // Method to get comments by pet ID
  getByPetId(petId: number): Observable<Comment[]> {
    return this.http.get<Comment[]>(`${baseUrl}/api/get/${petId}`);
  }
}
