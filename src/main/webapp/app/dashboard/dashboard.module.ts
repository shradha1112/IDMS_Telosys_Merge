import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule, DatePipe } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MdModule } from '../shared/md/md.module';
import { MaterialModule } from '../app.module';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { DashboardComponent } from './dashboard.component';
import { DashboardRoutes } from './dashboard.routing';
import { ChartsModule } from 'ng2-charts/ng2-charts';
import { MatButtonModule, MatButtonToggleModule } from '@angular/material';
import { DashboardService } from './dashboard.service';
import { SharedModule } from 'app/shared/shared-module';
import { LoadingModule, ANIMATION_TYPES } from 'ngx-loading';
import { ApplicationPipesModule } from 'app/pipe/ApplicationPipesModule';
import {ProjectSummaryComponent } from './projectSummary/projectSummary.component';
import { Md2Module } from 'md2';
import { DataService } from './projectSummary/dataService';


@NgModule({
    imports: [
        CommonModule,
        Md2Module,
        RouterModule.forChild(DashboardRoutes),
        FormsModule,
        MatButtonModule,
        MatButtonToggleModule,
        MdModule,
        MaterialModule,
        MatButtonModule,
        MatButtonToggleModule,
        ChartsModule,
        MaterialModule,
        SharedModule,
        ReactiveFormsModule,
        ChartsModule,
        ApplicationPipesModule,
        LoadingModule.forRoot({animationType: ANIMATION_TYPES.threeBounce,
            backdropBackgroundColour: 'rgba(255,255,255,0.0)', 
            backdropBorderRadius: '10px',
            primaryColour: '#0073e6', 
            secondaryColour: '#3399ff', 
            tertiaryColour: '#99d6ff' 
        })
    ],
    declarations: [
        DashboardComponent,
        ProjectSummaryComponent
        
    ],
    providers: [
        DashboardService,
        DatePipe,
        DataService
    ],
    exports: [
        DashboardComponent
    ]
})

export class Dashboard {}
