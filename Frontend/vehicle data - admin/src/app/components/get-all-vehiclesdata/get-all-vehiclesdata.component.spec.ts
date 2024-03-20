import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllVehiclesdataComponent } from './get-all-vehiclesdata.component';

describe('GetAllVehiclesdataComponent', () => {
  let component: GetAllVehiclesdataComponent;
  let fixture: ComponentFixture<GetAllVehiclesdataComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GetAllVehiclesdataComponent]
    });
    fixture = TestBed.createComponent(GetAllVehiclesdataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
