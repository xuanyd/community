import { NgModule }   from '@angular/core'
import { CommonModule }       from '@angular/common'
import { FormsModule, ReactiveFormsModule} from "@angular/forms"
import { NgbModule } from '@ng-bootstrap/ng-bootstrap'
import { LocalStorage } from '../common/storage/local.storage'
import { LoginComponent }   from './login.component'

import { LoginRoutingModule } from './login.routing.module'

@NgModule({
  imports:      [
     CommonModule, 
     FormsModule,
     ReactiveFormsModule,
     NgbModule,
     LoginRoutingModule
  ],
  declarations: [
     LoginComponent
  ],
  exports:      [],
  providers:    [
    LocalStorage
  ]
})
export class LoginModule { }
