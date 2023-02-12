import { TestBed } from '@angular/core/testing';

import { AdmineServiceService } from './admine-service.service';

describe('AdmineServiceService', () => {
  let service: AdmineServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdmineServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
