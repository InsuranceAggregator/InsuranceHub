import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateCustomersComponent } from './update-customers.component';

describe('UpdateCustomersComponent', () => {
  let component: UpdateCustomersComponent;
  let fixture: ComponentFixture<UpdateCustomersComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UpdateCustomersComponent]
    });
    fixture = TestBed.createComponent(UpdateCustomersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
