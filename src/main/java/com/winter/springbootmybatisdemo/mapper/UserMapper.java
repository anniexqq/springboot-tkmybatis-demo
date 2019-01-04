package com.winter.springbootmybatisdemo.mapper;

import com.winter.springbootmybatisdemo.model.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User>{
    List<User> selectAllUser();
}