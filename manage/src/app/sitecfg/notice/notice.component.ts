import { Component, OnInit,Output, 
  ViewEncapsulation,ViewChild,ElementRef } from '@angular/core';
import { HttpService } from '../../common/util/http.service';
import { Router } from '@angular/router';
import { Pagination } from '../../common/page/pagination';
import { ModalConfirm } from '../../common/confirm/modal-confirm';

@Component({
  selector: 'c-sitecfg-notice',
  templateUrl: './notice.component.html',
  styleUrls: ['./notice.component.scss'],
  encapsulation: ViewEncapsulation.None
})

export class NoticeComponent implements OnInit {

  noticeList:string;
  pageInfo:string;
  selDisabled = "disabled";
  selectId = "";
  selectTitle = "";

  @Output()
  public pagination:Pagination = Pagination.defaultPagination;
  @Output()
  public modalConfirm:ModalConfirm = ModalConfirm.defaultModalConfirm;

	constructor(private router: Router,private httpService: HttpService,private el: ElementRef) {

	}

  ngOnInit() {
  	this.getNoticeList()
    this.pagination.changePage = (() => {
      this.getNoticeList()
    })
  }

  getNoticeList() {
  	let that = this;
  	let page = this.pagination.currentPage;
    this.httpService.request({
      method: "POST",
      url: "http://localhost:8081/admin/noticelist",
      data: {
        page: page
      }
    }).then(result => {
      if(result.data.flag == "1000"){
        that.noticeList = result.data.pageInfo.infoList;
        that.pagination.totalItems = result.data.pageInfo.totalCount
      }
    });
  }

  toEdit() {
    this.router.navigate(['/app/sitecfg/notice-edit',this.selectId]);
  }

  toAdd(){
   this.router.navigate(['/app/sitecfg/notice-add']);
  }

  toDelete() {
    this.modalConfirm.show = true;
    this.modalConfirm.title = "确认删除文章";
    this.modalConfirm.content = "确认删除：“" + this.selectTitle + "”文章吗？";
    this.modalConfirm.select = (() => {
      if(this.modalConfirm.confirm) {

      }
    });
  }

  select(id, title) {
    this.selectId = id;
    this.selectTitle = title;
    this.selDisabled="";
  }

}
