import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8080/doapet/v1/auth'

  constructor(private http: HttpClient) { }

  login(email: string, password: string): Observable<any> {
    const loginData = { email, password };
    return this.http.post(`${this.apiUrl}`, loginData);
  }

  logout(): Observable<any> {
    return this.http.post(`${this.apiUrl}`, {});
  }

}
