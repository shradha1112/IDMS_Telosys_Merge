import { Component, OnInit, Pipe, PipeTransform } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Base64 } from 'js-base64';
import { Data } from 'app/data';
import * as moment from 'moment';
import { DatePipe } from '@angular/common';
import { NgxSpinnerService } from 'ngx-spinner';
import { SELECT_PANEL_PADDING_X } from '@angular/material';

declare const $: any;

@Component({
    selector: 'documentCategory',
    templateUrl: './documentcategory.component.html',
    styleUrls: ['../../workflow/worflow.component.css', '../../app.component.css']
})

export class DocumentCategoryComponent implements OnInit {
    AddDocumentCategoryForm: FormGroup;
    documentCategoryName: any = '';
    statusCode: number;
    documentCategoryDescription: string = '';
    departmentName: string = '';
    documentVisibility: any = '';
    action:string = "ADD";

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
        
        this.AddDocumentCategoryForm = this.formBuilder.group({
            documentCategoryName: [null],
            documentCategoryDescription: [null],
            departmentName:[null],
            documentVisibility:[null],
        });
        this.AddDocumentCategoryForm.reset();
        $('#departmentName').addClass('is-empty');
        $('#documentVisibility').addClass('is-empty');
        //this.AddDocumentCategoryForm.reset();

        if(localStorage.getItem('action') != null && localStorage.getItem('mode') != ''){
            this.action = "UPDATE";
            this.editDocumentCategory();
        }

    }

    setTimeOut() {
        window.setTimeout(function () {
            $(".alert").fadeTo(2000, 500).slideUp(500, function () {
                $(".alert").slideUp(500);
            });
        }, 4000);
       // this.router.navigate(['/workflow/documentCategory']);
    }

    editDocumentCategory(){
        $('#departmentName').removeClass('is-empty');
        $('#documentVisibility').removeClass('is-empty');
        this.documentCategoryName = "Design Specification";
        this.documentCategoryDescription = "Civil Engineering Design Specification Document";
        this.departmentName = "Engineering";
        this.documentVisibility = "Global";
    }

    onsubmit(event: any) {
       // console.log("on submitttt");
        
        this.AddDocumentCategoryForm.reset();
        this.statusCode = 200;
        this.setTimeOut();
    
     this.router.navigate(['/workflow/documentCategory']);

        
    }

    
        onDepartmentName(){
        $('#departmentName_floatToLabel').css('top','-30px');
    } 

    onDocumentVisibility(){
        $('#documentVisibility_floatToLabel').css('top','-30px');
    }

    onCancel(){
        history.back();
    }
}