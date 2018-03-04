import { Component, OnInit,ViewEncapsulation,ViewChild,ElementRef } from '@angular/core'
import { HttpService } from '../../common/util/http.service'
import { Router } from '@angular/router'

@Component({
  selector: 'c-sitecfg-notice',
  templateUrl: './link.component.html',
  styleUrls: ['./link.component.scss'],
  encapsulation: ViewEncapsulation.None
})

export class LinkComponent implements OnInit {

  linkList:string
  pageInfo:string
	constructor(private router: Router,private httpService: HttpService,private el: ElementRef) {

	}

  ngOnInit() {
  	this.getLinkList()
  }

  getLinkList() {
  	let that = this
  		/*this.httpService.get("http://localhost:8081/admin/linklist", {
  	}, function (successful, data, res) {
      if (successful) {
        if (data.flag!='1000') {
        	that.linkList = data.pageInfo.infoList
        }
      }
    }, function (successful, msg, err) {
    	console.log(err);
    })*/
  }

  edit() {
    this.router.navigate(['/app/sitecfg/link-edit'])
  }

  toAdd(){
    this.router.navigate(['/app/sitecfg/link-add'])
  }

  add(){
   
  }

  page() {
  	this.linkList = null
  }
}
