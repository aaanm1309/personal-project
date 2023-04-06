import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Task } from '../modules/task/model/task';
import { Observable } from 'rxjs';
import { API_CONFIG } from '../config/api.config';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(private http: HttpClient) { }

  findAllByUser(userId: any): Observable<Task[]> {
    return this.http.get<Task[]>(`${API_CONFIG.baseUrl}/api/task/v1/user/${userId}`);
  }

  findAllByUserMin(userId: any): Observable<Task[]> {
    return this.http.get<Task[]>(`${API_CONFIG.baseUrl}/api/task/v1/user/${userId}/min`);
  }

  findByIdAndUser(id: any, userId: any): Observable<Task[]> {
    return this.http.get<Task[]>(`${API_CONFIG.baseUrl}/api/task/v1/${userId}/user/${userId}`);
  }

}





