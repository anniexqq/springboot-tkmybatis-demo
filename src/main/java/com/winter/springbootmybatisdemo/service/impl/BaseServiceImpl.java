package com.winter.springbootmybatisdemo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.winter.springbootmybatisdemo.service.BaseService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public abstract class BaseServiceImpl<E, K, M extends Mapper<E>> implements BaseService<E, K, M> {

    @Autowired
    protected M mapper;

    public M getMapper() {
        return this.mapper;
    }

    public void setMapper(M mapper) {
        this.mapper = mapper;
    }

    /**
     * 增加一条记录
     *
     * @param entity 实体类
     * @return 成功条数
     */
    @Override
    public int add(E entity) {
        return mapper.insertSelective(entity);
    }

    /**
     * 根据主键删除一条记录
     *
     * @param key 主键
     * @return 成功条数
     */
    @Override
    public int deleteByPrimaryKey(K key) {
        return mapper.deleteByPrimaryKey(key);
    }

    /**
     * 根据实体属性作为条件进行删除，查询条件使用等号
     *
     * @param entity 实体类
     * @return 成功条数
     */
    @Override
    public int delete(E entity) {
        return mapper.delete(entity);
    }

    /**
     * 根据主键更新属性不为null的值
     *
     * @param entity 实体类
     * @return 成功条数
     */
    @Override
    public int updateByPrimaryKeySelective(E entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     *
     * @param entity 实体类
     * @return 查询结果列表
     */
    @Override
    public List<E> select(E entity) {
        return mapper.select(entity);
    }

    /**
     * 查询全部结果，select(null)方法能达到同样的效果
     *
     * @return 查询结果列表
     */
    @Override
    public List<E> selectAll() {
        return mapper.selectAll();
    }

    /**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     *
     * @param entity 实体类
     * @return 实体类
     */
    @Override
    public E selectOne(E entity) {
        return mapper.selectOne(entity);
    }

    /**
     * 根据实体中的属性查询总数，查询条件使用等号
     *
     * @param entity 实体类
     * @return 总数
     */
    @Override
    public int selectCount(E entity) {
        return mapper.selectCount(entity);
    }

    /**
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     *
     * @param key 主键
     * @return 实体类
     */
    @Override
    public E selectByPrimaryKey(K key) {
        return mapper.selectByPrimaryKey(key);
    }

    /**
     * 根据Example条件进行查询
     *
     * @param example
     * @return
     */
    @Override
    public List<E> selectByExample(Object example) {
        return mapper.selectByExample(example);
    }

    /**
     * 根据Example条件进行查询总数
     *
     * @param example
     * @return
     */
    @Override
    public int selectCountByExample(Object example) {
        return mapper.selectCountByExample(example);
    }

    /**
     * 根据Example条件删除数据
     *
     * @param example
     * @return
     */
    @Override
    public int deleteByExample(Object example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public List<E> selectByRowBounds(E entity, RowBounds rowBounds) {
        return mapper.selectByRowBounds(entity, rowBounds);
    }

    /**
     * 根据实体中的属性值进行查询分页数据
     *
     * @param entity
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<E> selectPage(E entity, Integer pageNum, Integer pageSize) {
        if (pageNum == null || pageNum < 0) {
            pageNum = 1;
        }

        if (pageSize == null || pageSize < 0) {
            pageSize = 10;
        }

        PageHelper.startPage(pageNum, pageSize);
        List<E> select = mapper.select(entity);
        return new PageInfo<>(select);
    }




    /**
     * 根据Example的属性值进行查询分页数据
     *
     * @param example
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<E> selectPageByExample(Object example, int pageNum, int pageSize) {
        if (pageNum < 0) pageNum = 1;
        if (pageSize < 0) pageSize = 10;
        PageHelper.startPage(pageNum, pageSize);
        List<E> select = mapper.selectByExample(example);
        return new PageInfo<>(select);
    }
}
