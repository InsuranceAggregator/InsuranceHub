import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VehicleBuy2DetailsComponent } from './vehicle-buy2-details.component';

describe('VehicleBuy2DetailsComponent', () => {
  let component: VehicleBuy2DetailsComponent;
  let fixture: ComponentFixture<VehicleBuy2DetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [VehicleBuy2DetailsComponent]
    });
    fixture = TestBed.createComponent(VehicleBuy2DetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
