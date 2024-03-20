import { TestBed } from '@angular/core/testing';

import { VehicledataService } from './vehicledata.service';

describe('VehicledataService', () => {
  let service: VehicledataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VehicledataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
