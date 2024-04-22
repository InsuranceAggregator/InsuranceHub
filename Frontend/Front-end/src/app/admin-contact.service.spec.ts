import { TestBed } from '@angular/core/testing';

import { AdminContactService } from './admin-contact.service';

describe('AdminContactService', () => {
  let service: AdminContactService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdminContactService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
