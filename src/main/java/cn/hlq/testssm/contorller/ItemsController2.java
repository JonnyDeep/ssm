package cn.hlq.testssm.contorller;

import cn.hlq.testssm.po.Items;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ItemsController2 {

    @RequestMapping("/queryItems3")
    public ModelAndView queryItems3() throws Exception{
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
