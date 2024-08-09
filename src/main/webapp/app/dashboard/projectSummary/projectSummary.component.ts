// IMPORTANT: this is a plugin which requires jQuery for initialisation and data manipulation

import { Component, OnInit, AfterViewInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { DatePipe } from '@angular/common';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import 'chart.piecelabel.js';
import * as Chartist from 'chartist';
import { LoadingModule, ANIMATION_TYPES } from 'ngx-loading';
import * as jQuery from 'jquery'
import { Observable } from 'rxjs';
import { DashboardService } from '../dashboard.service';
import { DataService } from './dataService';
import { NgxSpinnerService } from 'ngx-spinner';

declare const swal: any;
// declare const $: any;
declare var $: JQueryStatic;

declare interface DataTable {
    headerRow: string[];
    footerRow: string[];
    dataRows: string[][];
}

declare interface Chart {
    labels: string[];
    chartValue: number[];
    chartType: string;
    colors: any;
    options: any;
}

@Component({
    selector: 'idms-projectsummary',
    templateUrl: 'projectSummary.component.html',
    styleUrls: ['../projectSummary/projectSummary.component.css', '../../app.component.css']
})



export class ProjectSummaryComponent implements OnInit {
    public ANIMATION_TYPES = ANIMATION_TYPES;
    public loading = false;
    dashboardValue: string;

    constructor(private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private dashboardservice: DashboardService,
        public _data: DataService,
        private spinner: NgxSpinnerService,
        public datepipe: DatePipe) { }

    fName: string;
    lName: string;
    show: boolean = false;
    public providerViewChart: Chart;
    public statusChart: Chart;
    public departmentChart: Chart;
    ccmSummaryForm: FormGroup;
    providerViewChartData: number[];
    date = new Date();
    appointmentMonth: any;
    appointmentYear: any;
    data: string;
    dt_fullNameEnc: any;
    selectedDate: string;
    statusCode: number;
    provViewStaus: string[] = ['Complete', 'Incomplete']
    docViewStaus: string[] = ['Approved','Pending','Rejected']

    summaryIsDisabled: boolean = false;

    ngOnInit() {

        this.loading = true;
        var canvas = <HTMLCanvasElement>document.getElementById("myCanvas");
        var ctx = canvas.getContext("2d");
        ctx.font = "11px Arial";
        //ctx.fillText("Requires moderate to high complexity medical decision making", 10, 10);

        if (this._data.successMessageData != undefined) {
            this.dt_fullNameEnc = this._data.successMessageData.dt_fullNameEnc;
            window.setTimeout(function () {
                $(".alert").fadeTo(500, 0).slideUp(500, function () {
                    $(this).remove();
                });
            }, 4000);
            this._data.successMessageData = null;
        }

        this.ccmSummaryForm = this.formBuilder.group({
            monthPicker: [null]
        });

        //this.selectedMonth()

        // $('#datatable').DataTable( {

        // } );


        this.providerViewChart = {
            labels: ["Complete", "Incomplete"],
            chartType: 'pie',
            chartValue: [83,62],
            // colors: [ {backgroundColor:['#FF8A80','#9255FF','#75ED97','#FFA589','#FFFF5A','#BCAAA4','#CE93D8','#90CAF9']} ],
            colors: [{ backgroundColor: ['#0471af', '#4a99c7'] }],
            options: {
                pieceLabel: {
                    render: function (args) {
                        const value = args.value;
                        return value;
                    },
                    fontColor: 'black'
                },
                legend: { position: 'right', labels: { boxWidth: 10, padding: 3 } }
            }
        }

        this.departmentChart = {
            labels: ["Complete", "Incomplete"],
            chartType: 'pie',
            chartValue: [6,2],
            // colors: [ {backgroundColor:['#FF8A80','#9255FF','#75ED97','#FFA589','#FFFF5A','#BCAAA4','#CE93D8','#90CAF9']} ],
            colors: [{ backgroundColor: ['#0471af', '#4a99c7'] }],
            options: {
                pieceLabel: {
                    render: function (args) {
                        const value = args.value;
                        return value;
                    },
                    fontColor: 'black'
                },
                legend: { position: 'right', labels: { boxWidth: 10, padding: 3 } }
            }
        }

        this.statusChart = {
            labels: ["Approved", "Pending", "Rejected"],
            chartType: 'pie',
            chartValue: [347,270,43],
            colors: [{ backgroundColor: ['#0471af', '#4a99c7', '#999999'] }],
            options: {
                pieceLabel: {
                    render: function (args) {
                        const value = args.value;
                        return value;
                    },
                    fontColor: 'black'
                },
                legend: { position: 'right', labels: { boxWidth: 10, padding: 3 } }
            }
        }

        $.fn.dataTable.ext.search.push(
            function (settings, data, dataIndex) {


                var min = parseInt($('#min').val(), 10);
                var max = parseInt($('#max').val(), 10);
                var check;
                // console.log(check);
                if ((document.getElementById("pieValue") as HTMLInputElement) !== null) {
                    check = (document.getElementById("pieValue") as HTMLInputElement).value;
                }

                var range;
                if (check == 'provider') {
                    range = parseFloat(data[4]) || 0;
                } else {
                    range = parseFloat(data[3]) || 0;
                }
                //    console.log(range)
                var user;
                if ((document.getElementById("user") as HTMLInputElement) !== null) {
                    user = (document.getElementById("user") as HTMLInputElement).value || null;
                }

                var userRow = data[2] || "";

                if ((isNaN(min) && isNaN(max) && (user == null)) ||

                    (isNaN(min) && range <= max && (user == null || (user === userRow))) ||
                    ((min <= range && isNaN(max)) && (user == null || (user === userRow))) ||
                    ((min <= range && range <= max) && (user == null || (user === userRow)))) {
                    return true;
                }
                return false;
            }

        );
    }

    selectedMonth() {
        //Provider view dashboard
        this.providerViewChart.chartValue = [2,
            3];

        this.statusChart.chartValue = [15,10,4];
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

}






