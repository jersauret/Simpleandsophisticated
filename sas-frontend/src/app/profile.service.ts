import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Profile } from './profile';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  baseUrl = 'http://localhost:8080/mvc/api/users';
  corsUrl = 'http://localhost:8080/mvc/';

  constructor(private  httpClient: HttpClient) { }

  getClient(id: number): Observable<Profile> {
    const headers: HttpHeaders = new HttpHeaders()
      .set('Accept', 'application/json')
      .set('access-control-allow-origin', this.corsUrl);

    return this.httpClient.get<Profile>(this.baseUrl + '/' + id, { headers });
  }
}
