import { TestBed } from '@angular/core/testing';

import { UpdateClaimService } from './update-claim.service';

describe('UpdateClaimService', () => {
  let service: UpdateClaimService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UpdateClaimService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
