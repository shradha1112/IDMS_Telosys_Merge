export class DocumentCategory {
    constructor(public categoryId: number,
                public deptId: number, 
                public categoryName: string,
                public categoryDesc: string,
                public visibility: string,
                public activeFlag: boolean, 
                public createdBy: string,
                public createdOn: Date,
                public modifiedBy: string,
                public modififedOn: Date
                ) { 
    }
} 

	


