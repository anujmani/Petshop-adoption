import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { CartserviceService } from 'src/app/cartservice.service';

@Component({
  selector: 'app-buypage',
  templateUrl: './buypage.component.html',
  styleUrls: ['./buypage.component.css']
})
export class BuypageComponent implements OnInit{
  constructor(private cart:CartserviceService, private formbuilder:FormBuilder,private closebuy:MatDialogRef<BuypageComponent>){}
  buyform:any
  ngOnInit(): void {
    this.buyform= this.formbuilder.group({
      name:[null,[Validators.required]],
      address:[null,[Validators.required]],
      contactNo:[null,[Validators.required]]
    });
    
  }
  onsubmit(){
    console.warn('Your order has been submitted', this.buyform.value);
    this.cart.clearCart();
    
    this.buyform.reset();
    this.closebuy.close();
    alert("Your order has been submitted")

  }

}
