export class Department {
    constructor(public deptId: number, 
                public deptDesc: string,
                public deptHead: string,
                public deptName: string,
                public activeFlag: boolean, 
                public createdBy: string,
                public createdOn: Date,
                public modifiedBy: string,
                public modififedOn: Date) { 
    }
} 


