import { NgModule }   from '@angular/core'
import { RouterModule, Routes } from '@angular/router'
import { TestComponent } from './test.component'
import { LayoutComponent }   from './layout.component'

const testRoutes: Routes = [
  {
    path: '', component: TestComponent,
    children: [
      {
        path:'layout',
        component:LayoutComponent
      }
    ]
  }
]

@NgModule({
  imports: [
    RouterModule.forChild(testRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class TestRoutingModule { }