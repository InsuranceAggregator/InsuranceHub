import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PasswordResetSuccessComponent } from './password-reset-success.component';

describe('PasswordResetSuccessComponent', () => {
  let component: PasswordResetSuccessComponent;
  let fixture: ComponentFixture<PasswordResetSuccessComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PasswordResetSuccessComponent]
    });
    fixture = TestBed.createComponent(PasswordResetSuccessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
