import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateVehicledataComponent } from './update-vehicledata.component';

describe('UpdateVehicledataComponent', () => {
  let component: UpdateVehicledataComponent;
  let fixture: ComponentFixture<UpdateVehicledataComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UpdateVehicledataComponent]
    });
    fixture = TestBed.createComponent(UpdateVehicledataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
