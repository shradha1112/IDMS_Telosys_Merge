import { NgModule, ErrorHandler } from '@angular/core';
import { LoadingModule } from 'ngx-loading';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'; // this is needed!
import { RouterModule } from '@angular/router';
import { HttpModule } from '@angular/http';
import { QuillEditorModule } from 'ngx-quill-editor';
import { HashLocationStrategy , LocationStrategy} from '@angular/common'
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ShowHidePasswordModule } from 'ngx-show-hide-password';
import { NgxSpinnerModule } from 'ngx-spinner';

import {
  MatAutocompleteModule,
  MatButtonModule,
  MatButtonToggleModule,
  MatCardModule,
  MatCheckboxModule,
  MatChipsModule,
  MatDatepickerModule,
  MatDialogModule,
  MatExpansionModule,
  MatGridListModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  MatMenuModule,
  MatNativeDateModule,
  MatPaginatorModule,
  MatProgressBarModule,
  MatProgressSpinnerModule,
  MatRadioModule,
  MatRippleModule,
  MatSelectModule,
  MatSidenavModule,
  MatSliderModule,
  MatSlideToggleModule,
  MatSnackBarModule,
  MatSortModule,
  MatTableModule,
  MatTabsModule,
  MatToolbarModule,
  MatTooltipModule,
  MatStepperModule,
  NoConflictStyleCompatibilityMode,
} from '@angular/material';
import { RoleGuard} from './shared/AuthGuard/role-guard';
import { EHRComponent } from './app.component';
import { SidebarModule } from './components/sidebar/sidebar.module';
import { FooterModule } from './components/footer/footer.module';
import { PluginModule } from './components/plugin/plugin.module';
import { EHRLayoutComponent } from './layouts/ehr/ehr-layout.component';
import { AuthLayoutComponent } from './layouts/auth/auth-layout.component';
import { ChartsModule } from 'ng2-charts/ng2-charts';
import { EHRRoutes } from './app.routing';
import { AuthGuard } from './shared/AuthGuard/auth-guard';
import {DpDatePickerModule} from 'ng2-date-picker';
import { GlobalErrorHandler } from './GlobalErrorHandler';
import { GlobalErrorComponent } from 'app/GlobalErrorHandler.component';
import { HttpClientModule } from '@angular/common/http';
import { OrderModule } from 'ngx-order-pipe';
import { TimerModalModule } from './components/timerModal/timerModal.module';
import { CurrentUserService } from './profiles/currentUserService';
import { LoginService } from './home/login/loginService';
import { DocumentCategoryService } from './services/documentCategoryService';
@NgModule({
  exports: [
    MatAutocompleteModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatCardModule,
    MatCheckboxModule,
    MatChipsModule,
    MatStepperModule,
    MatDatepickerModule,
    MatDialogModule,
    MatExpansionModule,
    MatGridListModule,
    MatIconModule,
    MatInputModule,
    MatListModule,
    MatMenuModule,
    MatNativeDateModule,
    MatPaginatorModule,
    MatProgressBarModule,
    MatProgressSpinnerModule,
    MatRadioModule,
    MatRippleModule,
    MatSelectModule,
    MatSidenavModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatSnackBarModule,
    MatSortModule,
    MatTableModule,
    MatTabsModule,
    MatToolbarModule,
    MatTooltipModule,
    
  ]
})
export class MaterialModule {}

@NgModule({
    imports:      [
      NgxSpinnerModule,
      ShowHidePasswordModule.forRoot(),
        CommonModule,
        BrowserAnimationsModule,
        FormsModule,
        QuillEditorModule ,
        RouterModule.forRoot(EHRRoutes),
        HttpModule,
        MaterialModule,
        MatNativeDateModule,
        SidebarModule,
        FooterModule,
        PluginModule,
        ChartsModule,
        DpDatePickerModule,
        LoadingModule,
        HttpClientModule,
        OrderModule,
        TimerModalModule,
        NoConflictStyleCompatibilityMode  
        // /AngularTextTruncateModule 
    ],
    declarations: [
      EHRComponent,
        EHRLayoutComponent,
        AuthLayoutComponent,
        GlobalErrorComponent
    ],
    bootstrap:    [ EHRComponent ],
    providers:[ 
      {provide: LocationStrategy , useClass : HashLocationStrategy}, 
      {provide: ErrorHandler , useClass : GlobalErrorHandler}, 
      AuthGuard,
      RoleGuard,
      CurrentUserService,
      DocumentCategoryService,
      LoginService
    ]
})
export class EHRModule { }
