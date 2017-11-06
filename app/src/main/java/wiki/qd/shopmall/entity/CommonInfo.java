package wiki.qd.shopmall.entity;

import org.greenrobot.greendao.annotation.Entity;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by scene on 2017/11/6.
 */
@Entity
public class CommonInfo implements Serializable{
    /**
     * user_agreement : 用户协议
     * file_domain : http://119.23.110.78:8087/
     */

    private String user_agreement;
    private String file_domain;

    @Generated(hash = 1071398927)
    public CommonInfo(String user_agreement, String file_domain) {
        this.user_agreement = user_agreement;
        this.file_domain = file_domain;
    }

    @Generated(hash = 1783487382)
    public CommonInfo() {
    }

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
