import { Component, OnInit, Pipe, PipeTransform, Inject } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators, ValidatorFn, AbstractControl } from '@angular/forms';
import { Router } from '@angular/router';
import { Base64 } from 'js-base64';
import { Data } from 'app/data';
import * as moment from 'moment';
import { NgxSpinnerService } from 'ngx-spinner';
import { first } from 'rxjs/operators';


declare const $: any;

@Component({
  selector: 'ehr-studentregistration',
  templateUrl: 'registration.component.html',
  styleUrls: ['../home.component.css']

})

export class RegistrationComponent implements OnInit {
  registerForm: FormGroup;
  value = false;
  statusCode: any;
  buttonName: string;
  providerType_search: string = '';
  flag: boolean =false;
  

  // allStudentDetails: StudentDetails[] = [];
  constructor(private formBuilder: FormBuilder,
    private router: Router,
    private spinner: NgxSpinnerService,
    private sharedData: Data,

  ) { }

  isFieldValid(form: FormGroup, field: string) {
    
      if(!form.get(field).valid && form.get(field).touched) {
        if(field == "providerType") {
          $('#providerTypesDiv').addClass('is-empty');
        }
        else if(field == "dob"){
          $('#dobdiv').addClass('is-empty');
        }
     }
    return !form.get(field).valid && form.get(field).touched;
  }


  displayFieldCss(form: FormGroup, field: string) {
    return {
      'has-error': this.isFieldValid(form, field),
      'has-feedback': this.isFieldValid(form, field)
    };
  }
  ngOnInit() {
  this.registerForm = this.formBuilder.group({
      firstName: [null, [Validators.required, Validators.maxLength(50)]],
      lastName: [null, [Validators.required, Validators.maxLength(50)]],
      gender: [null, [Validators.required]],
      dob: [null, [Validators.required]],
      other: [null, [Validators.required, Validators.maxLength(50)]],
      providerType: [null, [Validators.required, Validators.maxLength(50)]],
      mobileNo: [null, [Validators.required, Validators.minLength(12)]],
      email: [null, [Validators.required, this.ValidateEmail(), Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$")]]
    });
    window.setTimeout(function () {
      $(".alert").fadeTo(500, 0).slideUp(500, function () {
        $(this).remove();
      });
    }, 4000);
    //console.log($('#providerType'));
    $('#providerTypesDiv').addClass('is-empty');
    $('#dobdiv').addClass('is-empty');
    //this.getProviderTypes();
    console.log($('#registrationMainDiv'));
  
  }
  setTimeOut() {
    window.setTimeout(function () {
      $(".alert").fadeTo(2000, 500).slideUp(500, function () {
        $(".alert").slideUp(500);
      });
    }, 4000);
  }

  showModal() {

  //  console.log("ShowModal");
    this.value = !this.value;
    $("#expansionPanel2").show();

  }


  onsubmit(event: any) {
    this.router.navigate(['../login']);


/*    if (this.registerForm.valid) {

      (<HTMLInputElement>document.getElementById("save")).disabled = true;
      let firstName = this.registerForm.get('firstName').value.trim();
      let lastName = this.registerForm.get('lastName').value.trim();
      let gender = this.registerForm.get('gender').value.trim();
      let dob = moment.utc((document.getElementById("dob") as HTMLInputElement).value).toDate();
      let email = this.registerForm.get('email').value.trim();
      let mobileNo = this.registerForm.get('mobileNo').value.trim();
      let pType = this.registerForm.get('providerType').value;
      let other = this.registerForm.get('other').value.trim();

      let loginId = firstName + lastName.charAt(0);
      let staffImage = "";
      let providerType ="";

      if(pType == 'Others'){
        providerType = other;
      }else{
        providerType = pType;
      }


      let staffMemToInsert = new StaffMember(0, loginId.toLowerCase(), "password", firstName, null, lastName, 
        staffImage, providerType, "TRY_ME", "N", 0, false, 1,
        mobileNo, null, email, null, null, null, null, null, null, null, null, null, null, null, 
        null, null, null, null, null, dob, gender, null);
      //console.log(staffMemToInsert)
      this.staffMemberService.insertStaffMember(staffMemToInsert)
        .subscribe(data => {
          console.log(data.staffId)
          let staffRoleToInsert = new StaffRole(0, data.staffId, "TRY_ME", true, null, null, null, null);
          this.staffMemberService.insertStaffRole(staffRoleToInsert)
            .subscribe(sucessCode => {
              this.statusCode = sucessCode;
              this.router.navigate(['/login']);
            },
              errorCode => this.statusCode = errorCode);
        },



          ErrorCode => {
            (<HTMLInputElement>document.getElementById("save")).disabled = false;
            this.statusCode = ErrorCode;
            this.setTimeOut();

          })


    }
    else {
      this.validateAllFormFields(this.registerForm);
    }

*/
  }
  validateAllFormFields(formGroup: FormGroup) {
    Object.keys(formGroup.controls).forEach(field => {
      const control = formGroup.get(field);
      if (control instanceof FormControl) {
        control.markAsTouched({ onlySelf: true });
      } else if (control instanceof FormGroup) {
        this.validateAllFormFields(control);
      }
    });
  }

  ValidateEmail(): ValidatorFn {
    return (control: AbstractControl): { [key: string]: boolean } | null => {
      let email = control.value;
      if (email != null) {

      }
      else {
        return null;
      }
    }
  }

  dobDatepicker(val, val1) {
     $('#dobdiv').removeClass('is-empty');
    var self = this;
    if (this.buttonName == 'ADD') {
      $(val1).addClass('customfloat');
    }
    $("#" + val).datepicker({
      Style: "padding-bottom:10px;",
      changeMonth: true,
      yearRange: "1900:+0",
      defaultDate: '01/01/1953',
      maxDate: new Date(),
      changeYear: true,
      beforeShow: function () {
        console.log("before show");
        $('#dobdiv').removeClass('is-empty');
        setTimeout(function () {
         $('.ui-datepicker').css('z-index', 99999999999999);
        }, 0);
        //$('#dobdiv').removeClass('is-empty');
      },
      onSelect: function () {
        $('#dobdiv').removeClass('is-empty');
        self.registerForm.get(val).setValue((document.getElementById(val) as HTMLInputElement).value);
      }
      
    }).datepicker("show");
  }

  clearField(val: any) {
    this.providerType_search = '';
    $(val).addClass('customfloat');
    $('#providerTypesDiv').removeClass('is-empty');
  }

  checkOther(val: any){
    if(val == 'Others'){
      this.flag =true;
    }else{
      this.flag = false;
    }
  }
  // dissmissModalOnSubmit() {
  //   $('#staffButton').prop('disabled', false);
  //   setTimeout(() => {
  //     let element: HTMLElement = document.getElementById("dismissModalOnSubmit");
  //     element.click();
  //   }, 200);
  //   this.getAllStudents();
  // }
  // getAllStudents() {
  //   this.spinner.show();
  //   this.setTimeOut();
  //   var self = this;
  //   this.studentDetailsService.getAllStudents()
  //     .subscribe(data => {
  //       this.spinner.hide();
  //       $('#datatables').DataTable().destroy();
  //       this.allStudentDetails = data;
  //       setTimeout(function () {
  //         self.initTable();
  //       }, 10);
  //     },
  //       errorCode => this.statusCode = errorCode);
  // }
  //   private initTable() {
  //     var table = $('#datatables').DataTable({
  //       "ordering": true,
  //       columnDefs: [
  //         { orderable: false, targets: ["All"] }],
  //       "language": {
  //         "emptyTable": " "
  //       },
  //       "info": false,
  //       "bLengthChange": false,
  //       "dom": 'lrtip'
  //     });

  // }

}