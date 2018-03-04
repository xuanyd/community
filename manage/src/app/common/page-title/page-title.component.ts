import {Component,Input} from '@angular/core';

@Component({
    selector: 'page-title',
    templateUrl: './page-title.component.html'
})

export class PageTitleComponent {
	@Input()
	appTitle="";
}