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

  items = this.cart.getItems();

  ngOnInit(): void {
    console.log(this.items);
  }
  onclick() {
    this.dialog.open(BuypageComponent, {
      width: '550px',
    });
  }
}
