import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/authentication.service';

@Component({
  selector: 'embryo-SignIn',
  templateUrl: './CommonSignIn.component.html',
  styleUrls: ['./CommonSignIn.component.scss']
})
export class CommonSignInComponent implements OnInit {

  username:string = '';
  password:string = '';
  isLoggedIn: boolean;
  authService: AuthenticationService;
  public globalResponse: any;
  ismodelShown: boolean;
  
  constructor(authService: AuthenticationService) { 
    this.authService = authService;
  }

  ngOnInit() {
  }

  Login() {
    this.isLoggedIn = false;
    this.authService.removeToken();
    console.log(this.username+' '+this.password);
    this.authService.ValidateUser(this.username, this.password)
      .subscribe((result) => {
        this.globalResponse = result;
      },
        error => { //This is error part
          console.log(error.message);
          
        },
        () => {
          //  This is Success part
           console.log(this.globalResponse.access_token);
          this.authService.storeToken(this.globalResponse.access_token);
          
          this.isLoggedIn = true;
          this.authService.getClaims();
          this.ismodelShown=true;
        }
      )
  }

}
