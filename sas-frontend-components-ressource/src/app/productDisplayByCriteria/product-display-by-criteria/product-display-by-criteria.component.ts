import { Component, EventEmitter, Output,OnInit } from '@angular/core';
import { ProductDisplay } from '../../Models/ProductDisplay.Model';

import { ProductService } from '../../Services/product.service';
import { Product } from '../../Models/Product.Model';
import { IAlert } from '../../Models/IAlert';
import { SharedService } from '../../Services/shared.service';

@Component({
  selector: 'app-product-display-by-criteria',
  templateUrl: './product-display-by-criteria.component.html',
  styleUrls: ['./product-display-by-criteria.component.scss']
})
export class ProductDisplayByCriteriaComponent implements OnInit {
  public alerts: Array<IAlert> = [];
  cartItemCount: number = 0;
  @Output() cartEvent = new EventEmitter<number>();
  public globalResponse: any;
  yourByteArray:any;
  allProducts: ProductDisplay[];
  productAddedTocart:Product[];
  constructor(private productService:ProductService,private sharedService:SharedService) { }

  ngOnInit() {
    this.productService.getAllProducts()
            .subscribe((result) => {
              this.globalResponse = result;              
            },
            error => { //This is error part
              console.log(error.message);
            },
            () => {
                //  This is Success part
                console.log("Product fetched sucssesfully.");
                //console.log(this.globalResponse);
                this.allProducts=this.globalResponse;
                }
              )

 }

 getProductByCriteria() {
  //this.allProducts.filter()
}

 OnAddCart(product:Product)
            {
              console.log(product);
              
              this.productAddedTocart=this.productService.getProductFromCart();
              if(this.productAddedTocart==null)
              {
                this.productAddedTocart=[];
                this.productAddedTocart.push(product);
                this.productService.addProductToCart(this.productAddedTocart);
                this.alerts.push({
                  id: 1,
                  type: 'success',
                  message: 'Product added to cart.'
                });
                setTimeout(()=>{   
                  this.closeAlert(this.alerts);
             }, 3000);

              }
              else
              {
                let tempProduct=this.productAddedTocart.find(p=>p.id==product.id);
                if(tempProduct==null)
                {
                  this.productAddedTocart.push(product);
                  this.productService.addProductToCart(this.productAddedTocart);
                  this.alerts.push({
                    id: 1,
                    type: 'success',
                    message: 'Product added to cart. TRANQUILLEEEEE!!!!'
                  });
                  //setTimeout(function(){ }, 2000);
                  setTimeout(()=>{   
                    this.closeAlert(this.alerts);
               }, 3000);
                }
                else
                {
                  this.alerts.push({
                    id: 2,
                    type: 'warning',
                    message: 'Product already exist in cart.'
                  });
                  setTimeout(()=>{   
                    this.closeAlert(this.alerts);
               }, 3000);
                }
                
              }
              //console.log(this.cartItemCount);
              this.cartItemCount=this.productAddedTocart.length;
              // this.cartEvent.emit(this.cartItemCount);
              this.sharedService.updateCartCount(this.cartItemCount);
            }
            public closeAlert(alert:any) {
              const index: number = this.alerts.indexOf(alert);
              this.alerts.splice(index, 1);
          }   

}
