package com.Proj.blogApp.payloads;

import com.Proj.blogApp.entities.Post;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class PostResponse {

    private List<PostDto> content;
    private int pageNumber;
    private int pageSize;
    private int totalElemnt;
    private int totalpages;
    private boolean lastpage;

    public List<PostDto> getContent() {
        return content;
    }

    public void setContent(List<PostDto> content) {
        this.content = content;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalElemnt() {
        return totalElemnt;
    }

    public void setTotalElemnt(int totalElemnt) {
        this.totalElemnt = totalElemnt;
    }

    public int getTotalpages() {
        return totalpages;
    }

    public void setTotalpages(int totalpages) {
        this.totalpages = totalpages;
    }

    public boolean isLastpage() {
        return lastpage;
    }

    public void setLastpage(boolean lastpage) {
        this.lastpage = lastpage;
    }

    public PostResponse(List<PostDto> content, int pageNumber, int pageSize, int totalElemnt, int totalpages, boolean lastpage) {
        this.content = content;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalElemnt = totalElemnt;
        this.totalpages = totalpages;
        this.lastpage = lastpage;
    }

    public PostResponse() {
    }
}
