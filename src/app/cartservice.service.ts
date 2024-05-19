import { Injectable } from '@angular/core';
import { Pet } from './model/pets';;


@Injectable({
  providedIn: 'root'
})
export class CartserviceService {
  items: Pet[] = [];
  constructor() { }
  addToCart(pet: Pet){
    this.items.push(pet);
    console.log(this.items)
  }
  getItems(){
    return this.items;
  }
  clearCart(){
    this.items=[];
    return this.items;
  }
  
}
