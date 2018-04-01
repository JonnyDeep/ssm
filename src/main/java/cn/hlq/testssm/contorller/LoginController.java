package cn.hlq.testssm.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {
    @RequestMapping(value = "/login")
    public String login(HttpSession session,String username,String passwd) throws  Exception{
//        调用service进行身份验证
//           ...
        System.out.println("登入");
        session.setAttribute("username",username);
        return "forward:/items/queryUser.action";
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) throws Exception{
        //清楚session
        session.invalidate();
        return "redirect:/items/queryUser.action";
    }

}
