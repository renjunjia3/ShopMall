package wiki.qd.newshop.api;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import wiki.qd.newshop.entity.CommonInfo;

/**
 * 接口
 */
public interface Api {
    @GET("common")
    Observable<CommonInfo> getCommonInfo(@QueryMap HashMap<String,String> map);
}
