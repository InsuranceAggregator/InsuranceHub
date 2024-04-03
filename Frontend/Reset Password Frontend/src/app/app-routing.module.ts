import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { OtpVerificationComponent } from './otp-verification/otp-verification.component';
import { PasswordResetSuccessComponent } from './password-reset-success/password-reset-success.component';

const routes: Routes = [
  { path: '', 
  component: ForgotPasswordComponent
  }, // Default route
    { path: 'otp', component: OtpVerificationComponent },
    { path: 'password-reset/reset-password', component: PasswordResetSuccessComponent } // Add route for PasswordResetSuccessComponent
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
