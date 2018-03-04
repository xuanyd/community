import { Injectable } from '@angular/core';
@Injectable()
export class ActiveTitleService {
	private title = "xxx"
  getTitle() {
    return this.title;
  }

  setTitle(title){
  	this.title = title;
  }
}

