import { Component, OnInit, AfterViewInit, AfterContentInit } from '@angular/core';
import { Router } from '@angular/router';
import { Data } from 'app/data';
import { NgxSpinnerService } from 'ngx-spinner';
import { LoginService } from 'app/home/login/loginService';
import { CurrentUserService } from 'app/profiles/currentUserService';
import { FormBuilder, FormGroup, RequiredValidator } from '@angular/forms';
import { DocumentApprovalDetails } from 'app/models/workflowApprovalDetails';
import { WorkflowApprovalDetailsService } from 'app/services/workflowApprovalDetailsService';
import { WorkflowDetailsService } from 'app/services/workflowDetailsService';
import { Workflow } from 'app/models/workflow';

declare interface DataTable {
    headerRow: string[];
    footerRow: string[];
    dataRows: string[][];
}

declare const $: any;

interface FileReaderEventTarget extends EventTarget {
    result: string;
}

interface FileReaderEvent extends Event {
    target: FileReaderEventTarget;
    getMessage(): string;
}

@Component({
    selector: 'ehr-patientlist',
    templateUrl: './approvalpending.component.html',
    styleUrls: ['../../workflow/worflow.component.css', '../../app.component.css']
})

export class ApprovalPendingListComponent implements OnInit {
    public dataTable: DataTable = {
        headerRow: ['Project Name', 'Document Category', 'File Name', 'Uploaded By-On','Workflow Details', 'Actions'],
        footerRow: [],
        dataRows: []
    };

    statusCode: number;
    processValidation = false;
    requestProcessing = false;
    fullName: any;
    selected: any;
    disable: boolean = false;
    userRole: string;
    docApproval: FormGroup;
    docRejection: FormGroup;
    status: string;
    imageUrl: File;
    staffImage: any;
    sizeofimage: number;
    pendingDoc: Workflow[];
    isNotValidImageSize: boolean;
    currentFileUpload: any;
    approvalData: DocumentApprovalDetails;
    rejectData: DocumentApprovalDetails;

    primaryProvider: any;

    constructor(private router: Router,
        private formBuilder: FormBuilder,
        private sharedData: Data,
        private loginService: LoginService,
        private currentUserService: CurrentUserService,
        private workflowService: WorkflowDetailsService,
        private workflowDetailsSerivce: WorkflowApprovalDetailsService,
        private spinner: NgxSpinnerService) { }

    isFieldValid(form: FormGroup, field: string) {
        return !form.get(field).valid && form.get(field).touched;
    }

    displayFieldCss(form: FormGroup, field: string) {
        return {
            'has-error': this.isFieldValid(form, field),
            'has-feedback': this.isFieldValid(form, field)
        };
    }

    ngOnInit() {
        // this.getAllPatients();
        this.docApproval = this.formBuilder.group({
            comments: [null],
            status: [null]
        })

        this.docRejection = this.formBuilder.group({
            remarks: [null],
            docUrl: [null],
            flag: [null]

        })
        this.getAllPendingDoc();
        //console.log($('#chooseFile').innerText);
    }

    getAllPendingDoc() {
        this.spinner.show();
        this.setTimeOut();
        var self = this;
        this.workflowService.getPendingDocuments()
        .subscribe(data => {
            this.spinner.hide();
            $('#datatables').DataTable().destroy();
            this.dataTable.dataRows = <any>data;
            this.pendingDoc = data;
            setTimeout(function () {
              self.initTable();
            }, 5);
          },
            errorCode => this.statusCode = errorCode);
    }

    setTimeOut() {
        window.setTimeout(function () {
          $(".alert").fadeTo(2000, 500).slideUp(500, function () {
            $(".alert").slideUp(500);
          });
        }, 4000);
    }
    
    DateOfBirth(date) {
        return new Date(date);
    }

    disabled(addinfo: any) {
        if (addinfo == "Deceased" || addinfo == "Inactive") {
            return true;
        }
        else {
            return false;
        }
    }


    selectFile(event) {
        this.sizeofimage = event.target.files[0].size;
        console.log(event.target.files[0].name);
        if (this.sizeofimage < 30000) {
            this.isNotValidImageSize = false;
            this.imageUrl = event.target.files;
            this.currentFileUpload = event.target.files[0];
            if (event.target.files && this.currentFileUpload) {
                const reader = new FileReader();
                reader.onload = function (e: FileReaderEvent) {
                    //$('#wizardPicturePreview').attr('src', e.target.result).fadeIn('slow');
                    $('#url').attr('value', reader.result);
                    $('#docName').attr('value', event.target.files[0].name);
                };
                reader.readAsDataURL(this.currentFileUpload);
            }
        }
        else {
            this.isNotValidImageSize = true;
            this.staffImage = "";
        }
    }

    approvalFormSubmit() {
        if (this.docApproval.valid) {
            $("#approvSubmit").prop('disabled', true);

            let comments = this.docApproval.get('comments').value;
            let status = $("status").val();

            let docApprv = new DocumentApprovalDetails(0, 1, 1, '', null, status, comments, true, '', null, null, null);

            this.workflowDetailsSerivce.insertDocumentStatus(docApprv)
                .subscribe(data => {
                    // console.log("calleddddd")
                    $('#rejectsubmit').prop('disabled', false);
                    this.router.navigate(['/workflow/approvallist']);
                }, ErrorCode => {
                    this.statusCode = ErrorCode;
                    $('#approvSubmit').prop('disabled', false);
                })
        }
    }

    rejectFormSubmit() {
        //console.log("rejected calleddd");
        if (this.docRejection.valid) {
            $('#rejectsubmit').prop('disabled', true);

            let docURL = $('#url').val();
            let status = $('#flag').val();
            let docName = $("#docName").val();
            let comments = this.docRejection.get('remarks').value;

            let docReject = new DocumentApprovalDetails(0, 1, 1, docName, docURL, status, comments, true, '', null, null, null);

            this.workflowDetailsSerivce.insertDocumentStatus(docReject)
                .subscribe(data => {
                    $('#rejectsubmit').prop('disabled', false);
                    this.router.navigate(['/workflow/approvallist']);
                }, ErrorCode => {
                    this.statusCode = ErrorCode;
                    $('#rejectsubmit').prop('disabled', false);
                })
        }
    }
    addNewWorkFlow() {
        this.router.navigate(['/workflow/newworkflow']);

    }

    closeModal() {
        $('.modal').modal('hide');
    }

    openModal() {
        $('.modal').modal('show');
    }

    preProcessConfigurations() {
        this.statusCode = null;
        this.requestProcessing = true;
    }

    //Redirection for Patient History
    loadHistory(patientId: number) {
        this.router.navigate(['/patients/addencounter/' + patientId]);
    }

    datepicker(val) {
        var self = this;
        $("#" + val).datepicker({
            Style: "padding-top:10px;",
            changeMonth: true,
            yearRange: "1900:+0",
            defaultDate: '01/01/1953',
            maxDate: new Date(),
            changeYear: true,
            beforeShow: function () {
                setTimeout(function () {
                    $('.ui-datepicker').css('z-index', 99999999999999);
                }, 0);
            },


        }).datepicker("show");

        $(function () {
            $("#" + val).datepicker();
            $("#" + val).on("change", function () {
                this.selected = $(this).val();
                var table = $('#datatables').DataTable();
                table.search(this.selected).draw();
            });
        });
    }

    openDetails() {
        this.router.navigate(['/workflow/viewWorkflowDetails']);
    }

    private initTable() {
        var table = $('#datatables').DataTable({
          "ordering": true,
          columnDefs: [
            { orderable: false, targets: ["All"] }],
          "language": {
            "emptyTable": " "
          },
          "info": false,
          "bLengthChange": false,
          "dom": 'lrtip'
        });
    
        // Delete a record
        table.on('click', '.remove', function (e: any) {
          const $tr = $(this).closest('tr');
          table.row($tr).remove().draw();
          e.preventDefault();
        });
      }
    
      searchdata(v) {
        var table = $('#datatables').DataTable();
        console.log(v);
        table.search(v.target.value).draw();
      }
    
      changePage(x) {
        if (x.target.value == -1) {
          $('#datatables').DataTable().destroy();
          $('#datatables').DataTable({
            "pagingType": "full_numbers",
            "lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
            "dom": '<lrt<t>p>',
            "pageLength": -1,
            "bLengthChange": false,
          });
        }
        else {
          $('#datatables').DataTable().destroy();
          $('#datatables').DataTable({
            "dom": '<lrt<t>p>',
            "pageLength": x.target.value,
            "bLengthChange": false,
          });
        }
    }

    setDocumentSrc(url: string){
        console.log(url);
        $("#docURL").attr("src",url);
    }
    

}