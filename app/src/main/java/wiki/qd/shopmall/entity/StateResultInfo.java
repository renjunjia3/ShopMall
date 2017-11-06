package wiki.qd.shopmall.entity;

import java.io.Serializable;

/**
 * 只返回状态信息
 * Created by scene on 2017/11/6.
 */
public class StateResultInfo implements Serializable {

    /**
     * status : true
     * code : 200
     */

    private boolean status;
    private int code;

    public StateResultInfo(boolean status, int code) {
        this.status = status;
        this.code = code;
    }

    public StateResultInfo() {
    }

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

    public boolean getStatus() {
        return this.status;
    }
}
