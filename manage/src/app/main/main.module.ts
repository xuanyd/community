import { NgModule }   from '@angular/core';
import { CommonModule }       from '@angular/common';
import { MainComponent }   from './main.component';
import { HeaderComponent }   from '../common/header/header.component';
import { LeftComponent }   from '../common/left/left.component';
import { MainRoutingModule  } from './main.routing.module';
import { LocalStorage } from '../common/storage/local.storage';
import { PageTitleComponent } from "../common/page-title/page-title.component";
import { ActiveTitleService } from "../common/page-title/active-title.service";

@NgModule({
  imports:      [
    CommonModule,
    MainRoutingModule
  ],
  declarations: [
     MainComponent,
     HeaderComponent,
     LeftComponent, 
     PageTitleComponent
  ],
  exports:      [],
  providers:    [LocalStorage,ActiveTitleService]
})

export class MainModule { }

