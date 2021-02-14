package com.lsl.page;

public class Page {

    private int currentPage = 0;
    private int start = 0;
    private int  count = 5;
    private int last = 0;

    public Page() {
    }

    public int caculateTotalPage(int total){
        if(total%count == 0)
            return total / count;
        else
            return total / count + 1;
    }

    public void caculateLast(int total){
        //假设总数是50，是能够被5整除的，那么最后一页start就是45
        if(total % count == 0)
            last = total - count;
        //假设总数是51，不能够被5整除的，那么最后一页的start就是50
        else
            last = total - total % count;
    }

    public int getCurrentPage() {
        return (int)start / count + 1;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }
}
