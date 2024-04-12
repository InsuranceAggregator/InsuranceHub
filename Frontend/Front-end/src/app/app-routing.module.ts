import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomepageComponent } from './homepage/homepage.component';
import { ProfileEditComponent } from './profile-edit/profile-edit.component';
import { DataDisplayComponent } from './data-display/data-display.component';
import { PostCustomerComponent } from './components/post-customer/post-customer.component';
import { GetAllCustomersComponent } from './components/get-all-customers/get-all-customers.component';
import { UpdateCustomersComponent } from './components/update-customers/update-customers.component';
import { PolicyDetailsComponent } from './policy-details/policy-details.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { OtpVerificationComponent } from './otp-verification/otp-verification.component';
import { PasswordResetSuccessComponent } from './password-reset-success/password-reset-success.component';
import { HomeBuy1DetailsComponent } from './home-buy1-details/home-buy1-details.component';
import { HomeBuy2DetailsComponent } from './home-buy2-details/home-buy2-details.component';
import { VehicleBuy1DetailsComponent } from './vehicle-buy1-details/vehicle-buy1-details.component';
import { VehicleBuy2DetailsComponent } from './vehicle-buy2-details/vehicle-buy2-details.component';
import { CustomerDetailsComponent } from './customer-details/customer-details.component';
import { CustomerSupportComponent } from './customer-support/customer-support.component';
import { PaymentGatewayComponent } from './payment-gateway/payment-gateway.component';



const routes: Routes = [
  { path: 'register', component: RegisterComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent }, // Define your login component route
  { path: 'homepage', component: HomepageComponent },
  { path: 'policydetails', component: PolicyDetailsComponent },
  { path: 'edit-profile', component: ProfileEditComponent },
  { path: 'data-display', component: DataDisplayComponent },
 // { path: '', redirectTo: '/data', pathMatch: 'full' },
  {path:'customer', component:PostCustomerComponent},
  {path: 'getallcustomers',component: GetAllCustomersComponent },
  {path: "customer/:id",component: UpdateCustomersComponent},
  { path: 'ForgotPassword',component: ForgotPasswordComponent}, // Default route
    { path: 'otp', component: OtpVerificationComponent },
    { path: 'password-reset/reset-password', component: PasswordResetSuccessComponent },
    { path: 'home-buy1' , component: HomeBuy1DetailsComponent },
   { path: 'home-buy2' , component: HomeBuy2DetailsComponent },
  { path: 'vehicle-buy1', component: VehicleBuy1DetailsComponent},
  { path: 'vehicle-buy2', component: VehicleBuy2DetailsComponent},
  { path: 'customer-details', component: CustomerDetailsComponent},
  { path: 'customer-support', component: CustomerSupportComponent },
  { path: 'paymentGateway', component: PaymentGatewayComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: []
})
export class AppRoutingModule { }
