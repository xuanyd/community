import { NgModule, OnInit } from '@angular/core';
import { RouterModule, Routes, Router } from '@angular/router';
import { MainComponent }   from './main.component';

/**
 * 主体路由
 */
const mainRoutes: Routes = [
  {
    path: '',
    component: MainComponent,
    children: [ 
      { path: 'community', loadChildren: 'app/community/community.module#CommunityModule' },
      { path: 'user', loadChildren: 'app/user/user.module#UserModule' }
    ]
  }
]

@NgModule({
  imports: [
    RouterModule.forChild(mainRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class MainRoutingModule { }
