import { Injectable } from '@angular/core';
import { CredenciaisVO } from '../models/credenciais';
import { HttpClient } from '@angular/common/http';
import { API_CONFIG } from '../config/api.config';
import { JwtHelperService } from '@auth0/angular-jwt';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  jwtService: JwtHelperService =  new JwtHelperService();

  constructor(private http:HttpClient) { }

  authenticate(creds: CredenciaisVO) {
    return this.http.post(
      `${API_CONFIG.baseUrl}/auth/signin`,
      creds,
      { observe: 'response',
        responseType: 'json' 
      })

  }

  sucessfullyLoggedIn(authToken: string, refrToken: string) {
    localStorage.setItem('token', authToken);
    localStorage.setItem('refresh', refrToken);
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
    // localStorage.setItem('token', '');
    // localStorage.setItem('refresh', '');
    localStorage.clear();
  }
}
