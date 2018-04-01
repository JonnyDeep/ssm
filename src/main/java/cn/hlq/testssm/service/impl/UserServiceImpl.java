package cn.hlq.testssm.service.impl;

import cn.hlq.testssm.contorller.exception.CustomException;
import cn.hlq.testssm.mapper.UserCustomerMapper;
import cn.hlq.testssm.mapper.UserMapper;
import cn.hlq.testssm.po.User;
import cn.hlq.testssm.po.UserCustomer;
import cn.hlq.testssm.po.UserQueryVo;
import cn.hlq.testssm.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserCustomerMapper userCustomerMapper;

    @Autowired
    private UserMapper userMapper;

    public List<UserCustomer> findUserList(UserQueryVo userQueryVo) throws Exception {
        return userCustomerMapper.findUserList(userQueryVo);
    }

    public UserCustomer findUserById(Integer id) throws Exception {
        User user = userMapper.selectByPrimaryKey(id);
        //中间对商品信息进行业务处理
        //....
        //返回UserCustomer
        if(user==null)
        {
            throw new CustomException("人员为空");
        }
        UserCustomer userCustomer = new UserCustomer();
        BeanUtils.copyProperties(user,userCustomer);
        return userCustomer;
    }

    public void updateUser(Integer id, UserCustomer userCustomer) throws Exception {
        //添加业务校验，通常在service接口对关键参数进行校验
        //校验id是否为空，如果为空抛出异常

        //更新商品信息
        userCustomer.setIduser(id);
        userMapper.updateByPrimaryKeyWithBLOBs(userCustomer);
    }
}
