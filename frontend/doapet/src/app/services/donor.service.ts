import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, catchError, of } from 'rxjs';

import { Donor } from '../models/donor';

@Injectable()
export class DonorService {
  private baseUrl = 'http://localhost:8080/doapet/v1';

  constructor(private http: HttpClient) { }

  getOngById(token: string, ongId: number): Observable<any> {
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });

    return this.http.get(`${this.baseUrl}/donors/${ongId}`, { headers: headers })
  }

  createDonor(donor: Donor): Observable<any> {
    return this.http.post<Donor>(`${this.baseUrl}/donors`, donor).pipe(
      catchError(error => {
        console.log('ERROR: ', error);
        return of(null);
      })
    )
  }

  updateDonor(url: string, donor: Donor, token: string) {
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);

    return this.http.patch(url, donor, { headers })
  }

}
