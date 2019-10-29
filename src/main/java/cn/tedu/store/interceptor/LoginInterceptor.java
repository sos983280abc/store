package cn.tedu.store.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
/**
 * 登入拦截器
 * @author soft01
 *
 */
public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		if(session.getAttribute("uid") == null) {
			response.sendRedirect("/web/login.html");
			return false;
		}
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	
}
