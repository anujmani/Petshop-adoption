import { Injectable } from '@angular/core';
import { Pet } from './model/pets';import { Product } from './model/product';
;


@Injectable({
  providedIn: 'root'
})
export class CartserviceService {
  items: Pet[] = [];
  private products: Product[] = [];
  constructor() { }
  addToCart(pet: Pet){
    this.items.push(pet);
    console.log(this.items)
  }
  getItems(){
    return this.items;
  }
  addProductToCart(product: Product) {
    this.products.push(product);
    console.log('Products in cart:', this.products);
  }
  getProducts() {
    return this.products;
  }
  clearCart(){
    this.items=[];
    return this.items;
  }
  
}
