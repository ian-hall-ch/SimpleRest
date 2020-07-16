import { Component, OnInit } from '@angular/core';
import {
  CdkDragDrop,
  moveItemInArray,
  transferArrayItem,
} from '@angular/cdk/drag-drop';
import { Observable, of } from 'rxjs';
import { map, mergeMap, take, switchMap } from 'rxjs/operators';

import { CardService } from '../../shared/services/card.service';
import { State } from '../../../models/state';
import { Card } from '../../../models/card';
import { StateService } from 'src/app/shared/services/state.service';

@Component({
  selector: 'app-board-dashboard',
  templateUrl: './board-dashboard.component.html',
  styleUrls: ['./board-dashboard.component.scss'],
})
export class BoardDashboardComponent implements OnInit {
  state$: Observable<State>;
  stateIds: string[];

  constructor(
    private cardService: CardService,
    private stateService: StateService
  ) {}

  ngOnInit(): void {
    this.state$ = this.stateService.getAllStates();
    this.stateIds = ['0', '1', '2'];
    //this.state$.subscribe((state) => this.stateIds.push(state.id));
  }

  get getStateIds(): Observable<string> {
    return this.state$.pipe(map((state) => state.id));
  }

  onCardDrop(event: CdkDragDrop<Card[]>): void {
    if (event.previousContainer === event.container) {
      moveItemInArray(
        event.container.data,
        event.previousIndex,
        event.currentIndex
      );
    } else {
      transferArrayItem(
        event.previousContainer.data,
        event.container.data,
        event.previousIndex,
        event.currentIndex
      );
    }
  }

  onStateDrop(event: CdkDragDrop<State[]>): void {
    moveItemInArray(
      event.container.data,
      event.previousIndex,
      event.currentIndex
    );
  }
}
