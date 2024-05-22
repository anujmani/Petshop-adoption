import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { PetsService } from 'src/app/services/pets.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent {
  pets: any[] | undefined;
  pageSize: number = 10; // Define the number of items per page
  page: number = 1; // Define the current page number
  totalItems: number | undefined; // Define the total number of items
  totalPages: number | undefined; 
  constructor(private http: HttpClient,private petsService: PetsService,private router: Router) { }

  ngOnInit(): void {
    this.getPets();
  }

  getPets(): void {
    this.petsService.getPets(this.page)
      .subscribe(
        (response: any) => {
          this.pets = response as any[];
        },
        (error: any) => {
          alert("Error fetching pets");
        }
      );
  }
  addPet(){
    window.location.href='/create';
  }
  
}


