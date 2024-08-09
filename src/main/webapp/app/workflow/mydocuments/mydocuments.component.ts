import { Component, OnInit, AfterViewInit, AfterContentInit } from '@angular/core';
import { Router } from '@angular/router';
import { Data } from 'app/data';
import { NgxSpinnerService } from 'ngx-spinner';
import { LoginService } from 'app/home/login/loginService';
import { CurrentUserService } from 'app/profiles/currentUserService';
import { WorkflowDetailsService } from 'app/services/workflowDetailsService';
import { WorkFlow } from '../workflow.module';
import { Staff } from 'app/models/staff';

declare interface DataTable {
    headerRow: string[];
    footerRow: string[];
    dataRows: string[][];
}

declare const $: any;

@Component({
    selector: 'dms-myDocumentList',
    templateUrl: './mydocuments.component.html',
    styleUrls: ['../../workflow/worflow.component.css', '../../app.component.css']
})

export class MyDocumentComponent implements OnInit {
    public dataTable: DataTable = {
        headerRow: ['Project Name', 'Document Category', 'Document Name', 'Uploaded By-On','Status','Workflow Details', 'Actions'],
        footerRow: [],
        dataRows: []
    };

    public teamData: DataTable = {
      headerRow: ['Project Name', 'Document Category', 'Document Name', 'Author Name','Uploaded By-On','Updated By-On','Status',],
      footerRow: [],
      dataRows: []
  };

    statusCode: number;
    processValidation = false;
    requestProcessing = false;
    fullName: any;
    selected: any;
    disable:boolean=false;
    userRole: string;
    tabList: any[];
    allDocuments: WorkFlow[];
    flag:boolean = false;
    viewDetails:boolean = false;
    loggedInUser: Staff[];
    primaryProvider: any;
    checkout: boolean = false;

    constructor(private router: Router,
        private sharedData: Data,
        private spinner: NgxSpinnerService,
        private workflowService: WorkflowDetailsService,
        private currentUserService: CurrentUserService) { }

    ngOnInit() {
       this.getAllDocuments();
       this.tabList = ["My Documents","Team Documents"]; 
       this.flag = true;
    }

    addNewWorkFlow(){
        this.router.navigate(['/workflow/newworkflow']);

    }

    getAllDocuments(){
        this.spinner.show();
        this.setTimeOut();
        var self = this;
        this.workflowService.getAllDocuments()
        .subscribe(data => {
            this.spinner.hide();
            $('#datatables').DataTable().destroy();
            this.dataTable.dataRows = <any>data;
            this.allDocuments = data;
            console.log(data);
            setTimeout(function () {
              self.initTable();
            }, 0);
          },
            errorCode => this.statusCode = errorCode);
    }

    dateConversion(date){
            return new Date(date);
    
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

    
    openDetails(){
        localStorage.removeItem('status');
        this.router.navigate(['/workflow/viewWorkflowDetails']);
    }

    openAppDetails(){
        localStorage.setItem('status','approved');
        this.router.navigate(['/workflow/viewWorkflowDetails']);
    }
    id(){

    }

    openAction(event,inde){

        if(event.value[inde] == 'checkout'){
            this.checkout[inde] = true;
        }else if(event.value == 'checkin'){
            this.statusCode = 201;
            this.setTimeOut();
           // $("#exampleModalLong").css('display','contents');
        }else if(event.value == 'view'){
          // $("#bannerformmodal").css('display','contents');
        }
    }

    openTick(){
        this.checkout = true;
    }

    openAlert(event){
        if(event.value == 'checkout'){
            this.statusCode = 428;
            this.setTimeOut();
        }
    }

    setTimeOut() {
        window.setTimeout(function () {
          $(".alert").fadeTo(2000, 500).slideUp(500, function () {
            $(".alert").slideUp(500);
          });
        }, 4000);
    }
    onProjectName(){
        $('#projectName_floatToLabel').css('top','-30px');
    }

    
    onApproverName(){
        $('#approverName_floatToLabel').css('top','-30px');
    }

    onDepartmentName(){
        $('#deptName_floatToLabel').css('top','-30px');
    }

    onDocumentCategory(){
        $('#docCategory_floatToLabel').css('top','-30px');
    }

      
      


      

}