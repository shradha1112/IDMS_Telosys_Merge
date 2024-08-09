package com.cpa.idms.backend.dao.admin.constants;

public class SubDepartmentConstants {
	
	public static final String SELECT_BASE = "SELECT * FROM sub_department s";
	public static final String BY_ACTIVE_FLAG = "s.active_flag = 'Y'";

	public static final String FIND_ALL_SUB_DEPARTMENTS = SELECT_BASE +" WHERE "+BY_ACTIVE_FLAG;
	public static final String FIND_ALL_SUB_DEPT_BY_DEPTID = SELECT_BASE +" WHERE "+BY_ACTIVE_FLAG+" AND department_id =:deptId";

}
