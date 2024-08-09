import { Injectable } from '@angular/core';
import { Http, Response, Headers, URLSearchParams, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';
import { Department } from '../models/department';
import { AppSettings } from '..//appsettings';
import { DocumentApprovalDetails } from 'app/models/workflowApprovalDetails';


@Injectable()
export class WorkflowApprovalDetailsService {
    //URLs for CRUD operations

 	addDocApprovalURL = AppSettings.API_ENDPOINT+"./approver/addDocumentStatus";

	//Create constructor to get Http instance
	constructor(private http:Http) { 
	}


    insertDocumentStatus(approvalObj: DocumentApprovalDetails): Observable<DocumentApprovalDetails> {
        console.log("inside seervice.")
        let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token":localStorage.getItem('jwt') });
        let options = new RequestOptions({ headers: cpHeaders });
        return this.http.post(this.addDocApprovalURL, approvalObj, options)
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
