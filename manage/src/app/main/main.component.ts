import { Component, OnInit,ElementRef, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { LocalStorage } from '../common/storage/local.storage';
import { PageTitleComponent } from "../common/page-title/page-title.component";
import { ActiveTitleService } from "../common/page-title/active-title.service";


@Component({
  selector: 'c-main',
  templateUrl: './main.component.html'
})

export class MainComponent implements OnInit {
  	url:string='1';
  	appTitle = 'Hello title';
	constructor(private ls: LocalStorage, private activeTitleService: ActiveTitleService){
	this.url=ls.getObject("curl");
    this.appTitle = activeTitleService.getTitle();
		console.log(ls);
	}
	
	ngOnInit() {

	}
}
