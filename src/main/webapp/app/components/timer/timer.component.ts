import { OnInit, Component, ViewChild } from "@angular/core";
import { Subject, Subscription } from "rxjs";
import { timer } from "rxjs/observable/timer";
import { AuthService } from "app/components/timer/auth.service";
import { TimerModalComponent } from "../timerModal/timer-modal.component";
import { CurrentUserService } from "app/profiles/currentUserService";
import { LoginService } from "app/home/login/loginService";

@Component({
    selector: 'ehr-timer',
    templateUrl: 'timer.component.html',
    styleUrls: ['timer.component.css', '../../app.component.css'],
})

export class TimerComponent implements OnInit {
    minutesDisplay: number;
    secondsDisplay: number;
    endTime = 15;
    unsubscribe$: Subject<void> = new Subject();
    timerSubscription: Subscription;
    showModal: boolean = false;

    options = {
        text: "Success !",
        type: "fail",
        autoDismis: false,
        timeout: 2000
    }

    constructor(
        private authService: AuthService,
        private currentUserService: CurrentUserService,
        private loginService : LoginService
        ) { }

    ngOnInit() {
        this.resetTimer();
        this.authService.userActionOccured.
            takeUntil(this.unsubscribe$)
            .subscribe(() => {
                if (this.timerSubscription) {
                    this.timerSubscription.unsubscribe();
                }
                this.resetTimer();
            });
    }

    resetTimer(endTime: number = this.endTime) {
        // console.log('heereeeee in reset')
        const interval = 1000;
        const duration = endTime * 60;
        this.timerSubscription = timer(0, interval).
            take(duration)
            .subscribe(value =>
                this.render((duration - +value) * interval),
            err => { },
            () => {
                //code here for logout.
                //this.setLogoutStatus()
                this.authService.logOutUser();
            }
            )
    }

    private render(count) {
        this.secondsDisplay = this.getSeconds(count);
        this.minutesDisplay = this.getMinutes(count);
        this.colorchange(this.minutesDisplay,this.secondsDisplay);
    }
    colorchange(minutes:number, seconds:number)
    {
     if(minutes<=2 && seconds<0)
     {
        document.getElementById("timer").style.borderColor="red"
     }
     else{
        document.getElementById("timer").style.borderColor="#0471af"
     }
    }

    private getSeconds(ticks: number) {
        const seconds = ((ticks % 60000) / 1000).toFixed(0);
        return this.pad(seconds);
    }

    private getMinutes(ticks: number) {
        const minutes = Math.floor(ticks / 60000);
        return this.pad(minutes);
    }

    private pad(digit: any) {
        return digit <= 9 ? '0' + digit : digit;
    }

}

