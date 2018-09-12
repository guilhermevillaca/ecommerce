import { TestBed, inject } from '@angular/core/testing';

import { ItensVendaService } from './itens-venda.service';

describe('ItensVendaService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ItensVendaService]
    });
  });

  it('should be created', inject([ItensVendaService], (service: ItensVendaService) => {
    expect(service).toBeTruthy();
  }));
});
