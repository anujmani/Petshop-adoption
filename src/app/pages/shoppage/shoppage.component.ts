// src/app/shoppage/shoppage.component.ts
import { Component, OnInit } from '@angular/core';
import { Pet } from 'src/app/model/pets';
import { ActivatedRoute } from '@angular/router';
import { CartserviceService } from 'src/app/cartservice.service';
import { PetsService } from 'src/app/services/pets.service'; 

@Component({
  selector: 'app-shoppage',
  templateUrl: './shoppage.component.html',
  styleUrls: ['./shoppage.component.css']
})
export class ShoppageComponent implements OnInit {
  pets: Pet[] = [];

  constructor(
    private route: ActivatedRoute, 
    private cart: CartserviceService,
    private petService: PetsService
  ) {}

  ngOnInit(): void {
    this.loadPets();
  }

  loadPets(): void {
    this.petService.getPets().subscribe(
      (pets: Pet[]) => {
        this.pets = pets;
      },
      error => {
        console.error('Error fetching pets', error);
      }
    );
  }

  onAdd(pet: Pet): void {
    console.log(pet);
    this.cart.addToCart(pet);
    alert(`${pet.name} is added to the cart`);
  }
}
