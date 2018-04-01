package cn.hlq.testssm.mapper;

import cn.hlq.testssm.po.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer iduser);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer iduser);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKeyWithBLOBs(User record);

    int updateByPrimaryKey(User record);
}