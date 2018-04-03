import { Component, OnInit, ViewEncapsulation,ViewChild,ElementRef} from '@angular/core'
import { Router } from '@angular/router'
import { Validators, FormControl, FormGroup, FormBuilder } from '@angular/forms'

@Component({
  selector: 'c-user',
  templateUrl: './user.component.html',
  styleUrls: []
})

export class UserComponent implements OnInit {
  noticeList:string;
  pageInfo:string;
  selDisabled = "disabled";
  selectId = "";
  ngOnInit() {

  }
  getUserList() {
  }

  toAdd() {

  }

  toEdit() {

  }

  toDelete() {
  }
}