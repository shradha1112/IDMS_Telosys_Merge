export class Staff{
	constructor(public loginId: number, 
				public staffId: number,
				public departmentId:number,
				public loginKey:string,
				public manager:string,
				public firstName:string,
				public middleName:string,
				public lastName:string,
				public staffImage:string,
				public designation:string,
				public activeFlag: boolean, 
				public mobileNo:string,
				public email:string,
				public lastAction:string,
				public lastLoginDate:Date,
				public lastActionDate:string,
				public createdBy: string,
                public createdDate: Date,
                public lastUpdatedBy: string,
                public lastUpdatedDate: Date,
				public gender: string,
				public doj:Date,
                ) { 
    }
} 

