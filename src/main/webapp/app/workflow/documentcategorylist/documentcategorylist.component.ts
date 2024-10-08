import { Component, OnInit, AfterViewInit, AfterContentInit } from '@angular/core';
import { Router } from '@angular/router';
import { Data } from 'app/data';
import { NgxSpinnerService } from 'ngx-spinner';
import { LoginService } from 'app/home/login/loginService';
import { CurrentUserService } from 'app/profiles/currentUserService';
import { DocumentCategoryService } from 'app/services/documentCategoryService';

declare interface DataTable {
    headerRow: string[];
    footerRow: string[];
    dataRows: string[][];
}

declare const $: any;

@Component({
    selector: 'documentcategory-list',
    templateUrl: './documentcategorylist.component.html',
    styleUrls: ['../../workflow/worflow.component.css', '../../app.component.css']
})

export class DocumentCategoryListComponent implements OnInit {
    public dataTable: DataTable = {
        headerRow: ['Department Name', 'Category Name', 'Category Description', 'Visibility', 'Created By-On', 'Actions'],
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

    primaryProvider: any;

    constructor(private router: Router,
        private sharedData: Data,
        private loginService: LoginService,
        private documentCategoryService: DocumentCategoryService,
        private currentUserService: CurrentUserService,
        private spinner: NgxSpinnerService) { }

    ngOnInit() {
        this.getAllDocCategory();
    }

    getAllDocCategory() {
        this.spinner.show();
        var self = this;
        this.documentCategoryService.getAllDocumentCategories()
            .subscribe(data => {
                this.spinner.hide();
                console.log(data);
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

    disabled(addinfo: any) {
        if (addinfo == "Deceased" || addinfo == "Inactive") {
            return true;
        }
        else {
            return false;
        }
    }


    addNewStaff() {
        this.router.navigate(['/workflow/newStaff']);
    }

    addNewDocumentCategory() {
        localStorage.removeItem('action');
        this.router.navigate(['/workflow/newDocCategory']);

    }

    editCategory() {
        localStorage.setItem('action', 'update');
        this.router.navigate(['/workflow/newDocCategory']);

    }

    deleteCategory() {
        this.statusCode = 202;
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