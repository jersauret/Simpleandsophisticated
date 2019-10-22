import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
	selector: 'embryo-header-user-profile',
	templateUrl: './HeaderUserProfileDropdown.component.html',
	styleUrls: ['./HeaderUserProfileDropdown.component.scss']
})

export class HeaderUserProfileDropdownComponent implements OnInit {

	isLoggedIn:boolean;

	constructor(public router : Router) { }

	ngOnInit() {
		this.isLoggedIn = true;
	}

	//log out method 
	logOut(){
		document.getElementById('html').classList.remove("admin-panel");
		this.isLoggedIn = true;
		this.router.navigate(['/session/signin']);
	}
}
