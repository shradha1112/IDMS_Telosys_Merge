import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule, DatePipe } from '@angular/common';
// import { MdIconModule, MdCardModule, MdInputModule, MdCheckboxModule, MdButtonModule } from '@angular/material';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
// import { FlexLayoutModule } from '@angular/flex-layout';
import {SharedModule} from '../shared/shared-module'
import { HomeRoutes } from './home.routing';
import { RecoverService } from './recover/recoverService'
import { LoginComponent } from './login/login.component';
import { RecoverComponent } from './recover/recover.component';
import { ResetComponent } from './reset/reset.component';
import { ResetService } from './reset/resetService';
import {LoginService} from './login/loginService';
import { LoadingModule, ANIMATION_TYPES } from 'ngx-loading';
import { ShowHidePasswordModule } from 'ngx-show-hide-password';
import { NgxSpinnerModule } from 'ngx-spinner';
import { Md2Module, NoConflictStyleCompatibilityMode } from 'md2';
import { MaterialModule } from 'app/app.module';
import { NouisliderModule } from 'ng2-nouislider';
import { TagInputModule } from 'ngx-chips';
import { RegistrationComponent } from './registration/registration.component';
import { CompatibilityModule } from '@angular/material';
// import { StudentDetails } from 'app/patients/models/StudentDetails';

@NgModule({
  imports: [
    NgxSpinnerModule,
    ShowHidePasswordModule.forRoot(),
    CommonModule,
    RouterModule.forChild(HomeRoutes),
    FormsModule,
    ReactiveFormsModule,
    Md2Module,
    MaterialModule,
    CompatibilityModule,
    NoConflictStyleCompatibilityMode,
    SharedModule,
    NouisliderModule,
    TagInputModule,
    LoadingModule.forRoot({animationType: ANIMATION_TYPES.threeBounce,
      backdropBackgroundColour: 'rgba(255,255,255,0.3)', 
      backdropBorderRadius: '10px',
      primaryColour: '#0073e6', 
      secondaryColour: '#3399ff', 
      tertiaryColour: '#99d6ff' 
  })
  ],
  declarations: [
    LoginComponent,
    RecoverComponent,
    ResetComponent,
    RegistrationComponent

  ],
  providers: [
    RecoverService,
    ResetService,
    LoginService,
    DatePipe
]
})

export class HomeModule {}
