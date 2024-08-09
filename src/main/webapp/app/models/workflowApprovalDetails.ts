export class DocumentApprovalDetails {
    constructor(
        public approvalId : number,
        public workFlowId : number,
        public staffId: number,
        public docName: string,
        public url: string,
        public documentStatus : string,
        public comments : string,
        public activeFlag : Boolean,
        public createdBy : string,
        public createdOn: Date,
        public modifiedBy : string,
        public modififedOn: Date
    ){}
}