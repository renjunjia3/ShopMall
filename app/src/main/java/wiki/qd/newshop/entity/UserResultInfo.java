package wiki.qd.newshop.entity;

import java.io.Serializable;

/**
 * 注册返回的用户信息
 * Created by scene on 2017/11/6.
 */

public class UserResultInfo implements Serializable {

    /**
     * status : true
     * code : 200
     */

    private boolean status;
    private int code;
    private UserInfo data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public UserInfo getData() {
        return data;
    }

    public void setData(UserInfo data) {
        this.data = data;
    }
}