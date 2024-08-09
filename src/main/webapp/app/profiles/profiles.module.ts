import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NouisliderModule } from 'ng2-nouislider';
import { TagInputModule } from 'ngx-chips';
import { SelectModule } from 'ng2-select';
import { MaterialModule } from '../app.module';
import { ProfilesRoutes } from './profiles.routing';
import { SharedModule } from '../shared/shared-module'
import { Data } from '../data';
import { LoadingModule, ANIMATION_TYPES } from 'ngx-loading';
import { Md2Module } from 'md2';
import { NgxSpinnerModule } from 'ngx-spinner';
import { EditProfileComponent } from './edit-profile/edit-profile.component';

@NgModule({
  imports: [
    NgxSpinnerModule,
    Md2Module,
    CommonModule,
    RouterModule.forChild(ProfilesRoutes),
    FormsModule,
    ReactiveFormsModule,
    NouisliderModule,
    TagInputModule,
    MaterialModule,
    SharedModule,
    LoadingModule.forRoot({
      animationType: ANIMATION_TYPES.threeBounce,
      backdropBackgroundColour: 'rgba(255,255,255,0.3)',
      backdropBorderRadius: '10px',
      primaryColour: '#0073e6',
      secondaryColour: '#3399ff',
      tertiaryColour: '#99d6ff'
    })
  ],
  declarations: [
    EditProfileComponent
  ],
  providers: [
    Data
  ]
})

export class Profiles { }
