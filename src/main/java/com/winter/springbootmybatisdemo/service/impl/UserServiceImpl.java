package com.winter.springbootmybatisdemo.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.winter.springbootmybatisdemo.dto.BootstrapTableResDTO;
import com.winter.springbootmybatisdemo.mapper.UserMapper;
import com.winter.springbootmybatisdemo.model.User;
import com.winter.springbootmybatisdemo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "userService")
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User,Integer,UserMapper> implements UserService {

    @Override
    public int addUser(User user) throws Exception{
        user.setSalt("1234");
        return mapper.insertSelective(user);
    }

    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
    @Override
    public BootstrapTableResDTO<User> findAllUser(int pageNum, int pageSize) {
        System.out.println("------进入findAllUser()------查询数据库");
        //将参数传给这个方法就可以实现物理分页了，非常简单
        PageHelper.startPage(pageNum, pageSize);
        List<User> userDTOS = mapper.selectAllUser();
        PageInfo<User> page = new PageInfo<>(userDTOS);
        BootstrapTableResDTO<User> resDTO = new BootstrapTableResDTO<>();
        resDTO.setTotal(page.getTotal());
        resDTO.setRows(userDTOS);
        return resDTO;
    }

}