import { Observable } from "rxjs/Observable";
import { Injectable } from "@angular/core";
import { Http, Response, Headers, RequestOptions } from "@angular/http";
import { AppSettings } from '../../appsettings';


@Injectable()
export class LoginService {

    constructor(private http: Http) { }

    updateStaffLastActionURL = AppSettings.API_ENDPOINT + "./admin/modifyStaffMemberLastActionById";
    updateStaffPaymentDetailsURL = AppSettings.API_ENDPOINT + "./payment/modifyStaffPaymentDetails";
    getStaffPaymentStatusURL = AppSettings.API_ENDPOINT + "./admin/getPaymentInfo";
    updateLoginTimeURL = AppSettings.API_ENDPOINT + "./payment/setUserLoginTime";
    updateLogoutTimeURL = AppSettings.API_ENDPOINT + "./payment/setUserLogoutTime";
    getLoginStatusURL = AppSettings.API_ENDPOINT + "./payment/getUserLoginStatus";

    login(userName, password): Observable<Response> {
        let loginRequest = JSON.stringify({ loginId: userName, loginKey: password });
        let headers = new Headers({ 'Content-Type': 'application/json', 'Accept': 'application/json' });
        headers.append('Access-Control-Allow-Headers', 'Content-Type');
        return this.http.post(AppSettings.API_AUTH_ENDPOINT + './auth/login', loginRequest)
            .do(resp => {
                localStorage.setItem('jwt', resp.headers.get('x-auth-token'));            
            }).catch(this.handleError);
    }

    private extractData(res: Response) {
		let body = res.json();
		return body;
    }
    
    private handleError(error: Response | any) {
        return Observable.throw(error.status);
    }

    isSignedIn(): boolean {
        return localStorage.getItem('jwt') !== null;
    }
}
