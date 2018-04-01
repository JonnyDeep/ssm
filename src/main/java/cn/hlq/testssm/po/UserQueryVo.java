package cn.hlq.testssm.po;


import java.util.List;

/**
 *
 * 包装对象
 */
public class UserQueryVo {
    private User user;
    private UserCustomer userCustomer;
    private List<UserCustomer> userCustomerList;

    public List<UserCustomer> getUserCustomerList() {
        return userCustomerList;
    }

    public void setUserCustomerList(List<UserCustomer> userCustomerList) {
        this.userCustomerList = userCustomerList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserCustomer getUserCustomer() {
        return userCustomer;
    }

    public void setUserCustomer(UserCustomer userCustomer) {
        this.userCustomer = userCustomer;
    }
}
