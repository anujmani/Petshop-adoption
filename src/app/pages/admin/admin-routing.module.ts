import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin.component';
import { AdminGuard } from 'src/app/admin.guard';
import { CartComponent } from '../cart/cart.component';
import { AddProductsComponent } from './add-products/add-products.component';

const routes: Routes = [
  {
    path: '',
    component: AdminComponent,
    canActivate: [AdminGuard],
  
  },
  {
    path: 'addProducts',
    component: AddProductsComponent,
    canActivate: [AdminGuard] // Add AdminGuard if needed for access control
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class AdminRoutingModule { }
