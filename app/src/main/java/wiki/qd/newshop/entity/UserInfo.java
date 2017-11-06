package wiki.qd.newshop.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 用户信息
 * Created by scene on 2017/11/6.
 */
@Entity
public class UserInfo implements Serializable {

    /**
     * user_id : 18
     * access_token : a1ad168b913f335affd4460c3ef488f6
     * refresh_token : abd58c5a37479127f0e14654968b0c37
     * create_time : 1509701079
     * expired_time : 1510997079
     * mobile : 13389628382
     * nickname :
     * level : 1
     * sex : 0
     * payed_times : 0
     * score : 0
     * avatar :
     * money : 0
     */
    @Id
    private int user_id;
    private String access_token;
    private String refresh_token;
    private long create_time;
    private long expired_time;
    private String mobile;
    private String nickname;
    private int level;
    private int sex;
    private int payed_times;
    private int score;
    private String avatar;
    private int money;

    @Generated(hash = 1702434549)
    public UserInfo(int user_id, String access_token, String refresh_token,
            long create_time, long expired_time, String mobile, String nickname,
            int level, int sex, int payed_times, int score, String avatar, int money) {
        this.user_id = user_id;
        this.access_token = access_token;
        this.refresh_token = refresh_token;
        this.create_time = create_time;
        this.expired_time = expired_time;
        this.mobile = mobile;
        this.nickname = nickname;
        this.level = level;
        this.sex = sex;
        this.payed_times = payed_times;
        this.score = score;
        this.avatar = avatar;
        this.money = money;
    }

    @Generated(hash = 1279772520)
    public UserInfo() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }

    public long getExpired_time() {
        return expired_time;
    }

    public void setExpired_time(long expired_time) {
        this.expired_time = expired_time;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getPayed_times() {
        return payed_times;
    }

    public void setPayed_times(int payed_times) {
        this.payed_times = payed_times;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
