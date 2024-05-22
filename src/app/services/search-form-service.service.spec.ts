import { TestBed } from '@angular/core/testing';

import { SearchFormServiceService } from './search-form-service.service';

describe('SearchFormServiceService', () => {
  let service: SearchFormServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SearchFormServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
