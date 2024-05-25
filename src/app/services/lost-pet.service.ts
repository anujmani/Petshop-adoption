import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LostPet } from '../model/LostPet';
import baseUrl from '../helper';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LostPetService {

  constructor(private http: HttpClient){ }
  getLostPets(): Observable<LostPet[]> {
    return this.http.get<LostPet[]>(`${baseUrl}/api/lost-pets`);
  }

  postLostPet(formData: FormData): Observable<LostPet> {
    return this.http.post<LostPet>(`${baseUrl}/api/lost-pets/add`, formData);
  }
}
