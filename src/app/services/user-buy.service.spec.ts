import { TestBed } from '@angular/core/testing';

import { UserBuyService } from './user-buy.service';

describe('UserBuyService', () => {
  let service: UserBuyService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserBuyService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
