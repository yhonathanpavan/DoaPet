import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, catchError, of } from 'rxjs';
import { Product } from '../models/product';

@Injectable()
export class ProductService {

  private baseUrl = 'http://localhost:8080/doapet/v1';

  constructor(private http: HttpClient) { }

  getCategories(): Observable<any> {
    return this.http.get(`${this.baseUrl}/products/categories`);
  };

  getMeasurements(): Observable<any> {
    return this.http.get(`${this.baseUrl}/products/measures`);
  };

  createProduct(token: string, product: Product): Observable<any> {
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });

    return this.http.post<Product>(`${this.baseUrl}/products`, product, { headers: headers }).pipe(
      catchError(error => {
        console.log('ERROR: ', error);
        return of (null);
      })
    )
  };

  getAllProducts(token: string): Observable<any> {
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });

    return this.http.get(`${this.baseUrl}/products`, { headers: headers })
  }
}
