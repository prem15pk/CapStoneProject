import { Component, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { OrderComponent } from '../order/order.component';
import { CartService } from '../Service/cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent {

  constructor(private service :CartService , private dialog : MatDialog){}

  dataSource!: MatTableDataSource<any>;
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  displayedColumns: string[] = ['productName', 'productAmount', 'productCategory', 'productDescription' , 'action'];

  ngOnInit(){
    this.service.getProducts().subscribe({
      next:(res)=>{
        console.log(res)
        this.dataSource = new MatTableDataSource(res);
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort;
          
      },
      error:(err)=>{
         alert("Error While Fetching")
      }
    })
  }

  deleteProduct(id:number){
    
  this.service.removeProduct(id).subscribe({
    next:(res)=>{
        this.dataSource = new MatTableDataSource(res);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
    },
    error:(err)=>{
      alert("removed")
    }
  })
    }

    
    
    openDialog() {
      this.dialog.open(OrderComponent, {
        data: {
          width:"500px",
        },
      });
    }
  

}
