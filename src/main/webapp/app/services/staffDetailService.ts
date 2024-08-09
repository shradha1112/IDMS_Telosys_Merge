
import { Injectable } from '@angular/core';
import { Http, Response, Headers, URLSearchParams, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';
import { Department } from '../models/department';
import { AppSettings } from '..//appsettings';
import { Project } from 'app/models/project';
import { Staff } from 'app/models/staff';


@Injectable()
export class StaffDetailsService {
    //URLs for CRUD operations
     getAllStaffMembersUrl = AppSettings.API_ENDPOINT+"./admin/getListOfStaffMembers";
    //Create constructor to get Http instance
	constructor(private http:Http) { 
	}


    getAllStaffMembers(): Observable<Staff[]> {
		
        let cpHeaders = new Headers({ 'Content-Type': 'application/json' , "x-auth-token":localStorage.getItem('jwt')});
		//let cpParams = new URLSearchParams();
        //cpParams.set('organizationId', organizationId.toString());
		let options = new RequestOptions({ headers: cpHeaders });
        return this.http.get(this.getAllStaffMembersUrl,options)
        .map(this.extractData)
        .catch(this.handleError);
    }

    private extractData(res: Response) {
	    let body = res.json();
        return body;
    }
    private handleError (error: Response | any) {
		console.error(error.message || error);
		return Observable.throw(error.status);
    }
}
