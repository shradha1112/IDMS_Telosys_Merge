package com.cpa.idms.security;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.cpa.idms.security.IDMSUserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;



@Component
public final class TokenHandler {
	
	private final String secret;
    
	@Autowired
	private final IDMSUserService staffMemberService;
    
    @Autowired
    public TokenHandler(@Value("mySecret") String secret, IDMSUserService staffMemberService) {
        this.secret = secret;
        this.staffMemberService=staffMemberService;
    }    
    
    Optional<UserDetails> parseUserFromToken(String token){
  
    	String login = Jwts.parser()
    				.setSigningKey(secret)
    				.parseClaimsJws(token)
    				.getBody()
    				.getSubject();
    	return Optional.ofNullable(staffMemberService.loadUserByUsername(login));
    	
    }
    
    public String createTokenForUser(UserDetails user) {
    	final ZonedDateTime oneDay = ZonedDateTime.now().plusDays(1);
    	
    	String token= Jwts.builder()
                .setSubject(user.getUsername())
                .claim("Role", user.getAuthorities().toString())
                .signWith(SignatureAlgorithm.HS512, secret)
                .setExpiration(Date.from(oneDay.toInstant()))
                .compact();
    	return token;
    	
    	
    }
  
}
