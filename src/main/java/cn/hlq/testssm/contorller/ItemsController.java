package cn.hlq.testssm.contorller;

import cn.hlq.testssm.po.Items;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.mail.FetchProfile;
import java.util.ArrayList;
import java.util.List;

public class ItemsController implements Controller {
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {

        List<Items> itemsList = new ArrayList<Items>();
        Items items1 = new Items();
        items1.setName("Apple");
        items1.setPrice(5000f);
        items1.setDetail("iPhone 8");

        Items items2 = new Items();
        items2.setName("Apple");
        items2.setPrice(12000f);
        items2.setDetail("Mac");
        itemsList.add(items1);
        itemsList.add(items2);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList",itemsList);
        modelAndView.addObject("name","hellospringmvc");
        modelAndView.setViewName("itemList");


        return modelAndView;
    }
}
