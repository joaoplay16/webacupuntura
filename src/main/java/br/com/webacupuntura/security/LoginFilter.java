package br.com.webacupuntura.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.webacupuntura.modelo.Usuario;

@WebFilter(urlPatterns={"/pages/*"})
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Usuario usuario = null;

		HttpSession sessao = ((HttpServletRequest) request).getSession(false);

		if (sessao != null) {
			usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		}

		if (usuario == null) {
			String contextPath = ((HttpServletRequest) request).getContextPath();
			
			((HttpServletResponse) response).sendRedirect(contextPath +
					"/login.html");
			System.out.println(contextPath);
		} else {
			chain.doFilter(request, response);
		}

	}

}
