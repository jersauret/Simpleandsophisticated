import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap'
import { HttpClient,HttpClientModule } from '@angular/common/http';
import {FormsModule,ReactiveFormsModule,Validators,FormControl,FormGroup,FormBuilder} from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProfileComponent } from './profile/profile.component';
import { AdminComponent } from './admin/admin.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ProductdisplayComponent } from './productdisplay/productdisplay.component';
import { MycartComponent } from './mycart/mycart.component';
import { FilterByCriteriaPipe } from './Pipes/filter-by-criteria.pipe';
import { ProductDisplayByCriteriaComponent } from './productDisplayByCriteria/product-display-by-criteria/product-display-by-criteria.component';

@NgModule({
  declarations: [
    AppComponent,
    ProfileComponent,
    AdminComponent,
    DashboardComponent,
    ProductdisplayComponent,
    MycartComponent,
    FilterByCriteriaPipe,
    ProductDisplayByCriteriaComponent,
  ],
  imports: [
    BrowserModule,NgbModule,FormsModule,ReactiveFormsModule,HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
