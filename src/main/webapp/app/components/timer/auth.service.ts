import { Injectable } from '@angular/core';
import { Subject, Observable } from 'rxjs';
import { Router } from '@angular/router';
import { routerNgProbeToken } from '@angular/router/src/router_module';

@Injectable()
export class AuthService {
  constructor(private router:Router)
  {

  }

  _userActionOccured: Subject<void> = new Subject();
  get userActionOccured(): Observable<void> { return this._userActionOccured.asObservable() };

  notifyUserAction() {
    this._userActionOccured.next();
  }

  loginUser() {
    //console.log('user login');
  }

  logOutUser() {
    //console.log('user logout');
    localStorage.removeItem('jwt');
    this.router.navigate(['./login']);
  
  }

}