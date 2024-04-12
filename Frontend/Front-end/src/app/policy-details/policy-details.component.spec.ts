import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PolicyDetailsComponent } from './policy-details.component';

describe('PolicyDetailsComponent', () => {
  let component: PolicyDetailsComponent;
  let fixture: ComponentFixture<PolicyDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PolicyDetailsComponent]
    });
    fixture = TestBed.createComponent(PolicyDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
