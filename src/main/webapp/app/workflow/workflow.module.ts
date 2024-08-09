import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule, DatePipe } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NouisliderModule } from 'ng2-nouislider';
import { TagInputModule } from 'ngx-chips';
import { MaterialModule } from '../app.module';
import { SharedModule } from '../shared/shared-module';
import { LoadingModule, ANIMATION_TYPES } from 'ngx-loading';
import { Md2Module } from 'md2';
import { LoginService } from 'app/home/login/loginService';
import { NgxSpinnerModule } from 'ngx-spinner';
import { WorkFlowRoutes } from './workflow.routing';
import { ApprovalPendingListComponent } from './approvalpending/approvalpending.component';
import { NewWorflowComponent } from './newworkflow/newworkflow.component';
import { NewFolderComponent } from './newdepartment/newdepartment.component';
import { NewProjectComponent } from './newproject/newproject.component';
import { MyDocumentComponent } from './mydocuments/mydocuments.component';
import { DocumentCategoryComponent } from './documentcategory/documentcategory.component';
import { NewStaffComponent } from './newstaff/newstaff.component';
import { StaffListComponent } from './stafflist/stafflist.component';
import { DepartmentListComponent } from './departmentlist/departmentlist.component';

import { DocumentCategoryListComponent } from './documentcategorylist/documentcategorylist.component';
import { ProjectListComponent } from './projectlist/projectlist.component';
import { WorkFlowDetailsComponent } from './workflowdetails/workflowdetails.component';
import { SubDepartmentListComponent } from './subdepartmentlist/subdepartmentlist.component';
import { NewSubDepartmentComponent } from './newsubdepartment/newsubdepartment.component';
import { DepartmentDetailsService } from 'app/services/departmentDetailsService';
import { ProjectDetailsService } from 'app/services/projectDetailsService';
import { StaffDetailsService } from 'app/services/staffDetailService';
import { DocumentCategoryService } from 'app/services/documentcategoryService';
import { WorkflowApprovalDetailsService } from 'app/services/workflowApprovalDetailsService';
import { WorkflowDetailsService } from 'app/services/workflowDetailsService';


@NgModule({
  imports: [
    NgxSpinnerModule,
    Md2Module,
    RouterModule,
    CommonModule,
    RouterModule.forChild(WorkFlowRoutes),
    FormsModule,
    SharedModule,
    ReactiveFormsModule,
    NouisliderModule,
    TagInputModule,
    MaterialModule,
    LoadingModule.forRoot({animationType: ANIMATION_TYPES.threeBounce,
      backdropBackgroundColour: 'rgba(255,255,255,0.3)', 
      backdropBorderRadius: '10px',
      primaryColour: '#0073e6', 
      secondaryColour: '#3399ff', 
      tertiaryColour: '#99d6ff' 
  })
  ],
  declarations: [
    ApprovalPendingListComponent,
    NewWorflowComponent,
    NewFolderComponent,
    NewProjectComponent,
    MyDocumentComponent,
    DocumentCategoryComponent,
    NewStaffComponent,
    StaffListComponent,
    DepartmentListComponent,
    
    DocumentCategoryListComponent,
    ProjectListComponent,
    WorkFlowDetailsComponent,
    SubDepartmentListComponent,
    NewSubDepartmentComponent
    
      // StudentListComponent
  ],
  providers: [
    DatePipe,
    DepartmentDetailsService,
    ProjectDetailsService,
    StaffDetailsService,
    DocumentCategoryService,
    WorkflowApprovalDetailsService,
    WorkflowDetailsService
  ]
})

export class WorkFlow {}
