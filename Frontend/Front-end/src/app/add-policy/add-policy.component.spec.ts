import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddPolicyComponent } from './add-policy.component';

describe('AddPolicyComponent', () => {
  let component: AddPolicyComponent;
  let fixture: ComponentFixture<AddPolicyComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddPolicyComponent]
    });
    fixture = TestBed.createComponent(AddPolicyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
