export class Project {
    constructor(public projectId: number, 
                public managerId: number,
                public activeFlag: string, 
                public createdBy: string,
                public createdOn: Date,
                public modifiedBy: string,
                public modififedOn: Date,
                public startDate:Date,
                public endDate:Date,
                public desc: string,
                public projectName: string) { 
    }
} 
	


