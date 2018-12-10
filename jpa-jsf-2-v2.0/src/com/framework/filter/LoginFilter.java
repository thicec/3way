package com.framework.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession sess = ((HttpServletRequest) request).getSession(true);
		// recupera o atributo logado da sessao
		boolean logado = false;
		if(sess.getAttribute("logado") != null) {
			logado = (Boolean) sess.getAttribute("logado");
		}
		// caso a variavel logado seja false saberemos que o usuario nao esta logado
		if(!logado) {
			String contextPath = ((HttpServletRequest) request).getContextPath();
			
		//Redirecionamos o usuario imediatamente para a pagina de login.xhtml
			((HttpServletResponse) response).sendRedirect(contextPath + "/login/login.xhtml");
				
			} else {
				//caso ele esteja logado, apenas deixamos que o fluxo continue
				chain.doFilter(request, response);
			}
		}
	

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
