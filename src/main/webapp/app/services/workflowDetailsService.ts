import { Injectable } from '@angular/core';
import { Http, Response, Headers, URLSearchParams, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';
import { AppSettings } from '..//appsettings';
import { DocumentApprovalDetails } from 'app/models/workflowApprovalDetails';
import { Workflow } from 'app/models/workflow';


@Injectable()
export class WorkflowDetailsService {
    //URLs for CRUD operations

    uploadDocumentURL = AppSettings.API_ENDPOINT + "./workflow/uploadDocument";
    getAllDocumentsUrl = AppSettings.API_ENDPOINT + "./workflow/getListOfDocuments";
    getPendingDocumentsUrl = AppSettings.API_ENDPOINT + "./workflow/getPendingDocuments";

    //Create constructor to get Http instance
    constructor(private http: Http) {
    }

    uploadDocument(docObj: Workflow): Observable<Workflow> {
        //console.log("inside seervice.")
        let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
        let options = new RequestOptions({ headers: cpHeaders });
        return this.http.post(this.uploadDocumentURL, docObj, options)
            .map(this.extractData)
            .catch(this.handleError);
    }

    getAllDocuments(): Observable<Workflow[]> {
        let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
        //let cpParams = new URLSearchParams();
        //cpParams.set('organizationId', organizationId.toString());
        let options = new RequestOptions({ headers: cpHeaders });
        return this.http.get(this.getAllDocumentsUrl, options)
            .map(this.extractData)
            .catch(this.handleError);
    }

    getPendingDocuments(): Observable<Workflow[]> {
        let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
        //let cpParams = new URLSearchParams();
        //cpParams.set('organizationId', organizationId.toString());
        let options = new RequestOptions({ headers: cpHeaders });
        return this.http.get(this.getPendingDocumentsUrl, options)
            .map(this.extractData)
            .catch(this.handleError);
    }

    private extractData(res: Response) {
        let body = res.json();
        return body;
    }
    private handleError(error: Response | any) {
        //		console.error(error.message || error);
        return Observable.throw(error.status);
    }

}

