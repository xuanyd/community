import { NgModule, OnInit } from '@angular/core';
import { RouterModule, Routes, Router } from '@angular/router';

import { UserComponent }   from './user.component';

/**
 * 主体路由
 */
const userRoutes: Routes = [
  {
    path: '',
    component: UserComponent
  }
];

@NgModule({
  imports: [
    RouterModule.forChild(userRoutes)
  ],
  exports: [
    RouterModule
  ]
})

export class UserRoutingModule { }


