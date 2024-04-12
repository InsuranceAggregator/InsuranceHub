import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeBuy2DetailsComponent } from './home-buy2-details.component';

describe('HomeBuy2DetailsComponent', () => {
  let component: HomeBuy2DetailsComponent;
  let fixture: ComponentFixture<HomeBuy2DetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HomeBuy2DetailsComponent]
    });
    fixture = TestBed.createComponent(HomeBuy2DetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
