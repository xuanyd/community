import { Component, OnInit } from '@angular/core';
import { Router,ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit{

  menuClick: boolean = false;

  constructor(private router: Router){

  }
  
  ngOnInit() {

  }

  clickMenu() {
    this.menuClick = !this.menuClick;
  }

  /*changePath(path) {
    if(path === 'home'){
      this.homeSelect = true;
      this.mySelect = false;
      this.router.navigate(['/main/community/hot']);
    } else if(path === 'my'){
      this.homeSelect = false;
      this.mySelect = true;
      this.router.navigate(['/main/user/home']);
    } 
  }*/
}
