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
    selector: 'newproject',
    templateUrl: './newproject.component.html',
    styleUrls: ['../../workflow/worflow.component.css', '../../app.component.css']
})

export class NewProjectComponent implements OnInit {
    AddProjectForm: FormGroup;
    projectName: any = '';
    statusCode: number;
    projectDescription: string = '';
    managerName:any = '';
    projectStartDate:any;
    buttonName: string;
    projectEndDate:any;
    projectAction:string = "ADD";
 
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
        this.AddProjectForm = this.formBuilder.group({
            projectName: [null],
            projectDescription: [null],
            managerName :[null],
            projectStartDate:[null],
            projectEndDate:[null],
        });
        this.AddProjectForm.reset();
        $('#managerName').addClass('is-empty');
       $('#projectStartDateDiv').addClass('is-empty');
       $('#projectEndDateDiv').addClass('is-empty');

       
       if(localStorage.getItem('projectAction') != null && localStorage.getItem('projectAction') != ''){
        // console.log("ifffff");
        this.projectAction = 'UPDATE'
         this.editProject();
     }
    }
    editProject(): any {
        $('#managerName').removeClass('is-empty');
        this.projectName = "ENGI CIVI BOSTON WATERS";
        this.projectDescription = "Engineering Civil Department";
        this.managerName = "Ashley";
        this.AddProjectForm.get('projectStartDate').setValue(moment.utc(new Date('12/12/2020')).format('DD/MM/YYYY'));
        this.AddProjectForm.get('projectEndDate').setValue(moment.utc(new Date('12/12/2021')).format('DD/MM/YYYY'));
        $('#projectStartDateDiv').removeClass('is-empty');
        $('#projectEndDateDiv').removeClass('is-empty');
 
    }

    setTimeOut() {
        window.setTimeout(function () {
            $(".alert").fadeTo(2000, 500).slideUp(500, function () {
                $(".alert").slideUp(500);
            });
        }, 4000);
    }

    onsubmit(event: any) {
        console.log("on submitttt");
        
        this.AddProjectForm.reset();
        //document.getElementById('projectDescription').innerText = "";
        //setValue('')
        this.AddProjectForm.get('projectDescription').setValue('');
       // window.alert("Form Submitted Successfully");
       this.statusCode = 200;
       this.router.navigate(['/workflow/projectList']);
        
    }

    onCancel(){
        history.back();
    }

    onManagerName(){
        $('#managerName_floatToLabel').css('top','-30px');

    }

    dobDatepicker(val, val1) {
        $('#projectStartDate_floatToLabel').css('top','-30px');
        $('#projectEndDate_floatToLabel').css('top','-30px');
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
           self.AddProjectForm.get(val).setValue((document.getElementById(val) as HTMLInputElement).value);

         }
         
       }).datepicker("show");
     }
   
    
}


