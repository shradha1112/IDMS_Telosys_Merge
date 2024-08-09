import { Component, OnInit, Pipe, PipeTransform } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Base64 } from 'js-base64';
import { Data } from 'app/data';
import * as moment from 'moment';
import { DatePipe } from '@angular/common';
import { NgxSpinnerService } from 'ngx-spinner';
import { DepartmentListComponent } from '../departmentlist/departmentlist.component';
import { Department } from 'app/models/department';
import { DepartmentDetailsService } from 'app/services/departmentDetailsService';
import { Project } from 'app/models/project';
import { ProjectDetailsService } from 'app/services/projectDetailsService';
import { StaffDetailsService } from 'app/services/staffDetailService';
import { Staff } from 'app/models/staff';
import { DocumentCategory } from 'app/models/documentcategory';
import { DocumentCategoryService } from 'app/services/documentcategoryService';
import { Workflow } from 'app/models/workflow';
import { WorkflowDetailsService } from 'app/services/workflowDetailsService';
import { CurrentUserService } from 'app/profiles/currentUserService';


declare const $: any;

interface FileReaderEventTarget extends EventTarget {
  result: string;
}

interface FileReaderEvent extends Event {
  target: FileReaderEventTarget;
  getMessage(): string;
}


@Component({
  selector: 'ehr-newpatient',
  templateUrl: './newworkflow.component.html',
  styleUrls: ['../../workflow/worflow.component.css', '../../app.component.css']
})

export class NewWorflowComponent implements OnInit {
  AddWorkFlowForm: FormGroup;
  projectName: any = '';
  fName: any = '';
  deptName: any = '';
  allDepartments: Department[];
  allProjects: Project[];
  approverName: any = '';
  otherProjectNameFlag: boolean = false;
  otherFolderNameFlag: boolean = false;
  projectDescription: string = '';
  statusCode: number;
  docCategory: string = '';
  buttonName: string;
  allStaffMembers: Staff[];
  allDocumentCategories: DocumentCategory[];
  sizeofimage: number;
  isNotValidImageSize: boolean;
  imageUrl: File;
  currentFileUpload: any;
  workFlow: Workflow;
  loggedInUser: Staff;
  docName: any;

  /*   dob = new FormControl('', Validators.required);
     AddPatientForm: FormGroup;
     AddInsuranceForm: FormGroup;
     patientAddressState_search: string = '';
     additionalInfo_search: string = '';
     patientAddressId_search: string = '';
     staffId_search: string = '';
     isNotValidImageSize: boolean = false;
     statusCode: number;
     patientImage: any;
     isValid = false;
     value=false;
     datePattern = /^(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\d\d$/;*/

  /*  getErrorMessage() {
        return this.dob.hasError('required') ? 'Please select DOB' : '';
    }*/

  constructor(private formBuilder: FormBuilder,
    private router: Router,
    private sharedData: Data, private datePipe: DatePipe,
    private spinner: NgxSpinnerService,
    private departmentService: DepartmentDetailsService,
    private projectService: ProjectDetailsService,
    private staffMemberService: StaffDetailsService,
    private documentCategoryService: DocumentCategoryService,
    private workflowDetailsService: WorkflowDetailsService,
    private _date: DatePipe,
    private currentUserService: CurrentUserService
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
    this.AddWorkFlowForm = this.formBuilder.group({
      fName: [null],
      fileName: [null],
      projectName: [null],
      deptName: [null],
      approverName: [null],
      otherProjectName: [null],
      projectDescription: [null],
      docCategory: [null],
      dueDate: [null]

    });
    this.getAllDepartments();
    this.getAllProjects();
    this.getAllStaffMembers();
    this.getAllDocumentCategories();

    console.log(this.allDepartments);
    $('#docCategory').addClass('is-empty');

    $('#deptName').addClass('is-empty');

    $('#approverName').addClass('is-empty');

    $('#projectName').addClass('is-empty');


    $('#approvalDueDateDiv').addClass('is-empty');

  }

  setTimeOut() {
    window.setTimeout(function () {
      $(".alert").fadeTo(2000, 500).slideUp(500, function () {
        $(".alert").slideUp(500);
      });
    }, 4000);
  }

  getAllProjects() {
    // console.log("getEncAssessmentbyEncounterId calllledddd");
    this.projectService.getAllProjects().subscribe(data => {
      this.allProjects = data;
    })
  }

  getAllDocumentCategories() {
    this.documentCategoryService.getAllDocumentCategories().subscribe(data => {
      this.allDocumentCategories = data;
    })
  }



  getAllStaffMembers() {
    // console.log("getEncAssessmentbyEncounterId calllledddd");
    this.staffMemberService.getAllStaffMembers().subscribe(data => {
      this.allStaffMembers = data;

    })
  }

  /*selectFile(event) {
      console.log("select fileeee"+event);
      if(event.target.files){
          console.log("event.target.file"+event.target.files)
          const reader = new FileReader();
          console.log(reader);
      }
  }*/

  getAllDepartments() {
    // console.log("getEncAssessmentbyEncounterId calllledddd");
    this.departmentService.getAllDepartments().subscribe(data => {
      this.allDepartments = data;
    })

  }

  selectFile(event) {
    this.sizeofimage = event.target.files[0].size;
    //  if (this.sizeofimage < 30000) {
    this.isNotValidImageSize = false;
    this.imageUrl = event.target.files;
    this.currentFileUpload = event.target.files[0];
    console.log(event.target.files[0].name);
    this.docName = event.target.files[0].name;
    if (event.target.files && this.currentFileUpload) {
      const reader = new FileReader();
      reader.onload = function (e: FileReaderEvent) {
        //$('#wizardPicturePreview').attr('src', e.target.result).fadeIn('slow');
        $('#url1').attr('value', reader.result);
        $('#fileName').attr('value', event.target.files[0].name);
      };
      reader.readAsDataURL(this.currentFileUpload);
    }
    //}
    //else {
    //this.isNotValidImageSize = true;
    //  this.staffImage = "";
    //}
  }


  onsubmit(event: any) {
    //console.log("submitttttt");
    let fileURL = $('#url1').val();
    // console.log(fileName);
    let remarks = this.AddWorkFlowForm.get('projectDescription').value;
    let dueDate = this.AddWorkFlowForm.get('dueDate').value;
    let projectId = this.AddWorkFlowForm.get('projectName').value;
    let deptId = this.AddWorkFlowForm.get('deptName').value;
    let approverId = this.AddWorkFlowForm.get('approverName').value;
    let categoryId = this.AddWorkFlowForm.get('docCategory').value;
    let workFowId = 0;
    this.currentUserService.getLoggedInUserDetails()
      .subscribe(data => {
        this.loggedInUser = data;
        let createdBy = this.loggedInUser.firstName + this.loggedInUser.lastName;
        let uploadedDoc = new Workflow(projectId, workFowId, deptId.toString(), categoryId, approverId.toString(),
          this.docName, fileURL, remarks, true, createdBy, new Date(), dueDate);
    
        this.workflowDetailsService.uploadDocument(uploadedDoc)
          .subscribe(data => {
            //console.log(data);
          }, ErrorCode => {
            this.statusCode = ErrorCode;
          })
      });

      this.router.navigate(['/workflow/listdocuments']);
  }

  onCancel() {
    history.back();
  }

  checkOther() {
    //console.log("check other calledddddddd");
    var projectNameField = this.AddWorkFlowForm.get('projectName').value;
    if (projectNameField == "Other") {
      this.otherProjectNameFlag = true;
      //console.log(this.otherProjectNameFlag);
    }
  }

  onProjectName() {
    $('#projectName_floatToLabel').css('top', '-30px');
  }


  onApproverName() {
    $('#approverName_floatToLabel').css('top', '-30px');
  }

  onDepartmentName() {
    $('#deptName_floatToLabel').css('top', '-30px');
  }

  onDocumentCategory() {
    $('#docCategory_floatToLabel').css('top', '-30px');
  }


  dobDatepicker(val, val1) {
    $('#projectStartDate_floatToLabel').css('top', '-30px');
    $('#projectEndDate_floatToLabel').css('top', '-30px');
    var self = this;
    if (this.buttonName == 'ADD') {
      $(val1).addClass('customfloat');
    }
    $("#" + val).datepicker({
      Style: "padding-bottom:10px;",
      changeMonth: true,
      yearRange: "1900:+0",
      defaultDate: new Date(),
      maxDate: '31/12/2050',
      changeYear: true,
      beforeShow: function () {
        //          console.log("before show");
        setTimeout(function () {
          $('.ui-datepicker').css('z-index', 99999999999999);
        }, 0);
      },
      onSelect: function () {
        self.AddWorkFlowForm.get(val).setValue((document.getElementById(val) as HTMLInputElement).value);

      }

    }).datepicker("show");
  }
}




