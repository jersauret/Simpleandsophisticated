import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule, HttpHeaders } from '@angular/common/http';
import { Http, Response } from '@angular/http';
import { Observable, of, throwError, pipe } from "rxjs"
import { map, filter, catchError, mergeMap } from 'rxjs/operators';
import { AuthenticationService } from './authentication.service';
import { Product } from '../Models/Product.Model';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  public apiURL: string = "http://localhost:8080/mvc/api/products";

  constructor(private httpClient: HttpClient, private authService: AuthenticationService) { }

  saveProductInfo(product: any) {
    var reqHeader = new HttpHeaders({ 'Authorization': 'Bearer ' + this.authService.getToken(), 'Access-Control-Allow-Origin':'*',});
    reqHeader.append('Content-Type', 'application/json');
    const formData: FormData = new FormData();
    formData.append('UnitPrice', product['Price']);
    formData.append('Name', product.name.toString());
    formData.append('SellerId', product.SellerId.toString());
    formData.append('SellerName', product.SellerName.toString());
    formData.append('Category', product.categoryType.toString());
    formData.append('TC', product['Conditions']);
    formData.append('Quantity', product.Quantity.toString());
    formData.append('Description', product.Description.toString());
    formData.append('Image', product.urlImage.toString());


    return this.httpClient.post(this.apiURL, formData, { headers: reqHeader })
      .pipe(
        map(res => res),
        catchError(this.errorHandler)
      );
  }
  getAllProducts() {
    return this.httpClient.get(this.apiURL)
      .pipe(
        map(res => res),
        catchError(this.errorHandler)
      );
  }
  addProductToCart(product: any) {
    localStorage.setItem("product", JSON.stringify(product));
  }
  getProductFromCart() {
    //return localStorage.getItem("product");
    return JSON.parse(localStorage.getItem('product'));
  }
  removeAllProductFromCart() {
    return localStorage.removeItem("product");
  }
  errorHandler(error: Response) {
    console.log(error);
    return throwError(error);
  }
}
