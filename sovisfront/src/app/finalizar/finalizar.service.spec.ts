import { TestBed, inject } from '@angular/core/testing';

import { FinalizarService } from './finalizar.service';

describe('FinalizarService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FinalizarService]
    });
  });

  it('should be created', inject([FinalizarService], (service: FinalizarService) => {
    expect(service).toBeTruthy();
  }));
});
