package cn.hlq.testssm.contorller.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    /**
     *进入Handler方法之前被调用
     * 一般用于身份认证、身份授权
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String url = httpServletRequest.getRequestURI();
        if(url.indexOf("user/login")>=0)
        {
            return true;
        }

        HttpSession session = httpServletRequest.getSession();
        String username = (String) session.getAttribute("username");

        if(username != null)
        {
            return true;
        }

        httpServletRequest.getRequestDispatcher("/WEB-INF/jsp/items/login.jsp").forward(httpServletRequest, httpServletResponse);

        return false;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("loginInterceptor...postHandler");
    }

    /**
     * 统一异常处理，日志等
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("loginInterceptor...afterCompletion");
    }
}
