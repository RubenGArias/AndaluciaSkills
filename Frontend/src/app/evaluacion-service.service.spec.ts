import { TestBed } from '@angular/core/testing';

import { EvaluacionServiceService } from './evaluacion-service.service';

describe('EvaluacionServiceService', () => {
  let service: EvaluacionServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EvaluacionServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
