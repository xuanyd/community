import { Component, OnInit } from '@angular/core';
import { Router,ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-main',
  templateUrl: './hot.component.html',
  styleUrls: ['./hot.component.css']
})
export class HotComponent implements OnInit{

  constructor(private router: Router){

  }
  
  ngOnInit() {

  }

  toPlage() {
  	this.router.navigate(['/main/community/plate']);
  }
}
