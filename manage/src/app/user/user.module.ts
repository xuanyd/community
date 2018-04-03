import { NgModule }   from '@angular/core'
import { UserComponent }   from './user.component'
import { UserRoutingModule  } from './user.routing.module'
import { LocalStorage } from '../common/storage/local.storage'


@NgModule({
  imports:      [
     UserRoutingModule
  ],
  declarations: [
     UserComponent
  ],
  exports:      [
  ],
  providers:    [LocalStorage]
})

export class UserModule { }

