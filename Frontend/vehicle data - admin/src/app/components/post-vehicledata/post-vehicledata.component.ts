import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { VehicledataService } from 'src/app/service/vehicledata.service';

@Component({
  selector: 'app-post-vehicledata',
  templateUrl: './post-vehicledata.component.html',
  styleUrls: ['./post-vehicledata.component.css']
})
export class PostVehicledataComponent {

  postVehicledataForm!: FormGroup;

  constructor(private vehicledataService: VehicledataService, private fb: FormBuilder){}

  ngOnInit(){
  this.postVehicledataForm = this.fb.group({
    policyNumber: [null, [Validators.required]],
    vehicleType: [null, [Validators.required]],
    vehicleRegistrationNumber: [null, [Validators.required]],
    vehicleModel: [null, [Validators.required]],
  })
}
postVehicledata(){
  console.log(this.postVehicledataForm.value);
  this.vehicledataService.postVehicledata(this.postVehicledataForm.value).subscribe((res)=>{
    console.log(res);
  })
}
}
