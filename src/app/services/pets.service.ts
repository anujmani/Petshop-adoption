import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from '../helper';
import { Observable } from 'rxjs';
import { Pet } from '../model/pets';

@Injectable({
  providedIn: 'root'
})
export class PetsService {

  
  constructor(private http: HttpClient) { }
  
  public createPets(pets:any){
    return this.http.post(`${baseUrl}/pets/create`,pets);
  }
  getPets(page: number = 0, size: number = 10): Observable<Pet[]> {
    let params = new HttpParams();
    params = params.append('page', page.toString());
    params = params.append('size', size.toString());

    return this.http.get<Pet[]>(`${baseUrl}/pets/getPets`, { params });
  }
}
