package br.com.adrianomenezes.generalback.security.jwt;

import java.io.IOException;

import br.com.adrianomenezes.generalback.exceptions.TokenError;
import com.auth0.jwt.exceptions.TokenExpiredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class JwtTokenFilter extends GenericFilterBean {
	
	@Autowired
	private JwtTokenProvider tokenProvider;

		
	public JwtTokenFilter(JwtTokenProvider tokenProvider) {
		this.tokenProvider = tokenProvider;
	}


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException, TokenExpiredException
				{
//		try {
			String token = tokenProvider.resolveToken((HttpServletRequest) request);
			if (token != null && tokenProvider.validateToken(token)) {
				Authentication auth = tokenProvider.getAuthentication(token);
				if (auth != null) {
					SecurityContextHolder.getContext().setAuthentication(auth);
				}
			}
			chain.doFilter(request, response);
//		} catch (ServletException e) {
//			throw new TokenError(e);
//		} catch (IOException e) {
//			throw new TokenError(e);
//		} catch (Exception e) {
//			throw new TokenError(e);
//		}
		
		
	}

}
