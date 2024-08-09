import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from './loginService';
import { JwtHelper } from 'angular2-jwt';
import { Data } from 'app/data';
import { DatePipe } from '@angular/common'
import { CurrentUserService } from 'app/profiles/currentUserService';
import { RoleGuardService } from 'app/shared/AuthGuard/RoleGuardService';

declare const $: any;

@Component({
	selector: 'ehr-home-login',
	templateUrl: './login.component.html',
	styleUrls: ['../home.component.css']
})
export class LoginComponent implements OnInit {
	loginForm: FormGroup;
	test: Date = new Date();
	errorMessage: String;
	statusCode: number;
	jwtHelper: JwtHelper = new JwtHelper();
	lastVisitedURL: string;
	isExpired: boolean = true;
	paymentStatus: string;
	userRole: string;
	staffId: number;


	constructor(private formBuilder: FormBuilder,
		private router: Router,
		private sharedData: Data,
		public datepipe: DatePipe,
		private roleguard: RoleGuardService,
		private currentUserService: CurrentUserService,
		private loginService: LoginService) { }

	ngOnInit() {
		//localStorage.clear();
		this.loginForm = this.formBuilder.group({
			userName: [null, [Validators.required, Validators.minLength(3)]],
			password: [null, Validators.required]
		});
		this.checkExpiry();
	}

	isFieldValid(form: FormGroup, field: string) {
		return !form.get(field).valid && form.get(field).touched;
	}


	onLogin(userName, password) {
		this.preProcessConfigurations();
		if (this.loginForm.valid) {
			$('#signIn').prop('disabled', true);
			this.loginService.login(userName, password)
				.subscribe(() => {
					this.roleguard.roleCheck()
						.subscribe(successCode => {
							this.statusCode = successCode;
							if (this.statusCode === 200) {
								this.router.navigate(['/dashboard/dashboardView']);
							}
							else {
								this.router.navigate(['/dashboard']);
							}
						},
							errorCode => {
								this.statusCode = errorCode;
								this.router.navigate(['/dashboard']);
							});
				})
		}
	}

	recoverPassword() {
		this.router.navigate(['/recover']);
	}


	validateAllFormFields(formGroup: FormGroup) {
		Object.keys(formGroup.controls).forEach(field => {
			const control = formGroup.get(field);
			if (control instanceof FormControl) {
				control.markAsTouched({ onlySelf: true });
			} else if (control instanceof FormGroup) {
				this.validateAllFormFields(control);
			}
		});
	}

	handleError(error) {
		switch (error.status) {
			case 401:
		}
	}
	preProcessConfigurations() {
		this.statusCode = null;
	}

	checkExpiry() {
		let token = localStorage.getItem('jwt')
		if (token != null && this.jwtHelper.isTokenExpired(token)) {
			this.isExpired = true;
		}
		else {
			this.isExpired = false;
		}
	}
}