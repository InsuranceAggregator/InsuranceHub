import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PolicyListComponent } from './policy-list.component';

describe('PolicyListComponent', () => {
  let component: PolicyListComponent;
  let fixture: ComponentFixture<PolicyListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PolicyListComponent]
    });
    fixture = TestBed.createComponent(PolicyListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
