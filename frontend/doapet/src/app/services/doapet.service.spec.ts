/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { DoapetService } from './doapet.service';

describe('Service: Doapet', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DoapetService]
    });
  });

  it('should ...', inject([DoapetService], (service: DoapetService) => {
    expect(service).toBeTruthy();
  }));
});
