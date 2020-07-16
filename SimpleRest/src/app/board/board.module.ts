import { NgModule } from '@angular/core';
import { BoardDashboardComponent } from './board-dashboard/board-dashboard.component';
import { BoardRoutingModule } from './board-routing.module';
import { SharedModule } from '../shared/shared.module';
import { CreateCardComponent } from './create-card/create-card.component';
import { CardService } from '../shared/services/card.service';
import { StateService } from '../shared/services/state.service';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [BoardDashboardComponent, CreateCardComponent],
  imports: [HttpClientModule, SharedModule, BoardRoutingModule],
  providers: [CardService, StateService],
})
export class BoardModule {}
