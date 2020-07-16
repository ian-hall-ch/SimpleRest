import { NgModule } from '@angular/core';
import { DragDropModule } from '@angular/cdk/drag-drop';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatDialogModule } from '@angular/material/dialog';
import { MatToolbarModule } from '@angular/material/toolbar';

@NgModule({
  declarations: [],
  imports: [
    DragDropModule,
    MatButtonModule,
    MatCardModule,
    MatDialogModule,
    MatToolbarModule,
  ],
  exports: [
    DragDropModule,
    MatButtonModule,
    MatCardModule,
    MatDialogModule,
    MatToolbarModule,
  ],
})
export class MaterialModule {}
