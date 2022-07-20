package com.mhjg.yose.security.jwt;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.mhjg.yose.security.service.SecurityUserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenProvider {
	
	private Key secretKey;
	
	@Autowired
	private SecurityUserService securityUserService;
	
	@PostConstruct
	public void initialize(@Value("${jwt.secret}") String secretKey) {
		// 시크릿 키를 Base64로 인코딩한다.
		// String secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
		byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        this.secretKey = Keys.hmacShaKeyFor(keyBytes);
	}
	
	// 토큰을 생성한다.
	public String generateToken(Authentication authentication) {
		return Jwts.builder()
				.setIssuedAt(new Date())
				.setExpiration(null)
				.signWith(SignatureAlgorithm.HS256, secretKey)
				.compact();
	}
	
	// 토큰으로 인증 정보를 조회환다.
	public Authentication getAuthentication(String token) {
		UserDetails userDetails = securityUserService.loadUserByUsername(getUsername(token));
		return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
	}
	
	// 토큰에서 사용자 정보를 가져온다.
	public String getUsername(String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
	}

	// Request의 Header에서 토큰 값을 가져온다.
	public String resolveToken(HttpServletRequest request) {
		return request.getHeader(HttpHeaders.AUTHORIZATION);
	}
	
	public boolean validateToken(String token) {
		
		return false;
	}
}
