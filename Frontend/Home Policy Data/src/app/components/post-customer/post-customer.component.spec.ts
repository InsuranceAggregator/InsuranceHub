import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PostCustomerComponent } from './post-customer.component';

describe('PostCustomerComponent', () => {
  let component: PostCustomerComponent;
  let fixture: ComponentFixture<PostCustomerComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PostCustomerComponent]
    });
    fixture = TestBed.createComponent(PostCustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
