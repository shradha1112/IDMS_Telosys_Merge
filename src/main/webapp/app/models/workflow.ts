export class Workflow {
    constructor(
        public projectId : string,
        public workflowId :number,
        public deptId: string,
        public categoryId:string,
        public approverId:string,
        public docName: string,
	    public  url: string,
        public remarks:string,
        public activeFlag : Boolean,
        public createdBy : string,
        public createdOn: Date,
        public dueDate: string

    ){}
}


	
	
	
	