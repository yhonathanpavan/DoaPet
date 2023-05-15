/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { OngService } from './ong.service';

describe('Service: Ong', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [OngService]
    });
  });

  it('should ...', inject([OngService], (service: OngService) => {
    expect(service).toBeTruthy();
  }));
});
