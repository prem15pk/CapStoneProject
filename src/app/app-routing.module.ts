import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { CartComponent } from './cart/cart.component';
import { AdminUserComponent } from './Ccontroller/admin-user/admin-user.component';
import { AddProductComponent } from './Product/add-product/add-product.component';

const routes: Routes = [
  {
 path:'',
 component:AdminUserComponent
  },
  {
    
    path:'admine',
    component:AddProductComponent
  },
  {
    path:'product',
    component:AddProductComponent
  },
  {
    path:'cart',
    component:CartComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
