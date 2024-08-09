import { Component, OnInit, AfterViewInit, Renderer } from '@angular/core';
import { TableData } from '../shared/md/md-table/md-table.component';
import { LegendItem, ChartType } from '../shared/md/md-chart/md-chart.component';
import { Router, ActivatedRoute } from '@angular/router';
import * as Chartist from 'chartist';
import { DashboardService } from './dashboard.service';
import { LoadingModule, ANIMATION_TYPES } from 'ngx-loading';
import { DataService } from './projectSummary/dataService';


declare const swal: any;
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
  selector: 'toggle-bttn',
  templateUrl: 'dashboard.component.html',
  styleUrls: ['../dashboard/dashboard.component.css', '../app.component.css']
})

export class DashboardComponent implements OnInit{
  public ANIMATION_TYPES = ANIMATION_TYPES;
  public loading = false;
  dashboardValue: string;
  fName: string;
  lName: string;
  show: boolean = false;
  public providerViewChart: Chart;
  public statusChart: Chart;
  public departmentChart: Chart;
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

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    public _data: DataService,
    private render: Renderer,
    private dashboardservice: DashboardService,
    
  ){} 
  
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

    this.providerViewChart = {
        labels: ["Complete", "Incomplete"],
        chartType: 'pie',
        chartValue: [7,3],
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
        chartValue: [50,24,6],
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
    
}