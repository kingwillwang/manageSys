package com.hk.entity;

/**
 * @Author: WillWang
 * @Description:
 * @Date: Created in 2018/3/12 16:49
 */
public class PageBean {
    private int page; // 页码
    private int pageSize; // 单页数据量
    private int start;

    public PageBean(int page, int pageSize) {
        super();
        this.page = page;
        this.pageSize = pageSize;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }
}
