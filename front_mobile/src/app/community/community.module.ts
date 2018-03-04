import { NgModule }   from '@angular/core';
import { CommonModule }       from '@angular/common';
import { FormsModule, ReactiveFormsModule} from "@angular/forms";
import { CommunityRoutingModule } from './community.routing.module';
import { CommunityComponent } from './community.component';
import { PlateComponent } from './plate/plate.component';
import { HotComponent } from './hot/hot.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    CommunityRoutingModule
  ],
  declarations: [
    CommunityComponent,
    PlateComponent,
    HotComponent
  ],
  exports: [
  ],
  providers: []
})

export class CommunityModule {
}
