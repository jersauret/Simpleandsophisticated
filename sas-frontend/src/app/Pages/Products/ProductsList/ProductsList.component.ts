import { Component, OnInit, ViewChild} from '@angular/core';
import { Router, ActivatedRoute, Params }   from '@angular/router';
import { Observable ,  Subscription } from 'rxjs';

import { EmbryoService } from '../../../Services/Embryo.service';
import { MatPaginator, MatSort, MatTableDataSource } from '@angular/material';
import { TranslateService } from '@ngx-translate/core';
import { AdminPanelServiceService } from 'src/app/AdminPanel/Service/AdminPanelService.service';

@Component({
  selector: 'app-ProductsList',
  templateUrl: './ProductsList.component.html',
  styleUrls: ['./ProductsList.component.scss']
})
export class ProductsListComponent implements OnInit {

   type          : any;
   pips          : boolean = true;
   tooltips      : boolean = true;
   category      : any;
   pageTitle     : string;
   subPageTitle  : string;

   public subscribers: any = {};
   
   constructor(private route: ActivatedRoute,
               private router: Router, 
               public embryoService : EmbryoService,
               public translate : TranslateService,
					private adminPanelService : AdminPanelServiceService) {
   }

   ngOnInit() {
      this.route.params.subscribe(params => {
         this.route.queryParams.forEach(queryParams => {
            this.category = queryParams['category'];
            this.type   = null;
            this.type = params['type'];

            this.getPageTitle();
         });   
      });
      this.adminPanelService.getProducts().valueChanges().subscribe(res => this.getProductResponse(res));

   }

   public searchByName(){
      
   }

   public getPageTitle() {
      this.pageTitle = null;
      this.subPageTitle = null;
      
      switch (this.type || this.category) {
         case undefined:
            this.pageTitle = "Products";
            this.subPageTitle="Discover our products.";
            break;

         case "gadgets":
            this.pageTitle = "Gadgets";
            this.subPageTitle="Check out our new gadgets.";
            break;

         case "accessories":
            this.pageTitle = "Accessories";
            this.subPageTitle="Choose the wide range of best accessories.";
            break;
         
         default:
            this.pageTitle = "Products";
            this.subPageTitle = null;
            break;
      }
   }

   public addToCart(value) {
      this.embryoService.addToCart(value);
   }

   public addToWishList(value) {
      this.embryoService.addToWishlist(value);
   }
   
   public transformHits(hits) {
      hits.forEach(hit => {
         hit.stars = [];
         for (let i = 1; i <= 5; i) {
           hit.stars.push(i <= hit.rating);
           i += 1;
         }
      });
      return hits;
   }


	productsList 		      : any;
	productsGrid 			   : any;
	popUpDeleteUserResponse : any;
	showType	    				: string = 'grid';
	displayedProductColumns : string [] = ['id', 'image','name','brand','category', 'product_code', 'discount_price', 'price','action' ];
	@ViewChild(MatPaginator,{static: false}) paginator : MatPaginator;
	@ViewChild(MatSort,{static: false}) sort           : MatSort;

	//getProductResponse method is used to get the response of all products.
 	public getProductResponse(response) {
      this.productsGrid = null;
      let products = ((response.men.concat(response.women)).concat(response.gadgets)).concat(response.accessories);
      this.productsGrid = products;
   }

  	/**
	  * productShowType method is used to select the show type of product.
	  */
	productShowType(type) {
		this.showType = type;
		if(type == 'list'){
			document.getElementById('list').classList.add("active");
			document.getElementById('grid').classList.remove('active');
			this.productsList = new MatTableDataSource(this.productsGrid);
			setTimeout(()=>{
				this.productsList.paginator = this.paginator;
				this.productsList.sort = this.sort;
			},0)
			
		}
		else{
			document.getElementById('grid').classList.add("active");
			document.getElementById('list').classList.remove('active');
		}
	}

	/**
	  * onEditProduct method is used to open the edit page and edit the product.
	  */
	onEditProduct(data){
		this.router.navigate(['/admin-panel/product-edit',data.type,data.id]);
		this.adminPanelService.editProductData = data;
	}

	/* 
     *deleteProduct method is used to open a delete dialog.
     */
   deleteProduct(i){
      this.adminPanelService.deleteDialog("Are you sure you want to delete this product permanently?").
         subscribe( res => {this.popUpDeleteUserResponse = res},
                    err => console.log(err),
                    ()  => this.getDeleteResponse(this.popUpDeleteUserResponse,i))
   }

   /**
     * getDeleteResponse method is used to delete a product from the product list.
     */
   getDeleteResponse(response : string,i){
      if(response == "yes"){
      	if(this.showType == 'grid') {
         	this.productsGrid.splice(i,1);
      	}else if(this.showType == 'list'){
				this.productsList.data.splice(i,1);
				this.productsList = new MatTableDataSource(this.productsList.data);
      		this.productsList.paginator = this.paginator;
      	}
      }
   }

}
