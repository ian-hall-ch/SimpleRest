import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';

import { BoardDashboardComponent } from './board-dashboard/board-dashboard.component';

const routes: Routes = [
  {
    path: 'dashboard',
    component: BoardDashboardComponent,
  },
];

@NgModule({
  imports: [CommonModule, RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class BoardRoutingModule {}
