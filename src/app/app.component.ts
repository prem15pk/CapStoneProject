import { Component, OnInit ,ViewChild } from '@angular/core';
import {MatDialog, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { DialogComponent } from './dialog/dialog.component';
import { AdmineServiceService } from './Service/admine-service.service';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'Medicare';
  displayedColumns: string[] = ['productName', 'productAmount', 'productCategory', 'productDescription' , 'action'];
  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

    constructor(private dialog : MatDialog , 
      private service :AdmineServiceService){}
      ngOnInit(): void {
        this.getAllProducts();
      }
  openDialog() {
    this.dialog.open(DialogComponent, {
      width:"40%",
      
    }).afterClosed().subscribe(val=>{
      if(val=='save'){
        this.getAllProducts();
      }
    })
  }
  editProducts(row:any){
    this.dialog.open(DialogComponent,{
      width:'30%',
      data:row
    }).afterClosed().subscribe(val=>{
      if(val=='updated'){
        this.getAllProducts();
      }
    })
  }

deleteProduct(id:number){
  console.log(id);
this.service.deleteProduct(id).subscribe({
  next:(res)=>{
    alert("Deleted Sucessfully");
    
  },
  error:()=>{
    
    this.getAllProducts();
  }
  
})
  }
  getAllProducts(){
    this.service.getProducts().subscribe({
      next:(res)=>{
        this.dataSource = new MatTableDataSource(res);
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort;
      },
      error:(err)=>{
         alert("Error While Fetching")
      }
    })
  }

  
}
