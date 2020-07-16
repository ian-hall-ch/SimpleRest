import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { State } from '../../../models/state';

@Injectable({
  providedIn: 'root',
})
export class StateService {
  private baseUrl = 'http://localhost:8080/v1';

  constructor(private http: HttpClient) {}

  getAllStates(): Observable<State> {
    return this.http.get<State>(`${this.baseUrl}/states`);
  }

  getState(id: number): Observable<State> {
    return this.http.get<State>(`${this.baseUrl}/states/${id}`);
  }

  createState(state: State): Observable<State> {
    return this.http.post<State>(`${this.baseUrl}/states`, state);
  }

  updateState(stateId: number, state: State): Observable<State> {
    return this.http.post<State>(`${this.baseUrl}/states/${stateId}`, state);
  }
}
