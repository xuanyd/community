import { Component, OnInit } from '@angular/core';
import { Router,ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit{

  menuClick: boolean = false;
  hotSelect: boolean = true;

  constructor(private router: Router){

  }
  
  ngOnInit() {

  }

  clickMenu() {
    this.menuClick = !this.menuClick;
  }

  changePath(path) {
    this.menuClick = false;
    if(path === 'hot'){
      if(this.hotSelect == true)
        return;
      this.hotSelect = true;
      this.router.navigate(['/main/community/hot']);
    } else if(path === 'plate'){
      if(this.hotSelect == false)
        return;
      this.hotSelect = false;
      this.router.navigate(['/main/community/plate']);
    } 
  }
}
