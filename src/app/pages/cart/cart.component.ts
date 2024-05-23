import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { ActivatedRoute } from '@angular/router';
import { CartserviceService } from 'src/app/cartservice.service';
import { BuypageComponent } from '../buypage/buypage.component';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css'],
})
export class CartComponent implements OnInit {
  constructor(
    private route: ActivatedRoute,
    private cart: CartserviceService,
    private dialog: MatDialog
  ) {}
  check = true;

  pets = this.cart.getItems();
  products = this.cart.getProducts();

  ngOnInit(): void {
    console.log(this.pets);
  }
  onClick() {
    const petsIds = this.pets.map((item) => item.petsId);
    this.dialog.open(BuypageComponent, {
      width: '550px',
      data: { petsIds },
    });
  }
  onProductClick() {
    const productIds = this.products.map((item) => item.productId);
    this.dialog.open(BuypageComponent, {
      width: '550px',
      data: { productIds },
    });
  }
  removeItemFromCart(index: number, isPet: boolean): void {
    if (isPet) {
      this.pets.splice(index, 1);
    } else {
      this.products.splice(index, 1);
    }
  }
}
