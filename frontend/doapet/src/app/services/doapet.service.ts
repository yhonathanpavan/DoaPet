import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError, of } from 'rxjs';

import { Ong } from '../models/ong';

@Injectable()
export class DoapetService {
  private baseUrl = 'http://localhost:8080/doapet/v1';

  constructor(private http: HttpClient) { }

  getAllOng(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/ongs`);
  }

  getOngById(ongId: number) {
    return this.http.get(`${this.baseUrl}/ongs/${ongId}`)
  }

  createOng(ong: Ong): Observable<any> {
    return this.http.post<Ong>(`${this.baseUrl}/ongs`, ong).pipe(
      catchError(error => {
        console.log('ERROR:', error);
        return of(null);
      })
    )
  }
}
