package com.cpa.idms.service.admin;

import javax.servlet.http.HttpServletRequest;

import com.cpa.idms.backend.dao.admin.entities.StaffMember;
import com.cpa.idms.service.admin.dto.StaffMemberDTO;

/**
 * Implementation for the EHR Base Service
 * 
 * EHR Base Service holds all the interfaces
 * that are reused across the EHR application 
 *  
 * @author CPA Development Team
 * @version 1.0.0
 */
public interface IDMSBaseService {

	public StaffMember currentUser();
	public String getRandomPassword();
	public boolean getResetPasswordMailSender(StaffMember staff,HttpServletRequest request);
	public boolean getPasswordMailSender(StaffMemberDTO staff,HttpServletRequest request);
	public boolean getStudentPwsMailSender(StaffMemberDTO staff,HttpServletRequest request);
	public boolean getUsernameMailSender(StaffMemberDTO staff,HttpServletRequest request);
	public boolean getAdminEmailSender(StaffMemberDTO staff, HttpServletRequest request);
	
	public boolean getSubscriptionActivationMailSender(StaffMember staff,HttpServletRequest request);
	public boolean getAdminSubscriptionMailSender(StaffMember staff,HttpServletRequest request);
}
