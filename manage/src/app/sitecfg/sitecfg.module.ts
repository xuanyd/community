import { NgModule }   from '@angular/core';
import { CommonModule }       from '@angular/common';
import { FormsModule, ReactiveFormsModule} from "@angular/forms";
import { SiteCfgRoutingModule } from './sitecfg.routing.module';
import { SiteCfgComponent } from './sitecfg.component';
import { NoticeComponent } from './notice/notice.component';
import { NoticeEditComponent } from './notice/notice-edit.component';
import { NoticeAddComponent } from './notice/notice-add.component';
import { ColumnComponent } from './column/column.component';
import { ColumnAddComponent } from './column/column-add.component';
import { ColumnEditComponent } from './column/column-edit.component';
import { UEditorModule } from 'ngx-ueditor';
import { LinkComponent } from './link/link.component';
import { LinkAddComponent } from './link/link-add.component';
import { SelectTreeComponent } from '../common/select-tree';
import { ConfirmComponent } from '../common/confirm';
import { PageComponent } from '../common/page';
import { GridComponent } from '../common/grid';
import { ModalComponent } from '../common/modal';
@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    SiteCfgRoutingModule,
    UEditorModule.forRoot({
        path: '../assets/ueditor/',
        options: {
          themePath: '../assets/ueditor/themes/'
        }
    })
  ],
  declarations: [
    SiteCfgComponent,
    SelectTreeComponent,
    ConfirmComponent,
    NoticeComponent,
    PageComponent,
    GridComponent,
    ModalComponent,
    NoticeEditComponent,
    NoticeAddComponent,
    ColumnComponent,
    ColumnAddComponent,
    ColumnEditComponent,
    LinkComponent,
    LinkAddComponent
  ],
  exports: [
  ],
  providers: []
})

export class SiteCfgModule {
}
