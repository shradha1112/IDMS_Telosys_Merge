import { Routes } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { RecoverComponent } from './recover/recover.component';
import { RegistrationComponent } from './registration/registration.component';
import { ResetComponent } from './reset/reset.component';
// import { RecoverComponent } from './studentrecover/studentrecover.component';
// import { ResetComponent } from './studentreset/studentreset.component';

export const HomeRoutes: Routes = [

    {
        path: '',
        children: [ {
            path: 'login',
            component: LoginComponent
        }, {
            path: 'recover',
            component: RecoverComponent
        },{
            path: 'reset',
            component: ResetComponent
        },
        {
            path: 'registration',
            component: RegistrationComponent
         }
    ]
    
    }
];
