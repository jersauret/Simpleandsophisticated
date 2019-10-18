import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Order } from './order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  baseUrl = 'http://localhost:8080/Projet_Fil_Rouge/api/orders';
  corsUrl = 'http://localhost:8080/Projet_Fil_Rouge/';

  constructor(private  httpClient: HttpClient) { }

  getOrder(id: number): Observable<Order> {
    const headers: HttpHeaders = new HttpHeaders()
      .set('Accept', 'application/json')
      .set('access-control-allow-origin', this.corsUrl);

    return this.httpClient.get<Order>(this.baseUrl + '/' + id, { headers });
  }
}
