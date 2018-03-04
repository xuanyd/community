import { NgModule }   from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CommunityComponent } from './community.component';
import { PlateComponent } from './plate/plate.component';
import { HotComponent } from './hot/hot.component';

const communityRoutes: Routes = [
  {
    path: '', component: CommunityComponent,
    children: [
      {
        path:'plate',
        component:PlateComponent
      },
      {
        path:'hot',
        component:HotComponent
      }
    ]
  }
]

@NgModule({
  imports: [
    RouterModule.forChild(communityRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class CommunityRoutingModule { }