import { Component, OnInit, ViewChild } from '@angular/core';
import { Pet } from 'src/app/model/pets';
import { ActivatedRoute } from '@angular/router';
import { CartserviceService } from 'src/app/cartservice.service';
import { PetsService } from 'src/app/services/pets.service';
import { MatMenuTrigger } from '@angular/material/menu';
import { FormBuilder, FormGroup } from '@angular/forms';
import { FilterParam } from 'src/app/model/FilterParam';
import { SearchFormServiceService } from 'src/app/services/search-form-service.service';

@Component({
  selector: 'app-shoppage',
  templateUrl: './shoppage.component.html',
  styleUrls: ['./shoppage.component.css'],
})
export class ShoppageComponent implements OnInit {
  pets: Pet[] = [];
  ageOptions: number[] = [1, 2, 3, 4, 5]; // Example age options
  colorOptions: string[] = ['Black', 'White', 'Brown'];

  searchPetForm!: FormGroup;
  totalElements: number | undefined;
  totalPages: number | undefined;
  currentPage: number | undefined;
  filterParam: FilterParam = new FilterParam();
  @ViewChild(MatMenuTrigger) filterMenuTrigger!: MatMenuTrigger ;

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
      age: [null],
      name: [null],
      color: [null],
    });
  }

  loadPets(page: number = 0): void { // Added pagination support
    this.filterParam = this.searchFormService.getFilteredParams(this.searchPetForm);

    this.petService.getPets(this.filterParam).subscribe(
      (response: Pet[]) => {
        console.log("::",response);
        // Clear the current pets array before adding new elements
        this.pets = [];
        response.forEach(element => {
          element.picture = 'data:image/jpeg;base64,' + element.picture;
          this.pets.push(element);
        });
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

  applyFilters() {
    // Apply filters here based on form values
    console.log('Applied filters:', this.searchPetForm.value);
    this.loadPets();
    // Close the filter menu after applying filters
    this.filterMenuTrigger.closeMenu();
  }
  resetForm() {
    this.searchPetForm.reset({
      age: null,
      name: null,
      color: null
    });
    this.pets = [];
    this.loadPets(); // Reload pets with reset filter parameters
  }
}
