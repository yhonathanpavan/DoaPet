import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, catchError, of } from 'rxjs';
import { Order } from '../models/order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private baseUrl = 'http://localhost:8080/doapet/v1';

  constructor(private http: HttpClient) { }

  createOrder(token: string, order: Order, ongId: number): Observable<any> {
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });

    return this.http.post<Order>(`${this.baseUrl}/ongs/${ongId}/orders`, order, { headers: headers }).pipe(
      catchError(error => {
        console.log('ERROR: ', error);
        return of (null)
      })
    )
  }

  getById(token: string, ongId: number) {
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });

    return this.http.get(`${this.baseUrl}/ongs/${ongId}/orders`, { headers: headers })
  }

}
