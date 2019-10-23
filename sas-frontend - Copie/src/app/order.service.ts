import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Order } from './order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  baseUrl = 'http://localhost:8080/mvc/api/orders/search?';
  corsUrl = 'http://localhost:8080/mvc/';

  constructor(private  httpClient: HttpClient) { }

  getOrder(orderNumber: string): Observable<Order> {
    const headers: HttpHeaders = new HttpHeaders()
      .set('Accept', 'application/json')
      .set('access-control-allow-origin', this.corsUrl);

    return this.httpClient.get<Order>(this.baseUrl + 'ordernumber=' + orderNumber, { headers });
  }
}
