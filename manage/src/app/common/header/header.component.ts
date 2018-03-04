import { Component, OnInit } from '@angular/core';
import { LocalStorage } from '../storage/local.storage';
import { Router } from '@angular/router';

@Component({
  selector: 'c-header-menu',
  templateUrl: './header.component.html',
  styleUrls: ['../../main/main.component.scss']
})

export class HeaderComponent implements OnInit {
  profileOpen:boolean = false;  
  headerMenus:Array<boolean> = [false, false, false];
  userName:String;

  constructor(private router: Router, private ls: LocalStorage) {
    this.userName = this.ls.getObject('userName');
  }

	ngOnInit() {
    
	}

  logout() {
    this.ls.setObject('userName', null);
    this.ls.setObject('token', null);
    this.router.navigate(["/login"]);
  }

  openHeader(idx){
    for(let i =0; i < this.headerMenus.length; i++){
      if(i == idx)
        this.headerMenus[idx] = !this.headerMenus[idx]
      else
        this.headerMenus[i] = false
    }
  }
	toggleNav() {
		alert('menu');
	}
}

