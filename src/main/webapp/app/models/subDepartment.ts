export class SubDepartment {
    constructor(public subDeptId: number,
        public departmentId: number,
        public activeFlag: boolean,
        public createdBy: string,
        public createdOn: Date,
        public modifiedBy: string,
        public modififedOn: Date,
        public subDeptName: string,
        public subDeptDesc: string,
        public subDeptHead: string,
        public deptName: string) {
    }
}