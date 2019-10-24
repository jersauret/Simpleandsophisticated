import { Routes } from '@angular/router';

import { SigninComponent } from './Signin/Signin.component';
import { PaymentComponent } from './Payment/Payment.component';
import { FinalReceiptComponent } from './FinalReceipt/FinalReceipt.component';
import { authGuardGuard } from 'src/app/auth.guard';

export const CheckoutRoutes : Routes = [
   {
      path : "",
      component: SigninComponent 
   },
   { 
      path: 'signin', 
      component: SigninComponent,canActivate:[authGuardGuard]
   }, 
	{ 
		path: 'payment', 
		component: PaymentComponent 
	},
   {
      path: 'final-receipt',
      component: FinalReceiptComponent
   }
]