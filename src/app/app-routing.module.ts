import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignupComponent } from './pages/sign-uppage/signup/signup.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { ShoppageComponent } from './pages/shoppage/shoppage.component';
import { CartComponent } from './pages/cart/cart.component';
import { DetailsComponent } from './pages/details/details.component';
import { LoginpageComponent } from './pages/loginPage/loginpage/loginpage.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { AdminGuard } from './admin.guard';
import { AddProductsComponent } from './pages/admin/add-products/add-products.component';
import { AdoptionpageComponent } from './pages/adoptionpage/adoptionpage/adoptionpage.component';
import { ListComponent } from './pages/pets-list/list/list.component';
import { CreatePetsComponent } from './pages/pets-list/create/create-pets.component';
import { OrderComponent } from './pages/order/order.component';
import { LostAndFoundComponent } from './pages/lost-and-found/lost-and-found.component';

const routes: Routes = [
  {
    path:'signup',
    component:SignupComponent,
    pathMatch:"full"
  },
  {
    path:'',
    component: DashboardComponent,
    pathMatch:"full"
  },
  {
    path:'login',
    component: LoginpageComponent,
    pathMatch:"full"
  },
  {
    path:'shop',
    component: ShoppageComponent,
    pathMatch:"full",
    children:[
     
      {
        path:'details/:petId',
        component: DetailsComponent,
     
      },
    ]
  },
  {
    path:'cart',
    component: CartComponent,
    pathMatch:'full'
  },
  {
    path:'lostPets',
    component: LostAndFoundComponent,
    pathMatch:'full'
  },
  {
    path:'adopt',
    component: AdoptionpageComponent,
    children:[
     
      {
        path:'list',
        component: ListComponent
      },
     
    ]

  },
  {
    path:'details/:petId',
    component: DetailsComponent,
 
  },
  {
    path:'create',
    component: CreatePetsComponent
  },
  {
    path:'user',
    component: HomePageComponent,
    pathMatch:'full'
  },
  {
    path:'order',
    component: OrderComponent,
    pathMatch:'full'
  },

  { path: 'admin', loadChildren: () => import('./pages/admin/admin.module').then(m => m.AdminModule) },
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
