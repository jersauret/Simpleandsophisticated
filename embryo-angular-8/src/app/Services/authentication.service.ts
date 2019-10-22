import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule, HttpHeaders } from '@angular/common/http';
import { Http, Response } from '@angular/http';
import { Observable, of, throwError, pipe } from "rxjs"
import { map, filter, catchError, mergeMap } from 'rxjs/operators';
import { Registration } from '../Models/user';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  public apiURL: string = "http://localhost:8080/mvc/";
  username: string;
  password: string;

  constructor(private httpClient: HttpClient) { }

  ValidateUser(username: string, password: string) {
    this.username = username;
    this.password = password;

    //var userData = "username=" + user.email + "&password=" + user.password + "&grant_type=password";
    var reqHeader = new HttpHeaders({ 'Content-Type': 'application/json', 'No-Auth': 'True' });
    console.log(this.apiURL + 'api/users/email?' + username + '&password=' + password);
//    return this.httpClient.get(this.apiURL + 'api/users/email?' + username  + '&password=' + '$2a$10$/CkRcxG/bbPfNHn5GYjgpuUnn/TWLVUPVLS/TIUcZxZZVE8o3XeA6', { headers: reqHeader })

    return this.httpClient.get(this.apiURL + 'api/users/email?email=' + username, { headers: reqHeader })
      .pipe(
        map(res => res),
        catchError(this.errorHandler)
      );
  }
  getClaims() {
    var reqHeader = new HttpHeaders({ 'Authorization': 'Bearer ' + this.getToken() });
    reqHeader.append('Content-Type', 'application/json');
    return this.httpClient.get(this.apiURL + 'api/users/email?email=' + this.username, { headers: reqHeader })
      .pipe(
        map(res => res),
        catchError(this.errorHandler)
      );
  }
  public isAuthenticated(): boolean {
    return this.getToken() !== null;
  }
  storeToken(token: string) {
    localStorage.setItem("token", token);
  }
  getToken() {
    return localStorage.getItem("token");
  }
  removeToken() {
    return localStorage.removeItem("token");
  }
  storeRole(role: any) {
    this.removeRole();
    localStorage.setItem('role', JSON.stringify(role));
  }
  getRole() {
    // return localStorage.getItem("role");
    return JSON.parse(localStorage.getItem('role'));
  }
  removeRole() {
    return localStorage.removeItem("role");
  }
  errorHandler(error: Response) {
    console.log(error);
    return throwError(error);
  }
}