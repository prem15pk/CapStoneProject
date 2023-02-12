import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Products } from 'src/Models/Product';
@Injectable({
  providedIn: 'root'
})
export class AdmineServiceService {
  baseUrl:string ="http://localhost:8080/api/products/"

  constructor(private http :HttpClient) { }

  getProducts(){
    return this.http.get<any>(`${this.baseUrl}`);
  }
  
  addProducts(product:Products):Observable<Object>{
      return this.http.post(`${this.baseUrl}add`,product);
  }
  putProducts(data:any , id:number){
    return this.http.put<any>(`${this.baseUrl}`+id,data); 
}
deleteProduct(id:number){
return this.http.delete<any>(`${this.baseUrl}`+id);
}
}