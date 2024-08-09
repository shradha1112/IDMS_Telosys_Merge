import { Component, OnInit, AfterViewInit, AfterContentInit } from '@angular/core';
import { Router } from '@angular/router';
import { Data } from 'app/data';
import { NgxSpinnerService } from 'ngx-spinner';
import { LoginService } from 'app/home/login/loginService';
import { CurrentUserService } from 'app/profiles/currentUserService';
import { DepartmentDetailsService } from 'app/services/departmentDetailsService';
import { Department } from 'app/models/department';
import { FormBuilder, FormGroup } from '@angular/forms';

declare interface DataTable {
    headerRow: string[];
    footerRow: string[];
    dataRows: string[][];
}

declare const $: any;

@Component({
    selector: 'department-list',
    templateUrl: './departmentlist.component.html',
    styleUrls: ['../../workflow/worflow.component.css', '../../app.component.css']
})

export class DepartmentListComponent implements OnInit {
    public dataTable: DataTable = {
        headerRow: ['Department Name', 'Department Description', 'Department Head', 'Created By-On', 'Actions'],
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
    newDepartment: boolean;
    updateDepartment: boolean;
    primaryProvider: any;
    allDepartments: Department[];
    deleteConfirmForm: FormGroup;

    constructor(private router: Router,
        private formBuilder: FormBuilder,
        private sharedData: Data,
        private loginService: LoginService,
        private departmentService: DepartmentDetailsService,
        private currentUserService: CurrentUserService,
        private spinner: NgxSpinnerService) { }

    ngOnInit() {
        this.getAllDepartmentList();

        this.deleteConfirmForm = this.formBuilder.group({
            deptId: [null]
        });
    }

    getAllDepartmentList() {
        this.spinner.show();
        var self = this;
        this.departmentService.getAllDepartments()
            .subscribe(data => {
                this.spinner.hide();
                //console.log(data);
                $('#datatables').DataTable().destroy();
                this.dataTable.dataRows = <any>data;
                this.allDepartments = data;
                setTimeout(function () {
                    self.initTable();
                }, 5);
            },
                errorCode => this.statusCode = errorCode);
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

    addNewDepartment() {
        //this.newDepartment = true;
        localStorage.removeItem('mode');
        this.router.navigate(['/workflow/newDepartment']);
    }

    editDepartment(departmentId: number) {
        localStorage.setItem('mode', 'update');
        this.router.navigate(['/workflow/newDepartment',departmentId]);
    }

    loadDeleteConfirmModal(deptId: number) {
        this.deleteConfirmForm.get("deptId").setValue(deptId);
    }

    deleteDepartment(departmentId: number) {
        $('#deleteDept').prop('disabled', true);
        this.preProcessConfigurations();

        this.departmentService.deleteDepartment(departmentId)
            .subscribe(successCode => {
                this.statusCode = successCode;
                if (this.statusCode === 200) {
                    $('#deleteConfirmationModal').modal('hide');
                    this.getAllDepartmentList();
                }
            },
                errorCode => {
                    $('#deleteDept').prop('disabled', false);
                    this.statusCode = errorCode;
                    if (this.statusCode === 428) {
                        this.closeDeleteConfirmationModal();
                    }
                    this.setTimeOut();
                });
    }

    setTimeOut() {
        window.setTimeout(function () {
            $(".alert").fadeTo(2000, 500).slideUp(500, function () {
                $(".alert").slideUp(500);
            });
        }, 4000);
    }

    closeDeleteConfirmationModal() {
        $('#deleteConfirmationModal').modal('hide');
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