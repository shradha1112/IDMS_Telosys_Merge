import { Component, OnInit, Pipe, PipeTransform } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Base64 } from 'js-base64';
import { Data } from 'app/data';
import * as moment from 'moment';
import { DatePipe } from '@angular/common';
import { NgxSpinnerService } from 'ngx-spinner';

declare const $: any;

@Component({
    selector: 'newStaff',
    templateUrl: './newstaff.component.html',
    styleUrls: ['../../workflow/worflow.component.css', '../../app.component.css']
})

export class NewStaffComponent implements OnInit {
    AddStaffMemberForm: FormGroup;
    departmentName: string = '';
    buttonName: string;
    firstName: string = '';
    emailAddress: string = '';
    lastName: string = '';
    staffAddress:string = '';
    staffName:string = '';
    statusCode:number;
    mobileNo:number;
    dob:any;
    staffdob:string;
    staffAction:string = "ADD"
    marketingFlag: boolean = false;
    managerName:string = '';
    subDepartmentName:string = '';
    staffRole:any = [];
    HRFlag: boolean = false;
    OperationsFlag:boolean = false;
    showSubDept: boolean = false;
   // staffContactNo:number;

    constructor(private formBuilder: FormBuilder,
        private router: Router,
        private sharedData: Data, private datePipe: DatePipe,
        private spinner: NgxSpinnerService
    ) { }

    isFieldValid(form: FormGroup, field: string) {
        return !form.get(field).valid && form.get(field).touched;
    }

    displayFieldCss(form: FormGroup, field: string) {
        return {
            'has-error': this.isFieldValid(form, field),
            'has-feedback': this.isFieldValid(form, field)
        };
    }

    ngOnInit() {
        this.AddStaffMemberForm = this.formBuilder.group({
            firstName: [null],
            emailAddress:[null],
            lastName: [null],
            staffName: [null],
            departmentName:[null],
            staffAddress:[null],
          staffdob:[null],
            mobileNo:[null],
            managerName:[null],
            subDepartmentName:[null],
            staffRole:[null],
        });
        this.AddStaffMemberForm.reset();
        $('#departmentName').addClass('is-empty');
        $('#subDepartmentName').addClass('is-empty');
        $('#staffdobdiv').addClass('is-empty');
        $('#managerName').addClass('is-empty');
        $('#staffRole').addClass('is-empty');
        
        if(localStorage.getItem('staffAction') != null && localStorage.getItem('staffAction') != ''){
            // console.log("ifffff");
            this.staffAction = 'UPDATE';
             this.editStaff();
         }
    }

    editStaff(){
        $('#departmentName').removeClass('is-empty');
        $('#subDepartmentName').removeClass('is-empty');
        $('#staffdobdiv').removeClass('is-empty');
        $('#managerName').removeClass('is-empty');
        $('#staffRole').removeClass('is-empty');

        this.firstName = "Sonia";
        this.emailAddress ="Sonia@gmail.com";
        this.lastName= "Willis";
        this.departmentName = "HR";
        this.staffAddress = "Pune";
        this.AddStaffMemberForm.get('staffdob').setValue(moment.utc(new Date('12/12/1990')).format('DD/MM/YYYY'));
        //this.staffdob = moment.utc(new Date('12/12/1990')).format('MM/DD/YYYY')
        this.mobileNo = 8983127982,
        this.managerName = "Mike";
        this.subDepartmentName = "HR Manager";
       this.staffRole = ['Approver'];


      
    }
    
    setTimeOut() {
        window.setTimeout(function () {
            $(".alert").fadeTo(2000, 500).slideUp(500, function () {
                $(".alert").slideUp(500);
            });
        }, 4000);
    }

    onCancel(){
        history.back();
    }

    onsubmit(event: any) {
       
        this.AddStaffMemberForm.reset();
         this.statusCode = 200;
        this.router.navigate(['/workflow/stafflist']);
        
    }

    deptChange(event){
        //console.log(event.value);
        if(event.value){
            this.showSubDept = true;
            this.selectSubDepartment(event.value);
        }
    }

    selectSubDepartment(value){
       // console.log(value);
        if(value == "Operations"){
            this.OperationsFlag = true;
            this.HRFlag = false;
        }
        else if(value == "HR"){
            this.OperationsFlag = false;
            this.HRFlag = true;
        }
    }

    onDepartmentName(){
        $('#departmentName_floatToLabel').css('top','-30px');
        //console.log($('#deptName').value);
    }

    onsubDepartmentName(){
        $('#subDepartmentName_floatToLabel').css('top','-30px');
    }
    
    onManagerName(){
        $('#managerName_floatToLabel').css('top','-30px');
        //console.log($('#deptName').value);
    }
    
    
    onstaffRole(){
        $('#staffRole_floatToLabel').css('top','-30px');
        //console.log($('#deptName').value);
    }
    dobDatepicker(val, val1) {
        $('#staffDob_floatToLabel').css('top','-30px');
       var self = this;
       if (this.buttonName == 'ADD') {
         $(val1).addClass('customfloat');
       }
       $("#" + val).datepicker({
         Style: "padding-bottom:10px;",
         changeMonth: true,
         yearRange: "1900:+0",
         defaultDate: '01/01/1953',
         maxDate: new Date(),
         changeYear: true,
         beforeShow: function () {
 //          console.log("before show");
           setTimeout(function () {
            $('.ui-datepicker').css('z-index', 99999999999999);
           }, 0);
         },
         onSelect: function () {
           self.AddStaffMemberForm.get(val).setValue((document.getElementById(val) as HTMLInputElement).value);

         }
         
       }).datepicker("show");
     }
   
         
}