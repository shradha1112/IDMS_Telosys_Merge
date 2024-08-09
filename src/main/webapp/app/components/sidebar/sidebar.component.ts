import { Component, OnInit, SimpleChanges, ElementRef } from '@angular/core';
import PerfectScrollbar from 'perfect-scrollbar';
import { RoleGuardService } from '../../shared/AuthGuard/RoleGuardService';
import { CurrentUserService } from 'app/profiles/currentUserService';
import { LoginService } from 'app/home/login/loginService';
import { Staff } from 'app/models/staff';

const misc: any = {
    navbar_menu_visible: 0,
    active_collapse: true,
    disabled_collapse_init: 0,
};

declare const $: any;

interface FileReaderEventTarget extends EventTarget {
    result: string;
}

interface FileReaderEvent extends Event {
    target: FileReaderEventTarget;
    getMessage(): string;
}
//Metadata
export interface RouteInfo {
    path: string;
    title: string;
    type: string;
    icontype: string;
    collapse?: string;
    children?: ChildrenItems[];
}

export interface ChildrenItems {
    path: string;
    title: string;
    icontype: string;
    type?: string;
    collapse?: string;
    children?: ChildrenItems[];
}

//Menu Items
export const ROUTES: RouteInfo[] = [
    {
        path: '/workflow',
        title: 'Admin Tools',
        type: 'sub',
        icontype: 'important_devices',
        collapse: 'projects',
        children: [

            { path: 'departmentlist', title: 'Department', icontype: 'folder' },
            { path: 'subDepartmentList', title: 'Sub-Department', icontype: 'topic' },
            { path: 'stafflist', title: 'Staff', icontype: 'person' },
            { path: 'projectList', title: 'Project', icontype: 'laptop' },
            { path: 'documentCategory', title: 'Document Category', icontype: 'subject' },


        ]
    },
    {
        path: '/editprofile',
        title: 'User Profile',
        type: 'hide',
        icontype: ''
    }
];

@Component({
    selector: 'ehr-sidebar',
    templateUrl: 'sidebar.component.html',
    styleUrls: ['sidebar.component.css', '../../app.component.css'],
})

export class SidebarComponent implements OnInit {
    private toggleButton: any;
    private sidebarVisible: boolean;
    requestProcessing = false;
    statusCode: any;
    public menuItems: any[];
    organizationId: number;
    isadmin: boolean = false;
    private listTitles: any[];
    private nativeElement: Node;
    loggedInUser: Staff;
    staffImage: any;
    dashboardURL: string;

    constructor(private roleguard: RoleGuardService,
        private currentUserService: CurrentUserService,
        private element: ElementRef) {
        this.nativeElement = element.nativeElement;
        this.sidebarVisible = false;
    }

    isMobileMenu() {
        if ($(window).width() > 0) {
            return false;
        }
        return true;
    };


    ngOnChanges(change: SimpleChanges) {
        const input = $(this);
        if (input[0].files && input[0].files[0]) {
            const reader: any = new FileReader();
            reader.onload = function (e: FileReaderEvent) {
                $('#wizardPicturePreview').attr('src', e.target.result).fadeIn('slow');
            };
            reader.readAsDataURL(input[0].files[0]);
        }
    }


    ngOnInit() {

        this.adminCheck();
        this.sidebarProfileRefresh();
        this.getLoggedInUserDetails();
        this.menuItems = ROUTES.filter(menuItem => menuItem);
        //        console.log(this.menuItems);

        $('body').addClass('sidebar-mini');
        this.listTitles = ROUTES.filter(listTitle => listTitle);

        const navbar: HTMLElement = this.element.nativeElement;
        this.toggleButton = navbar.getElementsByClassName('navbar-toggle')[0];
        if ($('body').hasClass('sidebar-mini')) {
            misc.sidebar_mini_active = true;
        }
        if ($('body').hasClass('hide-sidebar')) {
            misc.hide_sidebar_active = true;
        }
        $('#minimizeSidebar').click(function () {
            if (misc.sidebar_mini_active === true) {
                $('body').removeClass('sidebar-mini');
                misc.sidebar_mini_active = false;

            } else {
                setTimeout(function () {
                    $('body').addClass('sidebar-mini');

                    misc.sidebar_mini_active = true;
                }, 300);
            }

            // we simulate the window Resize so the charts will get updated in realtime.
            const simulateWindowResize = setInterval(function () {
                window.dispatchEvent(new Event('resize'));
            }, 180);

            // we stop the simulation of Window Resize after the animations are completed
            setTimeout(function () {
                clearInterval(simulateWindowResize);
            }, 1000);
        });
        $('#hideSidebar').click(function () {
            if (misc.hide_sidebar_active === true) {
                setTimeout(function () {
                    $('body').removeClass('hide-sidebar');
                    misc.hide_sidebar_active = false;
                }, 300);
                setTimeout(function () {
                    $('.sidebar').removeClass('animation');
                }, 600);
                $('.sidebar').addClass('animation');

            } else {
                setTimeout(function () {
                    $('body').addClass('hide-sidebar');
                    // $('.sidebar').addClass('animation');
                    misc.hide_sidebar_active = true;
                }, 300);
            }

            // we simulate the window Resize so the charts will get updated in realtime.
            const simulateWindowResize = setInterval(function () {
                window.dispatchEvent(new Event('resize'));
            }, 180);

            // we stop the simulation of Window Resize after the animations are completed
            setTimeout(function () {
                clearInterval(simulateWindowResize);
            }, 1000);
        });
    }


    sidebarProfileRefresh() {
        this.preProcessConfigurations();
    }

    getLoggedInUserDetails() {
        this.currentUserService.getCurrentStaffMember()
            .subscribe(data => {
                this.loggedInUser = data;
                if (data.staffImage == null || data.staffImage == "") {
                    this.staffImage = "./assets/img/default-avatar.png";
                }
                else {
                    this.staffImage = data.staffImage;
                }
            })
    }

    updatePS(): void {
        if (window.matchMedia(`(min-width: 960px)`).matches && !this.isMac()) {
            const elemSidebar = <HTMLElement>document.querySelector('.sidebar .sidebar-wrapper');
            let ps = new PerfectScrollbar(elemSidebar, { wheelSpeed: 2, suppressScrollX: true });
        }
    }

    logout() {

        localStorage.removeItem('jwt');
    }

    adminCheck() {
        this.roleguard.roleCheck()
            .subscribe(successCode => {
                this.statusCode = successCode;
                if (this.statusCode === 200) {
                    this.isadmin = true;
                    this.dashboardURL = '/dashboard/dashboardView'
                }
                else {
                    this.isadmin = false;
                    this.dashboardURL = '/dashboard'
                }
            },
                errorCode => {
                    this.statusCode = errorCode;
                    this.isadmin = false;
                    this.dashboardURL = '/dashboard'
                });
    }

    isMac(): boolean {
        let bool = false;
        if (navigator.platform.toUpperCase().indexOf('MAC') >= 0 || navigator.platform.toUpperCase().indexOf('IPAD') >= 0) {
            bool = true;
        }
        return bool;
    }

    sidebarToggle() {
        if (this.sidebarVisible === false) {
            this.sidebarOpen();
        } else {
            this.sidebarClose();
        }
    };

    sidebarClose() {
        const body = document.getElementsByTagName('body')[0];
        this.toggleButton.classList.remove('toggled');
        this.sidebarVisible = false;
    };

    sidebarOpen() {
        const toggleButton = this.toggleButton;
        const body = document.getElementsByTagName('body')[0];
        setTimeout(function () {
            toggleButton.classList.add('toggled');
        }, 500);
        this.sidebarVisible = true;
    };

    preProcessConfigurations() {
        this.statusCode = null;
        this.requestProcessing = true;
    }
}