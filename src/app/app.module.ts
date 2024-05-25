import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SignupComponent } from './pages/sign-uppage/signup/signup.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatToolbarModule} from '@angular/material/toolbar';
import { NavbarComponent } from './navbar/navbar.component';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatCardModule} from '@angular/material/card';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { ShoppageComponent } from './pages/shoppage/shoppage.component';
import { authInterceptorProviders } from './services/auth.interceptor';;
import { CartComponent } from './pages/cart/cart.component';
import {MatDividerModule} from '@angular/material/divider';
import {MatListModule} from '@angular/material/list';
import { DetailsComponent } from './pages/details/details.component';
import {MatDialogModule} from '@angular/material/dialog';
import { BuypageComponent } from './pages/buypage/buypage.component';
import { CarouselModule } from 'ngx-owl-carousel-o';
import { HttpClientModule } from '@angular/common/http';
import { LoginpageComponent } from './pages/loginPage/loginpage/loginpage.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { SidebarComponent } from './pages/admin/sidebar/sidebar.component';
import { AddProductsComponent } from './pages/admin/add-products/add-products.component';
import { EditProductsComponent } from './pages/admin/edit-products/edit-products.component';
import { AdoptionpageComponent } from './pages/adoptionpage/adoptionpage/adoptionpage.component';
import { ListComponent } from './pages/pets-list/list/list.component';
import { CreatePetsComponent } from './pages/pets-list/create/create-pets.component';
import {MatSelectModule} from '@angular/material/select';
import { OrderComponent } from './pages/order/order.component';
import { MatMenuModule } from '@angular/material/menu';
import { BuyProductComponent } from './pages/buy-product/buy-product.component';
import { LostAndFoundComponent } from './pages/lost-and-found/lost-and-found.component';
import { FooterComponent } from './footer/footer.component';




@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    NavbarComponent,
    HomePageComponent,
    ShoppageComponent,
    CartComponent,
    DetailsComponent,
    BuypageComponent,
    LoginpageComponent,
    DashboardComponent,
    SidebarComponent,
    EditProductsComponent,
    AdoptionpageComponent,
    ListComponent,
    CreatePetsComponent,
    OrderComponent,
    BuyProductComponent,
    LostAndFoundComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatFormFieldModule,
    MatCardModule,
    FormsModule,
    ReactiveFormsModule,
    MatInputModule,
    MatDividerModule,
    MatListModule,
    MatDialogModule,
    CarouselModule,
    HttpClientModule,
    MatSelectModule,
    MatMenuModule,
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
