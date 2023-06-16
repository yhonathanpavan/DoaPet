import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, catchError, of } from 'rxjs';
import { Assistance } from '../models/assistance';

@Injectable()
export class AssistanceService {

  private baseUrl = 'http://localhost:8080/doapet/v1';

  constructor(private http: HttpClient) { }

  getCategories(): Observable<any> {
    return this.http.get(`${this.baseUrl}/assistances/categories`)
  }

  createAssistance(token: string, assistance: Assistance): Observable<any> {
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });

    return this.http.post<Assistance>(`${this.baseUrl}/assistances`, assistance, { headers: headers }).pipe(
      catchError(error => {
        console.log('ERROR: ', error);
        return of (null);
      })
    )
  };

  getAllAssistance(token: string): Observable<any> {
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });

    return this.http.get(`${this.baseUrl}/assistances`, { headers: headers })
  }

}
