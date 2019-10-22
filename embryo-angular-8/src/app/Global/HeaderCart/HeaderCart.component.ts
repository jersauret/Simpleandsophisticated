import { Component, OnInit, OnChanges, Input, Output, EventEmitter } from '@angular/core';
import { AuthenticationService } from 'src/app/Services/authentication.service';
import { Router } from '@angular/router';

@Component({
   selector: 'embryo-HeaderCart',
   templateUrl: './HeaderCart.component.html',
   styleUrls: ['./HeaderCart.component.scss']
})
export class HeaderCartComponent implements OnInit, OnChanges {

   @Input() cartProducts : any;
   @Input() count        : any;
   @Input() currency     : string;

   mobWidth : any;
   mobScreenSize : number = 767;

   @Output() removeProductData : EventEmitter<any> = new EventEmitter();  

   hiddenBadge = true;

   constructor(private authentication: AuthenticationService, private route: Router) {
      this.mobWidth = window.screen.width;
   }
   
   ngOnInit() {
   }

   isLogged(){
      if(this.authentication.isAuthenticated()){
         this.route.navigateByUrl('/checkout/payment');
      }else{
         this.route.navigateByUrl('/checkout');
      }
   }

   ngOnChanges() {
      if(this.count && this.count != 0) {
         this.hiddenBadge = false;
      } else {
         this.hiddenBadge = true;
      }
   }

   public confirmationPopup(product:any) {
      this.removeProductData.emit(product);
   }

   public calculatePrice(product) {
      let total = null;
      total = product.price*product.quantity;
      return total;
   }
}