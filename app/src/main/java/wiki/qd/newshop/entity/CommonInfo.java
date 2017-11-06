package wiki.qd.newshop.entity;

import java.io.Serializable;

/**
 * 服务器获取的公共信息
 * Created by scene on 2017/11/3.
 */

public class CommonInfo implements Serializable {
    /**
     * status : true
     * code : 200
     * data : {"user_agreement":"用户协议","file_domain":"http://119.23.110.78:8087/"}
     */

    private boolean status;
    private int code;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * user_agreement : 用户协议
         * file_domain : http://119.23.110.78:8087/
         */

        private String user_agreement;
        private String file_domain;

        public String getUser_agreement() {
            return user_agreement;
        }

        public void setUser_agreement(String user_agreement) {
            this.user_agreement = user_agreement;
        }

        public String getFile_domain() {
            return file_domain;
        }

        public void setFile_domain(String file_domain) {
            this.file_domain = file_domain;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "user_agreement='" + user_agreement + '\'' +
                    ", file_domain='" + file_domain + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "CommonInfo{" +
                "status=" + status +
                ", code=" + code +
                ", data=" + data.toString() +
                '}';
    }
}
