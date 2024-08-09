package com.cpa.idms.backend.dao.admin.constants;

public class DepartmentConstants {

	public static final String SELECT_BASE = "SELECT * FROM department d";
	public static final String BY_ACTIVE_FLAG = "d.active_flag = 'Y'";
	
	public static final String FIND_ALL_DEPARTMENTS = SELECT_BASE+" WHERE "+BY_ACTIVE_FLAG;
	public static final String FIND_ALL_DEPARTMENT_BY_ID = SELECT_BASE+" WHERE "+BY_ACTIVE_FLAG+" AND "+"dept_id = :deptId";

	
}
