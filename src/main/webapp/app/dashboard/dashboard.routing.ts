import { Routes } from '@angular/router';

import { DashboardComponent } from './dashboard.component';
import { ProjectSummaryComponent } from './projectSummary/projectSummary.component';

export const DashboardRoutes: Routes = [
    {
      path: '',
      children: [ {
        path: '',
        component: DashboardComponent
    }]},
    {
      path: '',
      children: [ {
        path: 'dashboardView',
        component: ProjectSummaryComponent
    }]}
];
