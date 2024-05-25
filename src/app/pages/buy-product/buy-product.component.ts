import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { CartserviceService } from 'src/app/cartservice.service';
import { UserBuyService } from 'src/app/services/user-buy.service';

@Component({
  selector: 'app-buy-product',
  templateUrl: './buy-product.component.html',
  styleUrls: ['./buy-product.component.css']
})
export class BuyProductComponent implements OnInit {
  productIds: any[]=[];
  constructor(
    @Inject(MAT_DIALOG_DATA) public data: any,
    private cart: CartserviceService,
    private formbuilder: FormBuilder,
    private dialogRef: MatDialogRef<BuyProductComponent>,
    private userBuy: UserBuyService
  ) {
    this.productIds = data.productIds;
    console.log('::', data);
  }
  buyform: any;
  ngOnInit(): void {
    this.buyform = this.formbuilder.group({
      user: [null, [Validators.required]],
      items:[this.productIds],
      mblNo:[null, [Validators.required]],
      address:[null, [Validators.required]]
    });
  }

  onsubmit() {
    if (!this.buyform) {
      throw new Error(
        'Buy form is not available. Please ensure it is initialized before use.'
      );
    } else {
      this.userBuy.buyProducts(this.buyform.value).subscribe(
        (data) => {
          // Handle successful adoption (e.g., display success message)
          console.log('Pets adopted successfully!', data);
          this.cart.clearCart();
          this.buyform.reset();
          this.dialogRef.close();
          alert('Your order has been submitted');
        },
        (error) => {
          // Handle errors (as you have already implemented)
          console.error('Error fetching pets', error);
          alert('Issue while adopting the pets');
          this.buyform.reset();
          this.dialogRef.close();
        }
      );
    }

  
  }
}
