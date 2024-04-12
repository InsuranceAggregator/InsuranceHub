import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VehicleBuy1DetailsComponent } from './vehicle-buy1-details.component';

describe('VehicleBuy1DetailsComponent', () => {
  let component: VehicleBuy1DetailsComponent;
  let fixture: ComponentFixture<VehicleBuy1DetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [VehicleBuy1DetailsComponent]
    });
    fixture = TestBed.createComponent(VehicleBuy1DetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
