import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';

const appRoutes: Routes = [
  { path: '', redirectTo: '/main', pathMatch: 'full' },
  { 
    path: 'main',  
    loadChildren: 'app/main/main.module#MainModule'
  },
  { 
    path: 'user',  
    loadChildren: 'app/user/user.module#UserModule'
  },
  { 
    path: 'login',  
    component:LoginComponent
  }
];

@NgModule({
  imports: [
   RouterModule.forRoot(appRoutes,{preloadingStrategy: null, useHash:true})
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {}
