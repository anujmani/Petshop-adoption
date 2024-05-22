// src/app/shoppage/shoppage.component.ts
import { Component, OnInit } from '@angular/core';
import { Pet } from 'src/app/model/pets';
import { ActivatedRoute } from '@angular/router';
import { CartserviceService } from 'src/app/cartservice.service';
import { PetsService } from 'src/app/services/pets.service';
import { PaginatedResponse } from 'src/app/model/paginatedResponse';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FilterParam } from 'src/app/model/FilterParam';
import { SearchFormServiceService } from 'src/app/services/search-form-service.service';

@Component({
  selector: 'app-shoppage',
  templateUrl: './shoppage.component.html',
  styleUrls: ['./shoppage.component.css'],
})
export class ShoppageComponent implements OnInit {
  pets: Pet[] = [];

  searchPetForm!: FormGroup;
  totalElements: number | undefined;
  totalPages: number | undefined;
  currentPage: number | undefined;
  filterParam: FilterParam = new FilterParam();

  constructor(
    private route: ActivatedRoute,
    private cart: CartserviceService,
    private petService: PetsService,
    private fb: FormBuilder,
    private searchFormService: SearchFormServiceService // Corrected injection
  ) {}

  ngOnInit(): void {
    this.buildSearchForm();
    this.loadPets();
  }

  buildSearchForm() {
    this.searchPetForm = this.fb.group({
      age: [null, [Validators.required]],
      name: [null, [Validators.required]],
      colorSets: [null, [Validators.required]],
    });
  }

  loadPets(page: number = 0): void { // Added pagination support
    this.filterParam = this.searchFormService.getFilteredParams(this.searchPetForm);

    this.petService.getPets(page, this.filterParam).subscribe(
      (response: PaginatedResponse) => {
        this.pets = response.content;
        this.totalElements = response.totalElements;
        this.totalPages = response.totalPages;
        this.currentPage = page;
        console.log(this.pets);
      },
      (error) => {
        console.error('Error fetching pets', error);
      }
    );
  }

  onAdd(pet: Pet): void {
    console.log(pet);
    this.cart.addToCart(pet);
    alert(`${pet.name} is added to the cart`);
  }

  submitForm() {
    this.loadPets(); // Reload pets with new filter parameters
  }
}
