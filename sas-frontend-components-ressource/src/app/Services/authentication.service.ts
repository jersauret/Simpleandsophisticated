import { Injectable } from '@angular/core';
import { HttpClient,HttpClientModule, HttpHeaders } from '@angular/common/http';
import { Http, Response } from '@angular/http';  
import { Observable, of, throwError, pipe} from "rxjs"
import { map, filter, catchError, mergeMap } from 'rxjs/operators';
import { Registration } from '../Models/User.Models';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  public apiURL:string="http://localhost:8080/mvc/";

  constructor(private httpClient:HttpClient) { }

  ValidateUser (user: Registration)
  {

//http://localhost:8080/mvc/api/users/search?email='admin@sas.net'

    //var userData = "username=" + user.email + "&password=" + user.password + "&grant_type=password";
    var userData = user.email ;//+ "&password=" + user.password + "&grant_type=password";
    var reqHeader = new HttpHeaders({ 'Content-Type': 'application/json','No-Auth':'True' });
    console.log(this.apiURL+ 'api/users/email/' + 'admin@sas.net');

    return this.httpClient.get(this.apiURL+ 'api/users/search?email='+ 'admin@sas.net',{ headers: reqHeader })
    .pipe(
      map(res => res),
       catchError( this.errorHandler)
      );
  }
  getClaims ()
  {
    var reqHeader = new HttpHeaders({ 'Authorization':'Bearer '+this.getToken()});
        reqHeader.append('Content-Type', 'application/json');
    return this.httpClient.get(this.apiURL+ 'api/users',{ headers: reqHeader })
    .pipe(
      map(res => res),
       catchError( this.errorHandler)
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
