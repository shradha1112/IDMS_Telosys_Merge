import { Routes } from '@angular/router';
import { AuthGuard } from './shared/AuthGuard/auth-guard';
import { EHRLayoutComponent } from './layouts/ehr/ehr-layout.component';
import { AuthLayoutComponent } from './layouts/auth/auth-layout.component';
import { RoleGuard } from './shared/AuthGuard/role-guard';
import { GlobalErrorComponent } from './GlobalErrorHandler.component';

export const EHRRoutes: Routes = [
  {
    // Redirect app launch to login
    path: '',
    redirectTo: 'login',
    pathMatch: 'full'
  }, {
    /** PUBLIC ROUTES declared here **/
    //  Access open to public - everyone is allowed to see
    //  Prompts user to sign in to access the secure area */
    path: '',
    component: AuthLayoutComponent,
    children: [
      {
        path: '',
        loadChildren: './home/home.module#HomeModule'
      }
    ]
  },



  {
    /** SECURE ROUTES declared here **/
    // CCM Module secure content area
    //  Access only for logged in User */
    path: '',
    component: EHRLayoutComponent,
    canActivateChild: [AuthGuard],
    children: [
      {
        path: 'profiles',
        loadChildren: './profiles/profiles.module#Profiles'
      }, {
        path: 'workflow',
        loadChildren: './workflow/workflow.module#WorkFlow'
      },{
        path: 'dashboard',
        loadChildren: './dashboard/dashboard.module#Dashboard'
      },
      {
        path: 'error',
        component: GlobalErrorComponent
      }
    ]
  },



];
