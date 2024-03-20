import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GetAllVehiclesdataComponent } from './components/get-all-vehiclesdata/get-all-vehiclesdata.component';
import { UpdateVehicledataComponent } from './components/update-vehicledata/update-vehicledata.component';
import { PostVehicledataComponent } from './components/post-vehicledata/post-vehicledata.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule}from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    PostVehicledataComponent,
    GetAllVehiclesdataComponent,
    UpdateVehicledataComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
