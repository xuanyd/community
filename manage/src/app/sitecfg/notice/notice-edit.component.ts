import { Component, OnInit,AfterContentInit,OnDestroy,ViewChild,AfterViewChecked } from '@angular/core';
import { HttpService } from '../../common/util/http.service';
import { Router,ActivatedRoute } from '@angular/router';
import { Validators, FormControl, FormGroup, FormBuilder,
  FormsModule,ReactiveFormsModule } from '@angular/forms';

import { UEditorComponent } from 'ngx-ueditor';

declare const UE: any;

@Component({
  selector: 'c-sitecfg-notice',
  templateUrl: './notice-edit.component.html',
  styleUrls: ['./notice.component.scss']
})

export class NoticeEditComponent implements OnInit, AfterViewChecked {
  
  noticeEditForm: FormGroup;
  columnList:string;
  noticeId: string;
  noticeType:string;
  title:string;

  @ViewChild('full_e') 
  full_e: UEditorComponent
  full_source: string;
  config_source: string;
  config: any = {
      toolbars: [['FullScreen', 'Source', 'Undo', 'Redo', 'Bold' ]],
      autoClearinitialContent: true,
      wordCount: false
  }
  constructor(private router: Router,private acRouter: ActivatedRoute, 
    private httpService: HttpService,private formBuilder: FormBuilder) {
    this.noticeId = this.acRouter.params['value']['id'];
    let noticeTypeFc = new FormControl('', Validators.compose([Validators.required]));
    let titleFc = new FormControl('', Validators.compose([Validators.required,
      Validators.minLength(5), Validators.maxLength(15)]));
    let contentFc = new FormControl();
    this.noticeEditForm = this.formBuilder.group({
      noticeType: noticeTypeFc,
      title: titleFc,
      content: contentFc
    });
    console.log(this.full_source);
    //this.getNoticeDetail();

	}

  ngOnInit() {
    this.getColumnList();
    this.getNoticeDetail();
    
  }

  ngAfterViewInit() {
    
  }

  ngAfterViewChecked() {
    //this.getNoticeDetail();
  }

  ngOnDestroy(): void {
  }

  getNoticeDetail() {
    let that = this;
    this.httpService.request({
      method: "POST",
      url: "http://localhost:8081/admin/notice-detail",
      data: {
        id: that.noticeId
      }
    }).then(result => {
      if(result.data.flag == "1000") {
        console.log(result.data);
        that.noticeType = result.data.noticeInfo.notice_type;
        that.title = result.data.noticeInfo.title;
        that.full_source = result.data.noticeInfo.content;
      }
    });
  }

  edit() {
    if (!this.noticeEditForm.valid)
      return
    let that = this;
    this.httpService.request({
      method: "POST",
      url: "http://localhost:8081/admin/notice-edit",
      data:{
        id:that.noticeId,
        noticeType: that.noticeEditForm.value.noticeType,
        title: that.noticeEditForm.value.title,
        content: that.full_e.Instance.getContent()
      }
    }).then(result => {
      if(result.data.flag == "1000"){
        alert("保存成功");
      }
    });
  }

  getColumnList() {
    let that = this;
    this.httpService.request({
      method: "POST",
      url: "http://localhost:8081/admin/columnlist",
    }).then(result => {
      if(result.data.flag == "1000"){
        that.columnList = result.data.columnList
      }
    });
  }

  back() {
   this.router.navigate(['/app/sitecfg/notice'])
  }

}
