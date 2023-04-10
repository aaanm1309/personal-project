import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Task, TaskCreate } from '../modules/task/model/task';
import { Observable } from 'rxjs';
import { API_CONFIG } from '../config/api.config';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(private http: HttpClient) { }

  findAllByUser(userId: any): Observable<Task[]> {
    return this.http.get<Task[]>
    (`${API_CONFIG.baseUrl}/api/task/v1/user/${userId}`)
    .pipe(
      res => res, 
      err => {
        console.log(err);
        return err;}
    );
  }

  findAllByUserMin(userId: any): Observable<Task[]> {
    return this.http.get<Task[]>
    (`${API_CONFIG.baseUrl}/api/task/v1/user/${userId}/min`)
    .pipe(
      res => res, 
      err => {
        console.log(err);
        return err;}
    );
  }

  findByIdAndUser(id: any, userId: any): Observable<Task[]> {
    return this.http.get<Task[]>
    (`${API_CONFIG.baseUrl}/api/task/v1/${id}/user/${userId}`)
    .pipe(
      res => res, 
      err => {
        console.log(err);
        return err;}
    );
  }

  addTaskList(task: TaskCreate): Observable<Task> {
    return this.http.post<Task>
          (`${API_CONFIG.baseUrl}/api/task/v1/`,task)
          .pipe(
            res => res, 
            err => {
              console.log(err);
              return err;}
          );
  }

  deleteItemFromTaskList(key: number): Observable<any> {
    const pathUrl  = `${API_CONFIG.baseUrl}/api/task/v1/${key}`;
    // console.log(pathUrl);
    return this.http.delete(pathUrl).pipe( res => res, 
      err => {
        console.log(err); 
        return err;});

  }

  deleteAllItensFromTaskList(userId: any) {
    const pathUrl  = `${API_CONFIG.baseUrl}/api/task/v1/user/${userId}`;
    // console.log(pathUrl);
    return this.http.delete(pathUrl);
  }

}





