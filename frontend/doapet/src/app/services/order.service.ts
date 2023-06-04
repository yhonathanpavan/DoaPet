import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError, of } from 'rxjs';
import { Order } from '../models/order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private baseUrl = 'http://localhost:8080/doapet/v1';

  constructor(private http: HttpClient) { }

  createOrder(order: Order): Observable<any> {
    return this.http.post<Order>(`${this.baseUrl}/1/orders`, order).pipe(
      catchError(error => {
        console.log('ERROR: ', error);
        return of (null)
      })
    )
  }

}
