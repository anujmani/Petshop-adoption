import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { CartserviceService } from 'src/app/cartservice.service';
import { UserBuyService } from 'src/app/services/user-buy.service';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-buypage',
  templateUrl: './buypage.component.html',
  styleUrls: ['./buypage.component.css'],
})
export class BuypageComponent implements OnInit {
  petsId: [];
  productIds: [];
  constructor(
    @Inject(MAT_DIALOG_DATA) public data: any,
    private cart: CartserviceService,
    private formbuilder: FormBuilder,
    private dialogRef: MatDialogRef<BuypageComponent>,
    private userBuy: UserBuyService
  ) {
    this.petsId = data.petsIds;
    this.productIds = data.productIds || [];
    console.log('::', data);
    console.log('::', data.petsIds);
  }
  buyform: any;
  ngOnInit(): void {
    this.buyform = this.formbuilder.group({
      user: [null, [Validators.required]],
      mblNo: [null, [Validators.required]],
      address: [null, [Validators.required]],
      items: [this.petsId.length ? this.petsId : this.productIds], // Either pets or products
    });
  }

  onsubmit() {
    if (this.buyform.invalid) {
      throw new Error(
        'Buy form is invalid. Please ensure it is filled out correctly.'
      );
    }

    const isPetPurchase = this.petsId.length > 0;
    const submitObservable = isPetPurchase
      ? this.userBuy.adoptPets(this.buyform.value)
      : this.userBuy.buyProducts(this.buyform.value); // Assuming you have a method for buying products

    submitObservable.subscribe(
      (data) => {
        console.log(
          isPetPurchase
            ? 'Pets adopted successfully!'
            : 'Products purchased successfully!',
          data
        );
        this.cart.clearCart();
        this.buyform.reset();
        this.dialogRef.close();
        alert('Your order has been submitted');
      },
      (error) => {
        console.error('Error submitting order', error);
        alert('Issue while submitting your order');
        this.buyform.reset();
        this.dialogRef.close();
      }
    );
  }
}
