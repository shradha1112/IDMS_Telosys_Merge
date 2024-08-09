package com.cpa.idms.security;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cpa.idms.backend.dao.admin.entities.StaffMember;


public class IDMSUser implements UserDetails,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	StaffMember staffMember=new StaffMember();
	
	String paymentStatus;
	
	Set<GrantedAuthority> authorities=null;

	public void setAuthorities(Set<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public StaffMember getStaffMember() {
		return staffMember;
	}

	public void setStaffMember(StaffMember staffMember) {
		this.staffMember = staffMember;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

        return authorities;
	}

	@Override
	public String getPassword() {
		return staffMember.getLoginKey();
	}

	@Override
	public String getUsername() {
		return staffMember.getLoginId();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String toString() {
		return "CCMUser [staffMember=" + staffMember + ", paymentStatus=" + paymentStatus + ", authorities="
				+ authorities + "]";
	}
}
