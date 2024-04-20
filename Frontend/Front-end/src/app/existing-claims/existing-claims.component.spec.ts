import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExistingClaimsComponent } from './existing-claims.component';

describe('ExistingClaimsComponent', () => {
  let component: ExistingClaimsComponent;
  let fixture: ComponentFixture<ExistingClaimsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ExistingClaimsComponent]
    });
    fixture = TestBed.createComponent(ExistingClaimsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
