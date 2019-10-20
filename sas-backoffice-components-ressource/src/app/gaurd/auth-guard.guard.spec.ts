import { TestBed, async, inject } from '@angular/core/testing';
import { authGuardGuard } from './auth-guard.guard';

describe('Gaurd\authGuardGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [authGuardGuard]
    });
  });

  it('should ...', inject([authGuardGuard], (guard: authGuardGuard) => {
    expect(guard).toBeTruthy();
  }));
});
