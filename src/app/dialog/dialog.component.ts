import { Component, Inject } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AdmineServiceService } from '../Service/admine-service.service';
import {MatDialogRef , MAT_DIALOG_DATA} from '@angular/material/dialog'
@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.css']
})
export class DialogComponent {
productForm : FormGroup;
actionBtn : String="save";
  constructor(private formBuilder: FormBuilder , 
             private service : AdmineServiceService,
             @Inject(MAT_DIALOG_DATA) public editData :any,
             private dialogRef :MatDialogRef<DialogComponent>){}

  ngOnInit():void{
    this.productForm = this.formBuilder.group({
      productName : ['',Validators.required],
      productAmount:['',Validators.required],
      productCategory:['',Validators.required],
      productDescription:['',Validators.required]
    });
    console.log(this.editData);
    if(this.editData){
      this.actionBtn="update";
      this.productForm.controls['productName'].setValue(this.editData.productName);
      this.productForm.controls['productAmount'].setValue(this.editData.productAmount);
      this.productForm.controls['productCategory'].setValue(this.editData.productCategory);
      this.productForm.controls['productDescription'].setValue(this.editData.productDescription);
    }
  }

  addProduct(){
    
    if(!this.editData){
      if(this.productForm.valid){
        this.service.addProducts(this.productForm.value).subscribe({
          next:(res)=>{
            alert("Product Updated")
            this.productForm.reset();
            this.dialogRef.close('save');
          },
          error:() => {
            alert("error");
          }
        })
      }
    }
    else{
      this.updateProducts()
    }
    }
    updateProducts(){
      this.service.putProducts(this.productForm.value,this.editData.id).subscribe({
        next:(res)=>{
          alert("Product Updated")
          this.productForm.reset();
          this.dialogRef.close('updated');
        },
        error:()=>{
          alert("error While Updating")
        }
        
      })
    }
}

