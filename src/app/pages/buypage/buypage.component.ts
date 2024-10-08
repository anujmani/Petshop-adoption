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
  constructor(
    @Inject(MAT_DIALOG_DATA) public data: any,
    private cart: CartserviceService,
    private formbuilder: FormBuilder,
    private closebuy: MatDialogRef<BuypageComponent>,
    private userBuy: UserBuyService
  ) {
    this.petsId = data.petsIds;
    console.log("::", data);
    console.log("::", data.petsIds);
  }
  buyform: any;
  ngOnInit(): void {
    this.buyform = this.formbuilder.group({
      user: [null, [Validators.required]],
      items:[this.petsId],
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
      this.userBuy.adoptPets(this.buyform.value).subscribe(
        (data) => {
          // Handle successful adoption (e.g., display success message)
          console.log('Pets adopted successfully!', data);
          this.cart.clearCart();
          this.buyform.reset();
          this.closebuy.close();
          alert('Your order has been submitted');
        },
        (error) => {
          // Handle errors (as you have already implemented)
          console.error('Error fetching pets', error);
          alert('Issue while adopting the pets');
          this.buyform.reset();
          this.closebuy.close();
        }
      );
    }

  
  }
}
