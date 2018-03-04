import { NgModule }             from '@angular/core'
import { RouterModule, Routes } from '@angular/router'
import { SelectivePreloadingStrategy } from "./selective-preloading-strategy"
import { PermissionGuard   } from './common/util/PermissionGuard'
import { LocalStorage } from './common/storage/local.storage'


const appRoutes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
	{ 
    path: 'login',  
    loadChildren: 'app/login/login.module#LoginModule'
  },
  { 
     path: 'app',
     canActivate:[PermissionGuard],  
     loadChildren: 'app/main/main.module#MainModule'
  }
]

@NgModule({
  imports: [
   RouterModule.forRoot(appRoutes,{preloadingStrategy: null, useHash:true})
  ],
  exports: [
    RouterModule
  ]
})

export class AppRoutingModule {}
