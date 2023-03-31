import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { API_CONFIG } from '../config/api.config';
import { Observable } from 'rxjs';
import { Tecnico } from '../models/tecnico';

@Injectable({
  providedIn: 'root'
})
export class TecnicoService {

  constructor(private http: HttpClient) {

  }

  findById(id: any): Observable<Tecnico> {
    return this.http.get<Tecnico>(`${API_CONFIG.baseUrl}/api/technician/v1/${id}`);
  }

  findAll(): Observable<Tecnico[]> {
    return this.http.get<Tecnico[]>(`${API_CONFIG.baseUrl}/api/technician/v1/`);
  }

  create( tecnico: Tecnico) : Observable<Tecnico> {
    return this.http.post<Tecnico>(`${API_CONFIG.baseUrl}/api/technician/v1/`,tecnico);
  }

  update( tecnico: Tecnico) : Observable<Tecnico> {
    return this.http.put<Tecnico>(`${API_CONFIG.baseUrl}/api/technician/v1/${tecnico.id}`,tecnico);
  }


}
