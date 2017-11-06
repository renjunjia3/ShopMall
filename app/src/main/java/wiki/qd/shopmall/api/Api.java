package wiki.qd.shopmall.api;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import wiki.qd.shopmall.entity.CommonResultInfo;
import wiki.qd.shopmall.entity.StateResultInfo;
import wiki.qd.shopmall.entity.UserInfo;

/**
 * 接口
 */
public interface Api {
    //公共参数
    @GET("common")
    Observable<CommonResultInfo> getCommonInfo(@QueryMap HashMap<String, String> params);

    //注册获取验证码
    @GET("user/code")
    Observable<StateResultInfo> getRegisterCode(@QueryMap HashMap<String, String> params);

    //手机号注册
    @POST("user/reg")
    Observable<UserInfo> registerByPhone(@QueryMap HashMap<String, String> params);

    //验证验证码
    @GET("user/check_code")
    Observable<StateResultInfo> checkCode(@QueryMap HashMap<String, String> params);

    //手机号登录
    @POST("user/login")
    Observable<UserInfo> loginByPhone(@QueryMap HashMap<String, String> params);


}
