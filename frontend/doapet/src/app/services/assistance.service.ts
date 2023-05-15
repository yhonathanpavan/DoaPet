import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError, of } from 'rxjs';
import { Assistance } from '../models/assistance';

@Injectable()
export class AssistanceService {

  private baseUrl = 'http://localhost:8080/doapet/v1';

  constructor(private http: HttpClient) { }

  getCategories(): Observable<any> {
    return this.http.get(`${this.baseUrl}/assistances/categories`)
  }

  createAssistance(assistance: Assistance): Observable<any> {
    return this.http.post<Assistance>(`${this.baseUrl}/assistances`, assistance).pipe(
      catchError(error => {
        console.log('ERROR: ', error);
        return of (null);
      })
    )
  };

}
