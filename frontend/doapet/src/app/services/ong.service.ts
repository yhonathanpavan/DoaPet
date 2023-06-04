import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError, of } from 'rxjs';
import axios from 'axios';
import { AxiosResponse } from 'axios';

import { Ong } from '../models/ong';

@Injectable()
export class OngService {
  private baseUrl = 'http://localhost:8080/doapet/v1';

  constructor(private http: HttpClient) { }

  getAllOng(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/ongs`);
  };

  getOngById(ongId: number) {
    return this.http.get(`${this.baseUrl}/ongs/${ongId}`)
  };

  createOng(ong: Ong): Observable<any> {
    return this.http.post<Ong>(`${this.baseUrl}/ongs`, ong).pipe(
      catchError(error => {
        console.log('ERROR: ', error);
        return of(null);
      })
    )
  };

  updateOng(url: string, ong: Ong) {
    return this.http.patch(url, ong);
  }
}
