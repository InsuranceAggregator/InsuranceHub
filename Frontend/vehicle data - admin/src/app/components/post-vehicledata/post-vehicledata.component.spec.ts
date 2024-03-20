import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PostVehicledataComponent } from './post-vehicledata.component';

describe('PostVehicledataComponent', () => {
  let component: PostVehicledataComponent;
  let fixture: ComponentFixture<PostVehicledataComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PostVehicledataComponent]
    });
    fixture = TestBed.createComponent(PostVehicledataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
