import { Component, NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { DatePipe } from '@angular/common'; // Import DatePipe

import { ProfileEditComponent } from './profile-edit/profile-edit.component';
import { HomepageComponent } from './homepage/homepage.component';
import { DataDisplayComponent } from './data-display/data-display.component';
import { PostCustomerComponent } from './components/post-customer/post-customer.component';
import { GetAllCustomersComponent } from './components/get-all-customers/get-all-customers.component';

import { UpdateCustomersComponent } from './components/update-customers/update-customers.component';
import { UserService } from './user.service';
import { UserDataService } from './user-data.service'
import { PolicyDetailsComponent } from './policy-details/policy-details.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { OtpVerificationComponent } from './otp-verification/otp-verification.component';
import { PasswordResetSuccessComponent } from './password-reset-success/password-reset-success.component';
import { RouterModule, Routes } from '@angular/router';
import { EmailResolver, PasswordResetService } from './password-reset.service';
import { HomeBuy1DetailsComponent } from './home-buy1-details/home-buy1-details.component';
import { HomeBuy2DetailsComponent } from './home-buy2-details/home-buy2-details.component';
import { VehicleBuy1DetailsComponent } from './vehicle-buy1-details/vehicle-buy1-details.component';
import { VehicleBuy2DetailsComponent } from './vehicle-buy2-details/vehicle-buy2-details.component';
import { CustomerDetailsComponent } from './customer-details/customer-details.component';
import { CustomerSupportComponent } from './customer-support/customer-support.component';

import { PaymentGatewayComponent } from './payment-gateway/payment-gateway.component';
import { ActivePoliciesComponent } from './active-policies/active-policies.component';
import { ClaimFormComponent } from './claim-form/claim-form.component';
import { ExistingClaimsComponent } from './existing-claims/existing-claims.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { AdminSupportComponent } from './admin-support/admin-support.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { LandingpageComponent } from './landing-page/landing-page.component';
import { AdminClaimComponent } from './admin-claim/admin-claim.component';
import { PolicyListComponent } from './policy-list/policy-list.component';
import { AddPolicyComponent } from './add-policy/add-policy.component';
import { UpdatePolicyComponent } from './update-policy/update-policy.component';
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
    LoginComponent,
    RegisterComponent,
    HomepageComponent,
    ProfileEditComponent,
    DataDisplayComponent,
    PostCustomerComponent,
    GetAllCustomersComponent,
    UpdateCustomersComponent,
    PolicyDetailsComponent,
    ForgotPasswordComponent,
    OtpVerificationComponent,
    PasswordResetSuccessComponent,
    HomeBuy1DetailsComponent,
    HomeBuy2DetailsComponent,
    VehicleBuy1DetailsComponent,
    VehicleBuy2DetailsComponent,
    CustomerDetailsComponent,
    CustomerSupportComponent,
    PaymentGatewayComponent,
    ActivePoliciesComponent,
    ClaimFormComponent,
    ExistingClaimsComponent,
    AdminDashboardComponent,
    AdminLoginComponent,
    AdminSupportComponent,
    UserDetailsComponent,
    LandingpageComponent,
    AdminClaimComponent,
    PolicyListComponent,
    AddPolicyComponent,
    UpdatePolicyComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forChild(routes)
  ],
  exports: [RouterModule],
  providers: [UserService,provideClientHydration(),PasswordResetService,DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
