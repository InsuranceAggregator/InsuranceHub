import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeBuy1DetailsComponent } from './home-buy1-details.component';

describe('HomeBuy1DetailsComponent', () => {
  let component: HomeBuy1DetailsComponent;
  let fixture: ComponentFixture<HomeBuy1DetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HomeBuy1DetailsComponent]
    });
    fixture = TestBed.createComponent(HomeBuy1DetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
