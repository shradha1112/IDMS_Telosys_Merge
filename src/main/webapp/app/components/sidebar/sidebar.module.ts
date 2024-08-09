import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { SidebarComponent } from './sidebar.component';
import { Data } from '../../data';
import { SidebarProfileRefreshService } from './sidebarProfileRefreshService'
import { RoleGuardService } from '../../shared/AuthGuard/RoleGuardService';
import { LoadingModule, ANIMATION_TYPES } from 'ngx-loading';
import { TimerModule } from 'app/components/timer/timer.module';
import { CurrentUserService } from 'app/profiles/currentUserService';
import { LoginService } from 'app/home/login/loginService';

@NgModule({
    imports: [
        RouterModule,
        CommonModule,
        TimerModule,
        LoadingModule.forRoot({
            animationType: ANIMATION_TYPES.threeBounce,
            backdropBackgroundColour: 'rgba(255,255,255,0.3)',
            backdropBorderRadius: '10px',
            primaryColour: '#0073e6',
            secondaryColour: '#3399ff',
            tertiaryColour: '#99d6ff'
        })],
    declarations: [
        SidebarComponent
    ],
    exports: [
        SidebarComponent
    ],
    providers: [
        Data,
        SidebarProfileRefreshService,
        SidebarComponent,
        RoleGuardService,
        LoginService,
        CurrentUserService
    ]
})

export class SidebarModule { }
