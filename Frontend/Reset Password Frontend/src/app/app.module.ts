import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { RouterModule, Routes } from '@angular/router';


import { EmailResolver, PasswordResetService } from './password-reset.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { PasswordResetSuccessComponent } from './password-reset-success/password-reset-success.component';
import { OtpVerificationComponent } from './otp-verification/otp-verification.component';
const routes: Routes = [
  {
    path: 'password-reset-success',
    component: PasswordResetSuccessComponent,
    resolve: { email: EmailResolver } // Add the resolver to delay component activation
  }
];
@NgModule({
  declarations: [
    AppComponent,
    ForgotPasswordComponent,
    OtpVerificationComponent,
    PasswordResetSuccessComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    RouterModule.forChild(routes)
  ],
  exports: [RouterModule],
  providers: [
    provideClientHydration(),
    PasswordResetService // Add PasswordResetService to the providers array
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
