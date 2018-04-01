package cn.hlq.testssm.contorller;


import cn.hlq.testssm.contorller.validate.ValiGroup1;
import cn.hlq.testssm.po.UserCustomer;
import cn.hlq.testssm.po.UserQueryVo;
import cn.hlq.testssm.service.UserService;
import com.alibaba.fastjson.JSON;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import sun.swing.SwingUtilities2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Controller
//为了对url进行分类管理，可以在这里定义根路径，最终访问url是根路径+子路径
//用户查询/items/queryUser
//窄化请求映射
@RequestMapping("/items")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/queryUser")
    public ModelAndView queryUser(HttpServletRequest request, UserQueryVo userQueryVo, HttpSession httpSession) throws Exception
    {
        List<UserCustomer> userList;
        if(userQueryVo.getUserCustomer()==null) {
            userList = userService.findUserList(null);
        }else {
            userList = userService.findUserList(userQueryVo);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("items/userList");
        return modelAndView;
    }

    @RequestMapping("/editqueryUser")
    public ModelAndView editqueryUser(HttpServletRequest request, UserQueryVo userQueryVo) throws Exception
    {
        List<UserCustomer> userList;
//        if(userQueryVo.getUserCustomer()==null) {
//            userList = userService.findUserList(null);
//        }else {
            userList = userService.findUserList(userQueryVo);
//        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("items/editUserBatch");
        return modelAndView;
    }

//方法一
//    @RequestMapping("/editUser")
    //限制http请求方法
//    @RequestMapping(value = "/editUser",method = {RequestMethod.POST,RequestMethod.GET})
//    public ModelAndView editUser() throws Exception
//    {
//        UserCustomer userCustomer = userService.findUserById(1);
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("userCustomer",userCustomer);
//        modelAndView.setViewName("items/editUser");
//        return modelAndView;
//    }
//
//    @RequestMapping("/submitUser")
//    public ModelAndView submitUser() throws Exception
//    {
//        UserCustomer userCustomer = userService.findUserById(1);
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("userCustomer",userCustomer);
//        modelAndView.setViewName("items/success");
//        return modelAndView;
//    }

    //方法二
    //返回逻辑视图名
    @RequestMapping(value = "/editUser",method = {RequestMethod.POST,RequestMethod.GET})
    public String editUser(Model model,  @RequestParam(value = "id",required = true,defaultValue = "1" ) Integer iduser) throws Exception
    {
        UserCustomer userCustomer = userService.findUserById(iduser);

//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("userCustomer",userCustomer);
//        modelAndView.setViewName("items/editUser");
        model.addAttribute("userCustomer",userCustomer);
        return "items/editUser";
    }

    @RequestMapping(value = "/submitUser")
    public String submitUser(HttpServletRequest request,
                             Model model,
                             int id,
                             @ModelAttribute("userCustomer") @Validated(value = {ValiGroup1.class}) UserCustomer userCustomer, BindingResult bindingResult,
                             MultipartFile user_pic) throws Exception
    {
        if(bindingResult.hasErrors())
        {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError oe:allErrors
                 ) {
//                System.out.println(new String(oe.getDefaultMessage().getBytes("iso8859-1"),"utf8"));
                System.out.println(oe.getDefaultMessage());

             }
             model.addAttribute("allErrors",allErrors);
            return "items/editUser";
        }
        String originFileName = user_pic.getOriginalFilename();
        if (user_pic!=null&&originFileName!=null && originFileName.length()>0)
        {

            String pic_path="D:\\yxdown\\";


            String newFIleName = UUID.randomUUID() + originFileName.substring(originFileName.lastIndexOf("."));


            File newFile = new File(pic_path+newFIleName);
            user_pic.transferTo(newFile);
            userCustomer.setUserpic(newFIleName);
        }

        //重定向
//       return "redirect:queryUser.action";
        userService.updateUser(id,userCustomer);
        //转发
        return "forward:queryUser.action";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(Integer[] user_id) throws Exception
    {
        for (int i: user_id
             ) {
            System.out.println(i);
        }

        return "items/success";
    }

    @RequestMapping("/editUserBatch")
    public String editUserBatch(UserQueryVo userQueryVo) throws  Exception
    {
        for (UserCustomer user: userQueryVo.getUserCustomerList()
             ) {
            System.out.println(JSON.toJSON(user));
        }
        return "items/success";
    }

//    RESTful风格，url模板访问
    @RequestMapping("/queryUeser/{id}")
    public @ResponseBody UserCustomer queryUserRest(@PathVariable("id") Integer userid) throws Exception
    {
        UserCustomer userCustomer = userService.findUserById(userid);
        return userCustomer;
    }
}
