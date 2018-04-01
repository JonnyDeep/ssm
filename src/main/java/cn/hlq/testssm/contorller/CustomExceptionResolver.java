package cn.hlq.testssm.contorller;

import cn.hlq.testssm.contorller.exception.CustomException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 * 全局遗传处理器 controller
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        //handler就是处理器适配器要执行的Handler对象
        //解析异常类型
//        如果是系统异常，直接去除异常信息，在错误页面展示
//        如果不是系统异常，构造一个系统异常（信息为“未知错误”）

//        String message=null;
//        if(e instanceof CustomException)
//        {
//            message = ((CustomException)e).getMessage();
//        }else {
//            message="未知错误";
//        }

        CustomException customException=null;

        if(e instanceof CustomException)
        {
            customException = (CustomException)e;
        }else {
            customException=new CustomException("未知错误错误");
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message",customException.getMessage());
        modelAndView.setViewName("error");

        return modelAndView;
    }
}
