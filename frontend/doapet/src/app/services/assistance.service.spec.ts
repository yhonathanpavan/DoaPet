/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { AssistanceService } from './assistance.service';

describe('Service: Assistance', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AssistanceService]
    });
  });

  it('should ...', inject([AssistanceService], (service: AssistanceService) => {
    expect(service).toBeTruthy();
  }));
});
