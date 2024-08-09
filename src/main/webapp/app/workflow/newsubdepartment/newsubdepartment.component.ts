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
    selector: 'new-subdepartment',
    templateUrl: './newsubdepartment.component.html',
    styleUrls: ['../../workflow/worflow.component.css', '../../app.component.css']
})

export class NewSubDepartmentComponent implements OnInit {
    AddSubDepartmentForm: FormGroup;
    departmentName:any = '';
    subDepartmentName:string = '';
    subDepartmentDescription = '';
    
    projectName: any = '';
    folderName: any = '';
    folderDescription: string = '';
    statusCode: number;
    deptHeadName:string = '';
    usersList:any = '';
    subDeptHeadName:string = '';
    subDeptAction:string = "ADD";
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
        this.AddSubDepartmentForm = this.formBuilder.group({
            departmentName: [null],
            subDepartmentName:[null],
            subDepartmentDescription:[null],
            subDeptHeadName:[null],
            
            
        });
        $('#departmentNameDiv').addClass('is-empty');
        $('#departmentName').addClass('is-empty');
        $('#deptHeadName').addClass('is-empty');
        $('#subDeptHeadName').addClass('is-empty');

        if(localStorage.getItem('subDeptAction') != null && localStorage.getItem('mode') != ''){
            // console.log("ifffff");
            this.subDeptAction = 'UPDATE'
             this.editSubDepartment();
         }
    }
    editSubDepartment() {
        $('#departmentNameDiv').removeClass('is-empty');
      //  $('#departmentName').addClass('is-empty');
        $('#deptHeadName').addClass('is-empty');
        $('#subDeptHeadName').removeClass('is-empty');
        $('#subDeptHeadName_floatToLabel').css('top','-30px');
        this.departmentName = "Engineering";
    
        this.subDepartmentName = "Mechanical";
        this.subDepartmentDescription = "Mechanical Department";
        this.subDeptHeadName = "Mike";
       
    }

    setTimeOut() {
        window.setTimeout(function () {
            $(".alert").fadeTo(2000, 500).slideUp(500, function () {
                $(".alert").slideUp(500);
            });
        }, 4000);
    }

    onsubmit(event: any) {
        //console.log("on submitttt");
        
        this.AddSubDepartmentForm.reset();
        //document.getElementById('projectDescription').innerText = "";
        //setValue('')
       // this.AddFolderForm.get('projectDescription').setValue('');
        this.statusCode = 200;
        this.setTimeOut();
    
        this.router.navigate(['/workflow/subDepartmentList']);
   
        
    }

    
    
    onsubDeptHeadName(){
        $('#subDeptHeadName_floatToLabel').css('top','-30px');
        //console.log($('#deptName').value);
    }

    onDepartmentName(){
        $('#departmentName_floatToLabel1').css('top','-30px');
    }

    onCancel(){
        history.back();
    }
    
}