import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Card } from '../../../models/card';

@Injectable({
  providedIn: 'root',
})
export class CardService {
  private baseUrl = 'http://localhost:8080/v1';

  constructor(private http: HttpClient) {}

  getAllCards(): Observable<Card> {
    return this.http.get<Card>(`${this.baseUrl}/cards`);
  }

  getCard(id: number): Observable<Card> {
    return this.http.get<Card>(`${this.baseUrl}/cards/${id}`);
  }

  createCard(stateId: number, card: Card): Observable<Card> {
    return this.http.post<Card>(`${this.baseUrl}/${stateId}/cards`, card);
  }

  updateCard(cardId: number, card: Card): Observable<Card> {
    return this.http.post<Card>(`${this.baseUrl}/cards/${cardId}`, card);
  }
}
