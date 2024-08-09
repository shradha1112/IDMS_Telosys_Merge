import { Injectable } from '@angular/core';
import { Http, Response, Headers, URLSearchParams, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';
import { Department } from '../models/department';
import { AppSettings } from '..//appsettings';
import { Project } from 'app/models/project';


@Injectable()
export class ProjectDetailsService {
    //URLs for CRUD operations
    getAllProjectsUrl = AppSettings.API_ENDPOINT + "./admin/getListOfProjects";
    //Create constructor to get Http instance
    constructor(private http: Http) {
    }


    getAllProjects(): Observable<Project[]> {
        let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
        let options = new RequestOptions({ headers: cpHeaders });
        return this.http.get(this.getAllProjectsUrl, options)
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
