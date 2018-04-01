import cn.hlq.testssm.po.UserCustomer;
import cn.hlq.testssm.service.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-mybatis.xml","classpath*:spring-service.xml"})
public class test {
    private static Logger logger = Logger.getLogger(test.class);

    @Autowired
    private UserService userService;
    @Test
    public void test1()
    {
        try {
            List<UserCustomer> userList = userService.findUserList(null);
            for (UserCustomer uc: userList
                 ) {
                logger.info(uc.getName());
            }
        }catch (Exception e){
            logger.info(e.getMessage());
        }
    }

    @Test
    public void test2()
    {
        try {
            UserCustomer userCustomer = userService.findUserById(1);
            logger.info(userCustomer.getIduser()+"\t"+userCustomer.getName());
        }catch (Exception e){
            logger.info(e.getMessage());
        }
    }
}
