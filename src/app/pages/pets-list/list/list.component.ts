import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CartserviceService } from 'src/app/cartservice.service';
import { FilterParam } from 'src/app/model/FilterParam';
import { PaginatedResponse } from 'src/app/model/paginatedResponse';
import { Pet } from 'src/app/model/pets';
import { LoginServiceService } from 'src/app/services/login-service.service';
import { PetsService } from 'src/app/services/pets.service';
import { SearchFormServiceService } from 'src/app/services/search-form-service.service';
import { AdminService } from '../../admin/admin.service';
import { Product } from 'src/app/model/product';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css'],
})
export class ListComponent {
  products: Product[] = [];

  searchProductForm!: FormGroup;
  totalElements: number | undefined;
  totalPages: number | undefined;
  currentPage: number | undefined;
  filterParam: FilterParam = new FilterParam();
  userRoles: any;

 
  

  constructor(
    private route: ActivatedRoute,
    private cart: CartserviceService,
    private petService: PetsService,
    private fb: FormBuilder,
    public login: LoginServiceService,
    private searchFormService: SearchFormServiceService, // Corrected injection
    private adminService: AdminService
  ) {}

  ngOnInit(): void {
    this.buildSearchForm();
    this.loadProducts();
    this.userRoles = this.login.getUserRole();
  }

  buildSearchForm() {
    this.searchProductForm = this.fb.group({
      age: [null, [Validators.required]],
      name: [null, [Validators.required]],
      colorSets: [null, [Validators.required]],
    });
  }

  loadProducts(page: number = 0): void {
    // Added pagination support
    this.filterParam = this.searchFormService.getFilteredParams(
      this.searchProductForm
    );

    this.adminService.getProducts(page, this.filterParam).subscribe(
      (response: PaginatedResponse) => {
        console.log('::', response);
        this.products = response.content;
      },
      (error) => {
        console.error('Error fetching products', error);
      }
    );
  }

  onAdd(product: Product): void {
    console.log(product);
    this.cart.addProductToCart(product);
    alert(`${product.name} is added to the cart`);
  }
  public isUser() {
    if (this.userRoles === 'ROLE_USER') {
      return true;
    } else {
      return false;
    }
  }

  submitForm() {
    this.loadProducts(); // Reload pets with new filter parameters
  }
}
