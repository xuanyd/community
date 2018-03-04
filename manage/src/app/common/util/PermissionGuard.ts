import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { LocalStorage } from '../storage/local.storage';

@Injectable()
export class PermissionGuard implements CanActivate{
	constructor(private ls: LocalStorage) {}
	canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): boolean {
  	if(this.ls.getObject('userName') == null || this.ls.getObject('token') == null){
  		return false;
  	}
    return true
  }
}