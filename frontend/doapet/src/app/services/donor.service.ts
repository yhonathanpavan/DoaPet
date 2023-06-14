import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError, of } from 'rxjs';

import { Donor } from '../models/donor';

@Injectable()
export class DonorService {
  private baseUrl = 'http://localhost:8080/doapet/v1';

  constructor(private http: HttpClient) { }

  getOngById(ongId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/donors/${ongId}`)
  }

  createDonor(donor: Donor): Observable<any> {
    return this.http.post<Donor>(`${this.baseUrl}/donors`, donor).pipe(
      catchError(error => {
        console.log('ERROR: ', error);
        return of(null);
      })
    )
  }

  updateDonor(url: string, donor: Donor) {
    return this.http.patch(url, donor)
  }

}
