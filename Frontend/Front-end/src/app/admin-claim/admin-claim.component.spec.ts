import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminClaimComponent } from './admin-claim.component';

describe('AdminClaimComponent', () => {
  let component: AdminClaimComponent;
  let fixture: ComponentFixture<AdminClaimComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminClaimComponent]
    });
    fixture = TestBed.createComponent(AdminClaimComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
