import { Component, OnInit, Pipe, PipeTransform } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators, ValidatorFn, AbstractControl } from '@angular/forms';
import { Router } from '@angular/router';
import { Data } from '../../data';
import { NgxSpinnerService } from 'ngx-spinner';
import * as moment from 'moment';

declare const $:any;
interface FileReaderEventTarget extends EventTarget {
  result: string;
}

interface FileReaderEvent extends Event {
  target: FileReaderEventTarget;
  getMessage(): string;
}


@Component({
  selector: 'ehr-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['../../app.component.css', '../profile.component.css']
})

export class EditProfileComponent implements OnInit {
  requestProcessing = false;
  staffImage: any;
  statusCode: number;
  staffMemberForm: FormGroup;
  isNotValidImageSize: boolean = false;
  currentFileUpload: any;
  imageUrl: File;
  adminFlag = "";
  _search: string = '';
  providerType_search: string = '';
  staffAddressId_search: string = '';
  showProviderType: boolean = false;
  isCredential:any;
  isadmin: boolean;
  staffId:any;
  constructor(
    private router: Router,
    private formBuilder: FormBuilder,
    private sharedData: Data,
    private spinner: NgxSpinnerService
  ) { }

  ngOnInit() {
    
  
    
  }
  
}