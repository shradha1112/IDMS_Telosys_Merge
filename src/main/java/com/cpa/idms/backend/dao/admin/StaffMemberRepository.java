package com.cpa.idms.backend.dao.admin;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cpa.idms.backend.dao.admin.constants.DepartmentConstants;
import com.cpa.idms.backend.dao.admin.constants.DocumentCategoryConstants;
import com.cpa.idms.backend.dao.admin.constants.StaffMemberConstants;
import com.cpa.idms.backend.dao.admin.entities.Department;
import com.cpa.idms.backend.dao.admin.entities.DocumentCategory;
import com.cpa.idms.backend.dao.admin.entities.StaffMember;


@Repository
@Transactional
public interface StaffMemberRepository extends JpaRepository<StaffMember,Long> {
	
	@Query(value = StaffMemberConstants.FIND_ALL_STAFF_MEMBERS, nativeQuery = true)
	List <StaffMember> findAllStaffMembers();
	
	@Query(value = StaffMemberConstants.FIND_STAFF_BY_LOGIN_ID, nativeQuery = true)
	Optional<StaffMember> findByLoginId(@Param("loginId")String loginId);
	
	@Query(value = StaffMemberConstants.FIND_STAFF_BY_LOGIN_ID, nativeQuery = true)
	StaffMember getByLoginId(@Param("loginId")String loginId);
	
	@Query(value = StaffMemberConstants.SELECT_ADMIN__BASE, nativeQuery = true)
	Optional<StaffMember> findAdmin();
	
	@Query(value = StaffMemberConstants.FIND_STAFF_BY_EMAIL_ID, nativeQuery = true)
	StaffMember findByEmail(@Param("email")String email);

	@Query(value = StaffMemberConstants.SELECT_BASE, nativeQuery = true)
	List <StaffMember> findAllActiveStaffMembers();

	@Query(value = StaffMemberConstants.FIND_ORG_BY_ID, nativeQuery = true)
	StaffMember findActiveOneByStaffMemberId(@Param("staffId") Long id);
	
	@Query(value = StaffMemberConstants.FIND_ORG_BY_STUD_ID, nativeQuery = true)
	StaffMember findActiveOneByStudMemberId(@Param("staffId") Long id);
	
	@Query(value = StaffMemberConstants.FIND_ALL_PRIMARY_PROVIDER, nativeQuery = true)
	List<StaffMember> findAllPrimaryProvider();

	
}
