package com.cpa.idms.service.admin.impl;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.cpa.idms.backend.dao.admin.StaffMemberRepository;
import com.cpa.idms.backend.dao.admin.entities.Mail;
import com.cpa.idms.backend.dao.admin.entities.StaffMember;
import com.cpa.idms.service.admin.IDMSBaseService;
import com.cpa.idms.service.admin.StaffMemberService;

import com.cpa.idms.backend.dao.admin.entities.Mail;
import com.cpa.idms.backend.dao.admin.entities.StaffMember;
import com.cpa.idms.service.admin.IDMSBaseService;
import com.cpa.idms.service.admin.StaffMemberService;
import com.cpa.idms.service.admin.dto.StaffMemberDTO;

import java.util.Optional;
import java.util.Random;
/**
 * Implementation for the EHR Base Service
 * 
 * EHR Base Service holds all the interfaces
 * that are reused across the EHR application 
 *  
 * @author CPA Development Team
 * @version 1.0.0
 */
@Service
public class IDMSBaseServiceImpl implements IDMSBaseService {


	@Autowired 
	private StaffMemberService staffService;


	@Autowired
	private StaffMemberRepository staffMemberRepo;
	
	
	public StaffMember currentUser() {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		final Optional<StaffMember> currentUser = staffMemberRepo.findByLoginId(authentication.getName());
		return currentUser.orElse(null);
	}
	
	public boolean getPasswordMailSender(StaffMemberDTO staff,HttpServletRequest request) {
		if(staff.getLoginKey() !=null){
			Mail mail = new Mail();
			mail.setFrom("ehrlite@gmail.com");
			mail.setTo(staff.getEmail());
			mail.setSubject("Account Registration Successful");
			Map<String, Object> model = new HashMap<>();
			model.put("pwd", staff.getLoginKey());
			model.put("user", staff);
			String url = request.getScheme() + "://" + request.getServerName() +"/ehr/#/";
//			String url = request.getScheme() + "://" + request.getServerName() +":4300/#/";
			model.put("url", url);
			mail.setModel(model);
			//emailService.sendPasswordEmail(mail);
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public boolean getStudentPwsMailSender(StaffMemberDTO staff, HttpServletRequest request) {
		if(staff.getLoginKey() !=null){
			Mail mail = new Mail();
			mail.setFrom("ehrlite@gmail.com");
			mail.setTo(staff.getEmail());
			mail.setSubject("EHR Account Activated Successfully");
			Map<String, Object> model = new HashMap<>();
			model.put("pwd", staff.getLoginKey());
			model.put("user", staff);
			String url = request.getScheme() + "://" + request.getServerName() +"/ehr/#/";
//			String url = request.getScheme() + "://" + request.getServerName() +":4300/#/";
			model.put("url", url);
			mail.setModel(model);
			//emailService.sendActivationEmail(mail);
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public boolean getUsernameMailSender(StaffMemberDTO staff, HttpServletRequest request) {
		if(staff.getLoginKey() !=null){
			Mail mail = new Mail();
			mail.setFrom("ehrlite@gmail.com");
			mail.setTo(staff.getEmail());
			mail.setSubject("Account Registration Successful");
			Map<String, Object> model = new HashMap<>();
			model.put("UserName", staff.getLoginId());
			model.put("user", staff);
			String url = request.getScheme() + "://" + request.getServerName() +"/ehr/#/";
//			String url = request.getScheme() + "://" + request.getServerName() +":4300/#/";
			model.put("url", url);
			mail.setModel(model);
			//emailService.sendUsernameEmail(mail);
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public boolean getAdminEmailSender(StaffMemberDTO staff, HttpServletRequest request) {
		
		
		if(staff.getLoginKey() !=null){
			Mail mail = new Mail();
			mail.setFrom("ehrlite@gmail.com");
			mail.setTo("k.shivani@cloudpointamerica.com");
			mail.setSubject("Account Pending For Activation");
			Map<String, Object> model = new HashMap<>();
			model.put("UserName", staff.getFirstName() + " "+staff.getLastName());
			model.put("user", staff);
			String url = request.getScheme() + "://" + request.getServerName() +"/ehr/#/";
//			String url = request.getScheme() + "://" + request.getServerName() +":4300/#/";
			model.put("url", url);
			mail.setModel(model);
			//emailService.sendActivationPendingEmail(mail);
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean getResetPasswordMailSender(StaffMember staff,HttpServletRequest request) {
//		StaffMember userName = staffService.findByEmail(staff.getEmail());
//
//		PasswordResetToken token = passwordResetService.createToken(userName);
//		if(token !=null){
//			Mail mail = new Mail();
//			mail.setFrom("ehrlite@gmail.com");
//			mail.setTo(staff.getEmail());
//			mail.setSubject("Password reset request");
//			Map<String, Object> model = new HashMap<>();
//			model.put("token", token);
//			model.put("user", userName);
//			String url = request.getScheme() + "://" + request.getServerName() + "/ehr";
////			String url = request.getScheme() + "://" + request.getServerName() + ":"+"4300";
//			model.put("resetUrl", url + "/#/reset?token=" + token.getToken());
//			mail.setModel(model);
//			System.out.println(mail);
//			emailService.sendEmail(mail);
//			return true;
//		}
		return false;
	}
	
	public String getRandomPassword() {
		   int length = 10; 
		   String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
	       String Small_chars = "abcdefghijklmnopqrstuvwxyz"; 
	       String numbers = "0123456789"; 
	       String symbols = "!@#$%^&*_=+-/.?<>)"; 
	       String values = Capital_chars + Small_chars + numbers + symbols;
	       Random rndm_method = new Random(); 
	       char[] password = new char[length]; 
	       for (int i = 0; i < length; i++) 
	        { 
	    	   password[i] = values.charAt(rndm_method.nextInt(values.length())); 
	        }

	       return password.toString();
	}
	
	@Override
	public boolean getAdminSubscriptionMailSender(StaffMember staff, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean getSubscriptionActivationMailSender(StaffMember staff, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return false;
	}

}
