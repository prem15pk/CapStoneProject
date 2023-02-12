import { Component, ViewChild , OnInit } from '@angular/core';
import { MatDialog , MAT_DIALOG_DATA} from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { DialogComponent } from 'src/app/dialog/dialog.component';
import { AdmineServiceService } from 'src/app/Service/admine-service.service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent {

  dataSource!: MatTableDataSource<any>;
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  constructor(private service :AdmineServiceService , private dialog : MatDialog){}
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


  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
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

  getAllProducts(){
    
  }
  

  deleteProduct(id:number){
    console.log(id);
  this.service.deleteProduct(id).subscribe({
    next:(res)=>{
      alert("Deleted Sucessfully");
      this.getAllProducts();
    
    },
    error:()=>{
      
      this.getAllProducts();
    }
    
  })
    }

    

}
