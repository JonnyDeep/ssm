package cn.hlq.testssm.service;

import cn.hlq.testssm.po.UserCustomer;
import cn.hlq.testssm.po.UserQueryVo;

import java.util.List;

public interface UserService {
    public List<UserCustomer> findUserList(UserQueryVo userQueryVo) throws Exception;

    public UserCustomer findUserById(Integer id) throws Exception;

    public void updateUser(Integer id,UserCustomer userCustomer) throws Exception;
}
