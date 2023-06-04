import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
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

  createProduct(product: Product): Observable<any> {
    return this.http.post<Product>(`${this.baseUrl}/products`, product).pipe(
      catchError(error => {
        console.log('ERROR: ', error);
        return of (null);
      })
    )
  };

  getAllProducts(): Observable<any> {
    return this.http.get(`${this.baseUrl}/products`)
  }
}
