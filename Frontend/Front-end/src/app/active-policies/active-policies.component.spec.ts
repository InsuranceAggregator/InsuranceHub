import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActivePoliciesComponent } from './active-policies.component';

describe('ActivePoliciesComponent', () => {
  let component: ActivePoliciesComponent;
  let fixture: ComponentFixture<ActivePoliciesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ActivePoliciesComponent]
    });
    fixture = TestBed.createComponent(ActivePoliciesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
