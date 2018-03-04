import { NgModule }   from '@angular/core'
import { HomeComponent }   from './home.component'
import { HomeRoutingModule  } from './home.routing.module'
import { LocalStorage } from '../common/storage/local.storage'


@NgModule({
  imports:      [
     HomeRoutingModule
  ],
  declarations: [
     HomeComponent
  ],
  exports:      [
  ],
  providers:    [LocalStorage]
})

export class HomeModule { }

