import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { DialogComponent } from '../dialog/dialog.component';
import { OrderComponent } from '../order/order.component';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  delete(id: number) {
    throw new Error('Method not implemented.');
  }

  baseUrl:string ="http://localhost:8080/api/cart/"

  constructor(private http :HttpClient , private dialog : MatDialog) { }

  getProducts(){
    return this.http.get<any>(`${this.baseUrl}`);
  }

  removeProduct(id:number){
       return this.http.delete<any>(`${this.baseUrl}`+id);
  }

  openDialog() {
    this.dialog.open(OrderComponent, {
      width:"40%",
      
    }).afterClosed().subscribe(val=>{
      
    })
  }
}
