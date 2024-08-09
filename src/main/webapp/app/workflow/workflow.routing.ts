import { Routes } from '@angular/router';
import { ApprovalPendingListComponent } from './approvalpending/approvalpending.component';
import { NewWorflowComponent } from './newworkflow/newworkflow.component';
import { NewProjectComponent } from './newproject/newproject.component';
import { NewFolderComponent } from './newdepartment/newdepartment.component';
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
// import { StudentListComponent } from './studentlist/studentlist.component';
export const WorkFlowRoutes: Routes = [
  {
    path: '',
    children: [{
      path: 'newworkflow',
      component: NewWorflowComponent
    }]
  },
  {
    path: '',
    children: [{
      path: 'approvallist',
      component: ApprovalPendingListComponent
    }]
  },
  {
    path: '',
    children: [{
      path: 'newProject',
      component: NewProjectComponent
    }]
  },
  {
    path: '',
    children: [{
      path: 'newDepartment',
      component: NewFolderComponent
    }]
  },
  {
    path: '',
    children: [{
      path: 'newDepartment/:departmentId',
      component: NewFolderComponent
    }]
  },
  {
    path: '',
    children: [{
      path: 'listdocuments',
      component: MyDocumentComponent
    }],

  },

  {
    path: '',
    children: [{
      path: 'newDocCategory',
      component: DocumentCategoryComponent
    }]
  },
  {
    path: '',
    children: [{
      path: 'newStaff',
      component: NewStaffComponent
    }]
  },
  {
    path: '',
    children: [{
      path: 'stafflist',
      component: StaffListComponent
    }]
  },
  {
    path: '',
    children: [{
      path: 'departmentlist',
      component: DepartmentListComponent
    }]
  },


  {
    path: '',
    children: [{
      path: 'documentCategory',
      component: DocumentCategoryListComponent
    }]
  },

  {
    path: '',
    children: [{
      path: 'projectList',
      component: ProjectListComponent
    }]
  },
  {
    path: '',
    children: [{
      path: 'viewWorkflowDetails',
      component: WorkFlowDetailsComponent

    }]
  },
  {
    path: '',
    children: [{
      path: 'subDepartmentList',
      component: SubDepartmentListComponent

    }]
  },

  {
    path: '',
    children: [{
      path: 'newSubDepartment',
      component: NewSubDepartmentComponent

    }]
  }
];
