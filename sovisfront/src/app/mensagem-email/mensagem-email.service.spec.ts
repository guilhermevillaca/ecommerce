import { TestBed, inject } from '@angular/core/testing';

import { MensagemEmailService } from './mensagem-email.service';

describe('MensagemEmailService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MensagemEmailService]
    });
  });

  it('should be created', inject([MensagemEmailService], (service: MensagemEmailService) => {
    expect(service).toBeTruthy();
  }));
});
