import { Component, OnInit, Pipe, PipeTransform } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Base64 } from 'js-base64';
import { Data } from 'app/data';
import * as moment from 'moment';
import { DatePipe } from '@angular/common';
import { NgxSpinnerService } from 'ngx-spinner';
import { StaffDetailsService } from 'app/services/staffDetailService';
import { Staff } from 'app/models/staff';
import { Department } from 'app/models/department';
import { DepartmentDetailsService } from 'app/services/departmentDetailsService';

declare const $: any;

@Component({
    selector: 'dms-newdepartment',
    templateUrl: './newdepartment.component.html',
    styleUrls: ['../../workflow/worflow.component.css', '../../app.component.css']
})

export class NewFolderComponent implements OnInit {
    AddDeptForm: FormGroup;
    projectName: any = '';
    folderName: any = '';
    folderDescription: string = '';
    mode: string = 'ADD';
    statusCode: number;
    headName: string = '';
    createdBy: string;
    createdOn: Date;
    usersList: any = '';
    allStaffMembers: Staff[];
    deptId: number;
    departmentData: Department;

    constructor(private formBuilder: FormBuilder,
        private router: Router,
        private route: ActivatedRoute,
        private sharedData: Data, private datePipe: DatePipe,
        private staffMemberService: StaffDetailsService,
        private deptService: DepartmentDetailsService,
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
        this.getAllStaffList();
        this.AddDeptForm = this.formBuilder.group({
            deptName: [null, [Validators.required, Validators.pattern("[a-zA-Z]*")]],
            deptDesc: [null],
            deptHeadName: [null, [Validators.required]]
        });

        this.AddDeptForm.reset();

        $('#departmentName').addClass('label-floating is-empty');
        $('#deptHeadName').addClass('label-floating is-empty');
        $('#desc').addClass('label-floating is-empty');

        if (localStorage.getItem('mode') != null && localStorage.getItem('mode') != '') {
            this.mode = 'UPDATE';
            this.route.params.subscribe(params => {
                this.deptId = +params['departmentId'];
            });
            this.editDepartment();
        }
    }
    getAllStaffList() {
        this.staffMemberService.getAllStaffMembers().subscribe(data => {
            this.allStaffMembers = data;
        })
    }

    editDepartment() {
        //console.log(this.deptId);
    
        $("#departmentName").addClass("is-focused");
        $('#desc').addClass('is-focused');
        $('#deptHeadName').addClass('is-focused');

        this.deptService.getDepartmentById(this.deptId)
            .subscribe(data => {
                this.departmentData = data;
                this.headName = this.departmentData.deptHead;
                this.createdBy = this.departmentData.createdBy;
                this.createdOn = this.departmentData.createdOn;
                this.AddDeptForm.get('deptName').setValue(this.departmentData.deptName);
                this.AddDeptForm.get('deptDesc').setValue(this.departmentData.deptDesc);
                this.AddDeptForm.get('deptHeadName').setValue(this.departmentData.deptHead);
            }, ErrorCode => {
                this.statusCode = ErrorCode;
            })

    }

    setTimeOut() {
        window.setTimeout(function () {
            $(".alert").fadeTo(2000, 500).slideUp(500, function () {
                $(".alert").slideUp(500);
            });
        }, 4000);
    }

    onsubmit(event: any) {

        if (this.AddDeptForm.valid) {
            let desc;
            let deptName = this.AddDeptForm.get('deptName').value;
            let deptDes = this.AddDeptForm.get('deptDesc').value;
            let deptHead = this.AddDeptForm.get('deptHeadName').value;

            if (deptDes == undefined || deptDes == null) {
                desc = "";
            } else {
                desc = deptDes
            }

            if (this.mode == 'UPDATE') {
                let deptData = new Department(this.deptId, desc, deptHead, deptName, true, this.createdBy, this.createdOn, null, null);
                this.deptService.updateDepartmentById(deptData)
                    .subscribe(data => {
                        this.router.navigate(['/workflow/departmentlist']);
                    }, ErrorCode => {
                        this.statusCode = ErrorCode;
                    })
            } else {
                let deptData = new Department(0, desc, deptHead, deptName, true, null, null, null, null);
                this.deptService.insertDepartment(deptData)
                    .subscribe(data => {
                        this.router.navigate(['/workflow/departmentlist']);
                    }, ErrorCode => {
                        this.statusCode = ErrorCode;
                    })
            }

        } else {
            this.validateAllFormFields(this.AddDeptForm)
        }

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

    ondeptHeadName() {
        $('#deptHeadName_floatToLabel').css('top', '-30px');
        //console.log($('#deptName').value);
    }

    onCancel() {
        history.back();
    }

}