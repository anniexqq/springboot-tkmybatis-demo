package com.winter.springbootmybatisdemo.service;
import com.winter.springbootmybatisdemo.dto.BootstrapTableResDTO;
import com.winter.springbootmybatisdemo.mapper.UserMapper;
import com.winter.springbootmybatisdemo.model.User;

public interface UserService extends BaseService<User,Integer,UserMapper> {
    int addUser(User user) throws Exception;

    public BootstrapTableResDTO<User> findAllUser(int pageNum, int pageSize);

}
