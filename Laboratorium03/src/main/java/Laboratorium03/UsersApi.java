package Laboratorium03;

import java.util.ArrayList;

public class UsersApi {
    private int  pageNumber;
    private int pagesCount;
    private int pageSize;
    private int totalCount;
    private ArrayList<UserEntityDTO> users;

    public UsersApi(int pageNumber, int pagesCount, int pageSize, int totalCount, ArrayList<UserEntityDTO> users) {
        this.pageNumber = pageNumber;
        this.pagesCount = pagesCount;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.users = users;
    }
    public void setUsers(ArrayList<UserEntityDTO> users) {this.users = users; }

    public ArrayList<UserEntityDTO> getUsers() {return users;}

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

}
