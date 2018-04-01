package cn.hlq.testssm.contorller;

import cn.hlq.testssm.po.UserCustomer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestJson {

    @RequestMapping("/requestJson")
    public @ResponseBody UserCustomer requestJson(@RequestBody UserCustomer userCustomer)
    {
        return userCustomer;
    }

    @RequestMapping("/responseJson")
    public @ResponseBody UserCustomer responseJson(UserCustomer userCustomer)
    {
        return userCustomer;
    }
}
