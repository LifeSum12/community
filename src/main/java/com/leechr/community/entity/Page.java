package com.leechr.community.entity;

import lombok.Data;

@Data
public class Page {
    private int current = 1;
    private int limit = 10;
    //数据总条数
    private int rows;
    //每个按钮的访问路径
    private String path;

    /**
     * 当前页起始行
     *
     * @return
     */
    public int getOffset() {
        return (current - 1) * limit;
    }

    /**
     * 返回页码数
     *
     * @return
     */
    public int getTotal() {
        if (rows % limit == 0) {
            return rows / limit;
        } else {
            return rows / limit + 1;
        }
    }

    /**
     * 左边界页码
     * @return
     */
    public int getFrom() {
        int from = current - 2;
        return from < 1 ? 1 : from;
    }

    /**
     * 右边界页码
     * @return
     */
    public int getTo() {
        int to = current + 2;
        int total = getTotal();
        return to > total ? total : to;
    }
}
