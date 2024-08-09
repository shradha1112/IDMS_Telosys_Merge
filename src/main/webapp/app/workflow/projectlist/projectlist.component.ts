import { Component, OnInit, AfterViewInit, AfterContentInit } from '@angular/core';
import { Router } from '@angular/router';
import { Data } from 'app/data';
import { NgxSpinnerService } from 'ngx-spinner';
import { LoginService } from 'app/home/login/loginService';
import { CurrentUserService } from 'app/profiles/currentUserService';
import { ProjectDetailsService } from 'app/services/projectDetailsService';

declare interface DataTable {
    headerRow: string[];
    footerRow: string[];
    dataRows: string[][];
}

declare const $: any;

@Component({
    selector: 'project-list',
    templateUrl: './projectlist.component.html',
    styleUrls: ['../../workflow/worflow.component.css', '../../app.component.css']
})

export class ProjectListComponent implements OnInit {
    public dataTable: DataTable = {
        headerRow: ['Project Name', 'Project ID/Number', 'Project Description','Project Manager','Start Date - End Date','Created By-On', 'Actions'],
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
    
    primaryProvider: any;

    constructor(private router: Router,
        private sharedData: Data,
        private loginService : LoginService,
        private projectService: ProjectDetailsService,
        private currentUserService: CurrentUserService,
        private spinner: NgxSpinnerService) { }

    ngOnInit() {
       this.getAllProjectList();
      
    }

    getAllProjectList() {
        this.spinner.show();
        var self = this;
        this.projectService.getAllProjects()
            .subscribe(data => {
                this.spinner.hide();
                //console.log(data);
                $('#datatables').DataTable().destroy();
                this.dataTable.dataRows = <any>data;
                setTimeout(function () {
                    self.initTable();
                }, 5);
            },
                errorCode => this.statusCode = errorCode);
    }

    DateOfBirth(date) {
        return new Date(date);
    }
    disabled(addinfo:any)
    {
        if(addinfo=="Deceased" || addinfo=="Inactive")
        {
            return true;
        }
        else
        {
            return false ;
        }
    }


    deleteProject(){
        this.statusCode = 202;
    }

    addNewProject(){
        localStorage.removeItem('projectAction');
        this.router.navigate(['/workflow/newProject']);
    }

    editProject(){
        localStorage.setItem('projectAction','update')
        this.router.navigate(['/workflow/newProject']);
        
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

     //Redirection for Patient History
     loadHistory(patientId: number) {
        this.router.navigate(['/patients/addencounter/'+patientId]);
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

    searchdata(val) {
        var hasNumber = /\d/;
        var table = $('#datatables').DataTable();
        if (!hasNumber.test(val.target.value)) {
            table.search(val.target.value).draw();
        }
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

}