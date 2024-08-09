import { Injectable } from "@angular/core";
import { AppSettings } from "app/appsettings";
import { Observable } from "rxjs";
import { Http, Response, Headers, URLSearchParams, RequestOptions, ResponseContentType } from '@angular/http';


@Injectable()
export class DashboardService{

    str:  string;
    DashboardPref: string;

    updateDashboardPreferenceURL = AppSettings.API_ENDPOINT+"./ccmsummary/updateDashboardPref";
    getDashboardPreferenceURL = AppSettings.API_ENDPOINT+"./ccmsummary/getLastDashboardPref";

    constructor(private http:Http) {}

    private extractData(res: Response) {
	    let body = res.json();
        return body;
    }
    
    private handleError (error: Response | any) {
		console.error(error.message || error);
		return Observable.throw(error.status);
    }
    
}