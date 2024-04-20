import { TestBed } from '@angular/core/testing';

import { ExistingClaimService } from './existing-claim.service';

describe('ExistingClaimService', () => {
  let service: ExistingClaimService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExistingClaimService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
