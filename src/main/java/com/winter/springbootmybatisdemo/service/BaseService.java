package com.winter.springbootmybatisdemo.service;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BaseService<E, K, M extends Mapper<E>> {

    M getMapper();

    void setMapper(M mapper);

    /**
     * 增加一条记录
     *
     * @param entity 实体类
     * @return 成功条数
     */
    int add(E entity);

    /**
     * 根据主键删除一条记录
     *
     * @param key 主键
     * @return 成功条数
     */
    int deleteByPrimaryKey(K key);

    /**
     * 根据实体属性作为条件进行删除，查询条件使用等号
     *
     * @param entity 实体类
     * @return 成功条数
     */
    int delete(E entity);

    /**
     * 根据主键更新属性不为null的值
     *
     * @param entity 实体类
     * @return 成功条数
     */
    int updateByPrimaryKeySelective(E entity);

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     *
     * @param entity 实体类
     * @return 查询结果列表
     */
    List<E> select(E entity);

    /**
     * 查询全部结果，select(null)方法能达到同样的效果
     *
     * @return 查询结果列表
     */
    List<E> selectAll();

    /**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     *
     * @param entity 实体类
     * @return 实体类
     */
    E selectOne(E entity);

    /**
     * 根据实体中的属性查询总数，查询条件使用等号
     *
     * @param entity 实体类
     * @return 总数
     */
    int selectCount(E entity);

    /**
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     *
     * @param key 主键
     * @return 实体类
     */
    E selectByPrimaryKey(K key);

    /**
     * 根据Example条件进行查询
     *
     * @param example
     * @return
     */
    List<E> selectByExample(Object example);

    /**
     * 根据Example条件进行查询总数
     *
     * @param example
     * @return
     */
    int selectCountByExample(Object example);

    /**
     * 根据Example条件删除数据
     *
     * @param example
     * @return
     */
    int deleteByExample(Object example);

    /**
     * 根据实体中的属性值进行查询分页数据
     * @param entity
     * @param rowBounds
     * @return
     */
    List<E> selectByRowBounds(E entity, RowBounds rowBounds);

    /**
     * 根据实体中的属性值进行查询分页数据
     * @param entity
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<E> selectPage(E entity, Integer pageNum, Integer pageSize);

    /**
     * 根据Example的属性值进行查询分页数据
     * @param example
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<E> selectPageByExample(Object example, int pageNum, int pageSize);

}
