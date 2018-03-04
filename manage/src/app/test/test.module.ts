import { NgModule }   from '@angular/core'
import { CommonModule }  from '@angular/common'
import { TestComponent } from './test.component'
import { LayoutComponent }   from './layout.component'
import { TestRoutingModule  } from './test.routing.module'
// import { SelectTreeComponent } from '../common/select-tree'
// import { ModalComponent } from '../common/modal'
// import { ConfirmComponent } from '../common/confirm'
// import { GridComponent } from '../common/grid'

@NgModule({
  imports:      [ 
    CommonModule,
    TestRoutingModule
  ],
  declarations: [
    TestComponent,
    //SelectTreeComponent,
    //ModalComponent,
    //ConfirmComponent,
    //GridComponent,
    LayoutComponent
  ],
  exports:      [ 
  ],
  providers:    []
})

export class TestModule { }

