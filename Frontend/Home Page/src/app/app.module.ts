import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomepageComponent } from './homepage/homepage.component';



@NgModule({
  declarations: [
    AppComponent,
    HomepageComponent,
    
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
    /*PoliciesModule*/
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
