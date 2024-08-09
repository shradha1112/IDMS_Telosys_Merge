import { Injectable } from '@angular/core';
import { Http, Response, Headers, URLSearchParams, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';
import { Department } from '../models/department';
import { AppSettings } from '..//appsettings';
import { SubDepartment } from 'app/models/subDepartment';


@Injectable()
export class DepartmentDetailsService {
    //URLs for CRUD operations
    getAllDepartmentsURL = AppSettings.API_ENDPOINT + "./department/getListOfDepartments";
    getDepartmentByIdURL = AppSettings.API_ENDPOINT + "./department/getDepartmentById";
    getAllSubDepartmentsURL = AppSettings.API_ENDPOINT + "./department/getListOfSubDepartments";
    insertDepartmentURL = AppSettings.API_ENDPOINT + "./department/createDepartment";
    updateDepartmentURL = AppSettings.API_ENDPOINT + "./department/updateDepartmentById";
    deleteDepartmentURL = AppSettings.API_ENDPOINT + "./department/removeDepartmentById";

    //Create constructor to get Http instance
    constructor(private http: Http) {
    }

    getAllDepartments(): Observable<Department[]> {
        let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
        let options = new RequestOptions({ headers: cpHeaders });
        return this.http.get(this.getAllDepartmentsURL, options)
            .map(this.extractData)
            .catch(this.handleError);
    }

    getDepartmentById(deptId: number): Observable<Department> {
        let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
        let cpParams = new URLSearchParams();
        cpParams.set('deptId', deptId.toString());

        let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
        return this.http.get(this.getDepartmentByIdURL, options)
            .map(this.extractData)
            .catch(this.handleError);
    }

    getAllSubDepartments(): Observable<SubDepartment[]> {
        let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
        let options = new RequestOptions({ headers: cpHeaders });
        return this.http.get(this.getAllSubDepartmentsURL, options)
            .map(this.extractData)
            .catch(this.handleError);
    }

    insertDepartment(docObj: Department): Observable<Department> {
        let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
        let options = new RequestOptions({ headers: cpHeaders });
        return this.http.post(this.insertDepartmentURL, docObj, options)
            .map(this.extractData)
            .catch(this.handleError);
    }

    updateDepartmentById(docObj: Department): Observable<Department> {
        let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
        let options = new RequestOptions({ headers: cpHeaders });
        return this.http.post(this.updateDepartmentURL, docObj, options)
            .map(this.extractData)
            .catch(this.handleError);
    }

    deleteDepartment(deptId: number): Observable<number> {
        let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
        let cpParams = new URLSearchParams();
        cpParams.set('deptId', deptId.toString());
        let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
        return this.http.delete(this.deleteDepartmentURL, options)
            .map(success => success.status)
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
