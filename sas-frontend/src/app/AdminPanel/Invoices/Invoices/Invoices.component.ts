import { Component, OnInit, ViewChild, Input } from '@angular/core';
import { AdminPanelServiceService } from '../../Service/AdminPanelService.service';
import { MatTableDataSource, MatPaginator } from '@angular/material';
import { Order } from 'src/app/order';
import { OrderService } from 'src/app/order.service';
import { User } from 'firebase';

@Component({
   selector: 'app-invoices',
   templateUrl: './Invoices.component.html',
   styleUrls: ['./Invoices.component.scss']
})

export class InvoicesComponent implements OnInit {

   order: Order;

   popUpDeleteUserResponse: any;
   invoiceList: Order[] = [];
   user: User;


   @ViewChild(MatPaginator, { static: false }) paginator: MatPaginator;

   dataSource = new MatTableDataSource<any>(this.invoiceList);

   displayedColumns: string[] = ['position', 'invoiceId', 'name', 'date', 'price', 'payment', 'status', 'action'];

   constructor(public service: AdminPanelServiceService, private orderService: OrderService) { }

   ngOnInit() {

      /*
           this.service.getInvoiceContent().valueChanges().subscribe(res => this.getInvoiceData(res));
      */
      /*
           this.orderService.getOrder('666').subscribe(result => {
            this.order = result;
            console.log(this.order);
            return this.order;
          });*/

    this.orderService.getOrder('666').subscribe(res => {
         this.getInvoiceDataList(res);
         this.order = this.invoiceList[0];
      console.log(this.invoiceList[0])
      console.log(this.order.orderNumber);
   });

   
   this.orderService.getOrder('666').subscribe(res => this.invoiceList.push(res));
      console.log(this.invoiceList.toLocaleString());
/*
      this.orderService.getOrder('666').subscribe(res => {this.getInvoiceData(res);
         console.log(this.getInvoiceData(res))});
*/

}



// getInvoiceData method is used to get the invoice list data.
getInvoiceData() {
   //this.invoiceList = response;
   this.dataSource = new MatTableDataSource<any>(this.invoiceList);
   setTimeout(() => {
      this.dataSource.paginator = this.paginator;
   }, 0);

}

// getInvoiceData method is used to get the invoice list data.
getInvoiceDataList(response) {
   this.invoiceList = response;
   this.dataSource = new MatTableDataSource<any>(this.invoiceList);
   setTimeout(() => {
      this.dataSource.paginator = this.paginator;
   }, 0);

}
/**
  *onDelete method is used to open a delete dialog.
  */
onDelete(i) {
   this.service.deleteDialog('Are you sure you want to delete this invoice permanently?').
      subscribe(res => { this.popUpDeleteUserResponse = res; },
         err => console.log(err),
         () => this.getDeleteResponse(this.popUpDeleteUserResponse, i));
}

/**
  * getDeleteResponse method is used to delete a invoice from the invoice list.
  */
getDeleteResponse(response: string, i) {
   if (response == 'yes') {
      this.dataSource.data.splice(i, 1);
      this.dataSource = new MatTableDataSource(this.dataSource.data);
      this.dataSource.paginator = this.paginator;
   }
}

/**
  * onSeeDialog method is used to open a see dialog.
  */
onSeeDialog() {
   this.service.seeList();
}

// applyFilter function can be set which takes a data object and filter string and returns true if the data object is considered a match.
applyFilter(filterValue: string) {
   this.dataSource.filter = filterValue.trim().toLowerCase();

   if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
   }
}
}
