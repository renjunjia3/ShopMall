package wiki.qd.shopmall.common;

import java.util.HashMap;

import wiki.qd.shopmall.util.MD5Util;

/**
 * API的配置文件
 * Created by scene on 2017/11/3.
 */

public class ApiConfig {
    public static final String API_PRE = "http://192.168.0.111:8082/";
    public static final String SIGN_KEY = "045448f765b0c0592563123a2652fb63";
    public static final int APP_TYPE = 1;

    public static final String UUID_KEY = "uuid";
    public static String UUID = "";
    public static String CHANNEL_ID = "";
    public static String RESOURCE_ID = "";
    public static int versionCode = 0;

    /**
     * Case By:创建参数基础信息
     * Author: scene on 2017/5/19 13:19
     */
    public static HashMap<String, String> createParams() {
        HashMap<String, String> params = new HashMap<>();
        long timestamp = System.currentTimeMillis();
        params.put("agent_id", CHANNEL_ID);
        params.put("resource_id", RESOURCE_ID);
        params.put("timestamp", timestamp + "");
        params.put("signature", getSign(CHANNEL_ID, timestamp + ""));
        params.put("app_type", "1");
        params.put("uuid", UUID);
        params.put("version", versionCode + "");
        return params;
    }

    /**
     * Case By:获取sign
     * Author: scene on 2017/5/19 13:19
     */
    private static String getSign(String agent_id, String timestamp) {
        return MD5Util.string2Md5(MD5Util.string2Md5(agent_id + APP_TYPE + RESOURCE_ID + timestamp + UUID + versionCode, "UTF-8") + SIGN_KEY, "UTF-8");
    }
}
