import { Component, OnInit } from '@angular/core';
import { Router,ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-main',
  templateUrl: './plate.component.html',
  styleUrls: ['./plate.component.css']
})
export class PlateComponent implements OnInit{

  constructor(private router: Router){

  }
  
  ngOnInit() {

  }

  changePath(path) {
    if (path == 'userCenter') {
      this.router.navigate(['/main/user/home']);
    }
  }
}
