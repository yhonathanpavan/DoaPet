import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, catchError, of } from 'rxjs';
import axios from 'axios';
import { AxiosResponse } from 'axios';

import { Ong } from '../models/ong';

@Injectable()
export class OngService {
  private baseUrl = 'http://localhost:8080/doapet/v1';

  constructor(private http: HttpClient) { }

  getAllOng(token: string): Observable<any> {
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });

    return this.http.get<any>(`${this.baseUrl}/ongs`, { headers: headers });
  };

  getOngById(token: string, ongId: number): Observable<any>{
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });

    return this.http.get(`${this.baseUrl}/ongs/${ongId}`, { headers: headers })
  };

  createOng(ong: Ong): Observable<any> {
    return this.http.post<Ong>(`${this.baseUrl}/ongs`, ong).pipe(
      catchError(error => {
        console.log('ERROR: ', error);
        return of(null);
      })
    )
  };

  updateOng(url: string, ong: Ong, token: string,) {
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);


    return this.http.patch(url, ong, { headers });
  }
}
