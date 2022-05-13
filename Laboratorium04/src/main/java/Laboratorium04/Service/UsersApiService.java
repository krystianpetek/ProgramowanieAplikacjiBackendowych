package Laboratorium04.Service;

import java.util.ArrayList;

public class UsersApiService {
    public int pageNumber;
    public int pagesCount;
    public int pageSize;
    public int totalCount;
    public ArrayList<UserEntityService> users;

    public UsersApiService(int pageNumber, int pagesCount, int pageSize, int totalCount, ArrayList<UserEntityService> users) {
        this.pageNumber = pageNumber;
        this.pagesCount = pagesCount;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.users = users;
    }

    public ArrayList<UserEntityService> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<UserEntityService> users) {
        this.users = users;
    }

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
