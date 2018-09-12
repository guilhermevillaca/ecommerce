import { TestBed, inject } from '@angular/core/testing';

import { PssFisicaService } from './pss-fisica.service';

describe('PssFisicaService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PssFisicaService]
    });
  });

  it('should be created', inject([PssFisicaService], (service: PssFisicaService) => {
    expect(service).toBeTruthy();
  }));
});
