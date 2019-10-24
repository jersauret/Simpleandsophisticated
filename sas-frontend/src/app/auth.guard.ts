import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class authGuardGuard implements CanActivate {

  constructor(public auth: AuthenticationService, public router: Router) {}

  canActivate(): boolean {
    if (!this.auth.isAuthenticated()) {
      //this.router.navigate(['login']);
      console.log('You do not have the authorization to view this page')
      return false;
    }
    return true;
  }

}
