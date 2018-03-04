import { NgModule }   from '@angular/core'
import { CommonModule }       from '@angular/common'
import {FormsModule, ReactiveFormsModule} from "@angular/forms"
import { MainComponent }   from './main.component'
import { MainRoutingModule } from './main.routing.module'

@NgModule({
  imports:      [
     CommonModule, 
     FormsModule,
     ReactiveFormsModule,
     MainRoutingModule
  ],
  declarations: [
     MainComponent
  ],
  exports:      [],
  providers:    [
  ]
})
export class MainModule { }
