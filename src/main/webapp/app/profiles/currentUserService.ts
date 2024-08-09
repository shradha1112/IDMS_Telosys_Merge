
import { Injectable } from "@angular/core";
import { Http, Response, Headers, URLSearchParams, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';
import { ReturnStatement } from "@angular/compiler/src/output/output_ast";
import { AppSettings } from "../appsettings";
import { Staff } from "app/models/staff";

@Injectable()
export class CurrentUserService {

    //URLs for CRUD operation
    private getloggedInUser = AppSettings.API_ENDPOINT + "./admin/profile";
    private loginID;
    constructor(private http: Http) {
    }


    getLoggedInUserDetails(): Observable<Staff> {
		
        let cpHeaders = new Headers({ 'Content-Type': 'application/json' , "x-auth-token":localStorage.getItem('jwt')});
		//let cpParams = new URLSearchParams();
        //cpParams.set('organizationId', organizationId.toString());
        let options = new RequestOptions({ headers: cpHeaders });
    
        return this.http.get(this.getloggedInUser,options)
        .map(this.extractData)
        .catch(this.handleError);
    }

    getCurrentStaffMember(): Observable<Staff> {
        let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem("jwt") });
        let options = new RequestOptions({ headers: cpHeaders });
        return this.http.get(this.getloggedInUser, options)
            .map(this.extractData)
            .catch(this.handleError);
    }

    private extractData(res: Response) {
        let body = res.json();
        return body;
    }
    private handleError(error: Response | any) {
        console.error(error.message || error);
        return Observable.throw(error.status);
    }

}