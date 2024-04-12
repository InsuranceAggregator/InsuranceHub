import { ComponentFixture, TestBed } from '@angular/core/testing';
 
import { CustomerSupportComponent } from './customer-support.component';
 
describe('CustomerSupportComponent', () => {
  let component: CustomerSupportComponent;
  let fixture: ComponentFixture<CustomerSupportComponent>;
 
  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CustomerSupportComponent]
    });
    fixture = TestBed.createComponent(CustomerSupportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });
 
  it('should create', () => {
    expect(component).toBeTruthy();
  });
});