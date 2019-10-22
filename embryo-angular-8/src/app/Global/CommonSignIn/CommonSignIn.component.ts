import { Component, OnInit, Input } from '@angular/core';
import { SharedService } from 'src/app/Services/shared.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { FormBuilder, FormGroup } from '@angular/forms';
import { RegistrationService } from 'src/app/Services/Registration.Service';
import { AuthenticationService } from 'src/app/Services/authentication.service';
import { Router } from '@angular/router';
import { Registration } from 'src/app/Models/user';
import { IAlert } from 'src/app/app.component';

@Component({
  selector: 'embryo-SignIn',
  templateUrl: './CommonSignIn.component.html',
  styleUrls: ['./CommonSignIn.component.scss']
})
export class CommonSignInComponent implements OnInit {

  closeResult: string;
  registrationForm: FormGroup;
  loginForm: FormGroup;
  registrationInputs: Registration[];
  currentUser: Registration;
  isLoggedIn: boolean = false;

  username:string = '';
  password:string = '';

  cartItemCount: number = 0;
  approvalText: string = "";

  @Input()
  public alerts: Array<IAlert> = [];

  message = "";
  public globalResponse: any;
  ismodelShown: boolean;

  constructor(private sharedService: SharedService, private modalService: NgbModal,
    private fb: FormBuilder, private regService: RegistrationService, private authService: AuthenticationService,
    private router: Router) { }

  ngOnInit() {
  }

  Login() {
    this.isLoggedIn = false;
    this.authService.removeToken();
    this.alerts = [];
    console.log(this.username+' '+this.password);
    this.authService.ValidateUser(this.username, this.password)
      .subscribe((result) => {
        this.globalResponse = result;
      },
        error => { //This is error part
          console.log(error.message);
          this.alerts.push({
            id: 2,
            type: 'danger',
            message: 'Either user name or password is incorrect.'
          });
        },
        () => {
          //  This is Success part
           console.log(this.globalResponse.access_token);
          this.authService.storeToken(this.globalResponse.access_token);
          this.alerts.push({
            id: 1,
            type: 'success',
            message: 'Login successful. Now you can close and proceed further.',
          });
          this.isLoggedIn = true;
          this.GetClaims();
          this.ismodelShown=true;
          this.router.navigateByUrl('/checkout/payment');
        }
      )
  }

  GetClaims() {
    this.authService.getClaims()
      .subscribe((result) => {
        this.globalResponse = result;
      },
        error => { //This is error part
          console.log(error.message);
        },
        () => {
          //  This is Success part
          // console.log(this.globalResponse );
          let a = this.globalResponse;
          this.currentUser = this.globalResponse;
          this.authService.storeRole(this.currentUser.role);
          console.log(this.currentUser.role);
        }
      )

  }

}
