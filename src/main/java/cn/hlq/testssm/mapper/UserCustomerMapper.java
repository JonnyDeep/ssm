package cn.hlq.testssm.mapper;

import cn.hlq.testssm.po.UserCustomer;
import cn.hlq.testssm.po.UserQueryVo;

import java.util.List;

public interface UserCustomerMapper {
    public List<UserCustomer> findUserList(UserQueryVo userQueryVo) throws Exception;
}
