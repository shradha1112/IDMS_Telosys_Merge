import { Component, OnInit, AfterViewInit, AfterContentInit } from '@angular/core';
import { Router } from '@angular/router';
import { Data } from 'app/data';
import { NgxSpinnerService } from 'ngx-spinner';
import { LoginService } from 'app/home/login/loginService';
import { CurrentUserService } from 'app/profiles/currentUserService';

declare interface DataTable {
    headerRow: string[];
    footerRow: string[];
    dataRows: string[][];
}

declare const $: any;

@Component({
    selector: 'dms-workflowdetails',
    templateUrl: './workflowdetails.component.html',
    styleUrls: ['../../workflow/worflow.component.css', '../../app.component.css']
})

export class WorkFlowDetailsComponent implements OnInit {
    statusCode: number;
    processValidation = false;
    requestProcessing = false;
    fullName: any;
    selected: any;
    disable:boolean=false;
    userRole: string;
    tabList: any[];
    flag:boolean = false;
    viewDetails:boolean = false;
    primaryProvider: any;
    approvFlag:boolean = false;

    constructor(private router: Router,
        private sharedData: Data,
        private spinner: NgxSpinnerService) { }

    ngOnInit() {
        this.tabList = ["Related Documents","Audit Trail","Version History"]; 

        if(localStorage.getItem('status') != null){
            this.approvFlag = false;
        }else{
            this.approvFlag = true;
        }
    }

    openDetails(){
        this.flag = false;
        this.viewDetails = true;
    }

    sendNotification(){
      this.statusCode = 201;
      this.setTimeOut();
    }

    setTimeOut() {
        window.setTimeout(function () {
          $(".alert").fadeTo(2000, 500).slideUp(500, function () {
            $(".alert").slideUp(500);
          });
        }, 4000);
      }
    
    back(){
        history.back();
    }

    addNewWorkFlow(){
        this.router.navigate(['/workflow/newworkflow']);
    }

}