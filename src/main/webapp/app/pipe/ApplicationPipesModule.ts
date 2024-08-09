import { DateFormatPipe, DatePipeOriginal } from './date.pipe';
import { NgModule }       from '@angular/core';

@NgModule({
    imports: [
        // dep modules
    ],
    declarations: [
        DateFormatPipe,
        DatePipeOriginal
    ],
    exports: [
        DateFormatPipe,
        DatePipeOriginal
    ]
})
export class ApplicationPipesModule {
}
