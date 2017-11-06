package wiki.qd.newshop.entity;

import java.io.Serializable;

/**
 * 服务器获取的公共信息
 * Created by scene on 2017/11/3.
 */

public class CommonResultInfo implements Serializable {
    /**
     * status : true
     * code : 200
     * data : {"user_agreement":"用户协议","file_domain":"http://119.23.110.78:8087/"}
     */

    private boolean status;
    private int code;
    private CommonInfo data;

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

    public CommonInfo getData() {
        return data;
    }

    public void setData(CommonInfo data) {
        this.data = data;
    }



    @Override
    public String toString() {
        return "CommonResultInfo{" +
                "status=" + status +
                ", code=" + code +
                ", data=" + data.toString() +
                '}';
    }
}
