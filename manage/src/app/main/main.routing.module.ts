import { NgModule, OnInit } from '@angular/core'
import { RouterModule, Routes, Router } from '@angular/router'
import { MainComponent }   from './main.component'

/**
 * 主体路由
 */
const mainRoutes: Routes = [
  {
    path: '',
    component: MainComponent,
    children: [
      { path: 'home', loadChildren: 'app/home/home.module#HomeModule' },
      { path: 'sitecfg', loadChildren: 'app/sitecfg/sitecfg.module#SiteCfgModule' },
      { path: 'test', loadChildren: 'app/test/test.module#TestModule' }
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