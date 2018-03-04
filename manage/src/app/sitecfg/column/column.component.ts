import { Component, OnInit,ViewEncapsulation,ViewChild,ElementRef } from '@angular/core'
import { HttpService } from '../../common/util/http.service'
import { Router } from '@angular/router'

@Component({
  selector: 'c-sitecfg-notice',
  templateUrl: './column.component.html',
  styleUrls: ['./column.component.scss'],
  encapsulation: ViewEncapsulation.None
})

export class ColumnComponent implements OnInit {

  columnList:string
  pageInfo:string

  subColumnShow: Array<boolean> = [true,true]
  
	constructor(private router: Router,private httpService: HttpService,private el: ElementRef) {

	}

  ngOnInit() {
  	this.getColumnList()
  }

  getColumnList() {
  	let that = this
  /*	this.httpService.get("http://localhost:8081/admin/columnlist", {
  	}, function (successful, data, res) {
      if (successful) {
        console.log(data)
        if (data.flag == '1000') {
        	that.columnList = data.columnList
          console.log(that.columnList)
        }
      }
    }, function (successful, msg, err) {
    	console.log(err);
    })*/
  }
  subColumn(event,idx) {
    this.subColumnShow[idx] = !this.subColumnShow[idx]
    console.log(event)
  }

  edit() {
    this.router.navigate(['/app/sitecfg/column-edit'])
  }

  toAdd(){
   this.router.navigate(['/app/sitecfg/column-add'])
  }

  add(){
   
  }

  page() {
  	this.columnList = null
  }
}
