import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PostVehicledataComponent } from './components/post-vehicledata/post-vehicledata.component';

const routes: Routes = [
  {path : 'vehicledata' , component : PostVehicledataComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
