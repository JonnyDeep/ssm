package cn.hlq.testssm.contorller;

import cn.hlq.testssm.po.Items;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ItemsController1 implements HttpRequestHandler {
    public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
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

       httpServletRequest.setAttribute("itemsList",itemsList);
       httpServletRequest.setAttribute("name","hellospringmvc");

       /*
       该种方法貌似视图前缀失效
        */
       httpServletRequest.getRequestDispatcher("/WEB-INF/jsp/items/itemList.jsp").forward(httpServletRequest,httpServletResponse);
    }
}
