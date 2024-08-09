package com.cpa.idms.backend.dao.admin.constants;

public class StaffMemberConstants {

	public static final String FIND_ALL_STAFF_MEMBERS = "SELECT * FROM staff WHERE active_flag ='Y' and designation != 'Admin'";
	
	 public static final String SELECT_BASE = "SELECT * FROM staff s WHERE s.active_flag = 'Y'";
	 public static final String SELECT_STUD__BASE = "SELECT * FROM staff s WHERE ";
	 public static final String SELECT_ADMIN__BASE = "SELECT * FROM staff_role s WHERE s.authority = 'ROLE_ADMIN' AND  s.active_flag = 'Y' Limit 1";

	 public static final String STAFF_ID_COND = "s.staff_id = :staffId";
	 public static final String ORDER_BY_CLAUSE = " ORDER BY s.staff_id ASC";
	 public static final String FIND_STAFF_BY_LOGIN_ID = SELECT_BASE + " AND UPPER(s.login_id) = UPPER(:loginId)" + ORDER_BY_CLAUSE;
	 public static final String FIND_STAFF_BY_EMAIL_ID = SELECT_BASE + " AND s.email = :email " + ORDER_BY_CLAUSE;
	 public static final String FIND_ORG_BY_ID = SELECT_BASE + " AND " + STAFF_ID_COND + ORDER_BY_CLAUSE;
	 public static final String FIND_ORG_BY_STUD_ID = SELECT_STUD__BASE + STAFF_ID_COND + ORDER_BY_CLAUSE;
	 public static final String FIND_ALL_PRIMARY_PROVIDER = SELECT_BASE + " AND s.designation = 'MD'";
	


}


