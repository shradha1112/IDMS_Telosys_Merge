package com.cpa.idms.backend.dao.admin.constants;

public class ProjectConstants {

	public static final String SELECT_BASE = "SELECT * FROM project p";
	public static final String BY_ACTIVE_FLAG = "p.active_flag = 'Y'";	
	
	public static final String FIND_ALL_PROJECTS = SELECT_BASE+ " WHERE " +BY_ACTIVE_FLAG;
	public static final String FIND_ALL_PROJECTS_BY_DEPTID =SELECT_BASE+ " WHERE " +BY_ACTIVE_FLAG+" AND "+"p.dept_id= :deptId";

	
}
