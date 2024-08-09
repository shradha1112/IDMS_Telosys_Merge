import { Pipe, PipeTransform } from '@angular/core';
import * as moment from 'moment';


@Pipe({
  name: 'dateformat'
})
export class DateFormatPipe implements PipeTransform {
  transform(value: any): string {
    if(value!="")
    {
      let formattedDate = moment(value).utc().format('MM/DD/YYYY').toString();
      return formattedDate
    }
    else 
    return "";
    
  }
}

@Pipe({
  name: 'dateformatISO'
})
export class DatePipeOriginal implements PipeTransform {
  transform(value: any): string {
    if(value!="")
    {
      let formattedDate = moment(value).utc().format('YYYY-MM-DD').toString();
    return formattedDate
  }
  else
  return "";
  }
}