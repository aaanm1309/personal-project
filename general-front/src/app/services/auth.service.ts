import { Injectable } from '@angular/core';
import { CredenciaisVO } from '../models/credenciais';
import { HttpClient } from '@angular/common/http';
import { API_CONFIG } from '../config/api.config';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  jwtService: JwtHelperService =  new JwtHelperService();

  constructor(private http:HttpClient) { }

  authenticate(creds: CredenciaisVO): Observable<any> {
    return this.http.post<any>(
      `${API_CONFIG.baseUrl}/auth/signin`,
      creds,
      { observe: 'response',
        responseType: 'json' 
      }).pipe( res => res, 
        err => {
          console.log(err); 
          return err;})
      

  }

  sucessfullyLoggedIn(authToken: string, refrToken: string, userId?: string) {
    localStorage.setItem('token', authToken);
    localStorage.setItem('refresh', refrToken);
    localStorage.setItem('userId', userId);
  }

  isAuthenticated(): boolean {
    let token = localStorage.getItem('token');
    let refreshToken  = localStorage.getItem('refresh');
    if (token != null && refreshToken != null) {
      return !this.jwtService.isTokenExpired(token);
    }
    return false;
  }

  logOut() {
    localStorage.clear();
  }
}
