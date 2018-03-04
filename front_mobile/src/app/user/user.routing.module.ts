import { NgModule }   from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserComponent }  from './user.component';
import { LoginComponent }  from './login/login.component';
import { HomeComponent } from './home/home.component';

const userRoutes: Routes = [
  {
    path: '', component: UserComponent,
    children: [
      {
        path:'login',
        component:LoginComponent
      },
      {
        path:'home',
        component:HomeComponent
      }
    ]
  }
]

@NgModule({
  imports: [
    RouterModule.forChild(userRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class UserRoutingModule { }