package com.winter.springbootmybatisdemo.dto;

import java.io.Serializable;
import java.util.List;

public class BootstrapTableResDTO<T> implements Serializable {

    /**
     * 分页总条数
     */
    private Long total;
    /**
     * 数据
     */
    private List<T> rows;

    /**
     * 获取  分页总条数
     *
     * @return 分页总条数
     */
    public Long getTotal() {
        return this.total;
    }

    /**
     * 设置  分页总条数
     *
     * @param total 分页总条数
     */
    public void setTotal(Long total) {
        this.total = total;
    }

    /**
     * 获取  数据
     *
     * @return 数据
     */
    public List<T> getRows() {
        return this.rows;
    }

    /**
     * 设置  数据
     *
     * @param rows 数据
     */
    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
