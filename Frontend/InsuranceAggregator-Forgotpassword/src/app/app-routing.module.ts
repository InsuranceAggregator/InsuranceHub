import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OtpVerificationComponent } from './otp-verification/otp-verification.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';

const routes: Routes = [
  { path: '', 
component: ForgotPasswordComponent
}, // Default route
  { path: 'otp', component: OtpVerificationComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
