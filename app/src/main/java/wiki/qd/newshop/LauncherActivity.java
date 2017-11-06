package wiki.qd.newshop;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.widget.TextView;

import com.vise.log.ViseLog;
import com.vise.utils.view.DialogUtil;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;
import com.vise.xsnow.http.core.ApiTransformer;
import com.vise.xsnow.http.subscriber.ApiCallbackSubscriber;
import com.vise.xsnow.permission.OnPermissionCallback;
import com.vise.xsnow.permission.PermissionManager;

import wiki.qd.newshop.api.Api;
import wiki.qd.newshop.common.ApiConfig;
import wiki.qd.newshop.entity.CommonInfo;
import wiki.qd.newshop.util.SharedPreferencesUtil;

import static wiki.qd.newshop.common.ApiConfig.UUID_KEY;

public class LauncherActivity extends AppCompatActivity {
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        text = findViewById(R.id.text);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkReadExternalPermission();
        } else {
            try {
                ApiConfig.UUID = getUUID();
                ApiConfig.versionCode = LauncherActivity.this.getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
                getCommonInfo();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void checkReadExternalPermission() {
        PermissionManager.instance().with(this).request(new OnPermissionCallback() {
            @Override
            public void onRequestAllow(String permissionName) {
                checkReadPhoneStatePermission();
            }

            @Override
            public void onRequestRefuse(String permissionName) {
                DialogUtil.showTips(LauncherActivity.this, getString(R.string.premission_title)
                        , getString(R.string.premisssion_notice), getString(R.string.confirm), recheckReadExternalPermissionListener);
            }

            @Override
            public void onRequestNoAsk(String permissionName) {
                DialogUtil.showTips(LauncherActivity.this, getString(R.string.premission_title)
                        , getString(R.string.premission_to_setting), getString(R.string.confirm), onDismissListener);
            }
        }, Manifest.permission.READ_EXTERNAL_STORAGE);
    }

    private void checkReadPhoneStatePermission() {
        PermissionManager.instance().with(this).request(new OnPermissionCallback() {
            @Override
            public void onRequestAllow(String permissionName) {
                //toMainActivity();
                try {
                    ApiConfig.UUID = getUUID();
                    ApiConfig.versionCode = LauncherActivity.this.getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
                    getCommonInfo();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onRequestRefuse(String permissionName) {
                DialogUtil.showTips(LauncherActivity.this, getString(R.string.premission_title)
                        , getString(R.string.premisssion_notice), getString(R.string.confirm), recheckReadPhoneStatePermissionListener);
            }

            @Override
            public void onRequestNoAsk(String permissionName) {
                DialogUtil.showTips(LauncherActivity.this, getString(R.string.premission_title)
                        , getString(R.string.premission_to_setting), getString(R.string.confirm), onDismissListener);
            }
        }, Manifest.permission.READ_PHONE_STATE);
    }

    private DialogInterface.OnDismissListener onDismissListener = new DialogInterface.OnDismissListener() {
        @Override
        public void onDismiss(DialogInterface dialogInterface) {
            finish();
        }
    };

    private DialogInterface.OnDismissListener recheckReadExternalPermissionListener = new DialogInterface.OnDismissListener() {
        @Override
        public void onDismiss(DialogInterface dialogInterface) {
            checkReadExternalPermission();
        }
    };

    private DialogInterface.OnDismissListener recheckReadPhoneStatePermissionListener = new DialogInterface.OnDismissListener() {
        @Override
        public void onDismiss(DialogInterface dialogInterface) {
            checkReadPhoneStatePermission();
        }
    };

    private void toMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void getCommonInfo() {
        ViseHttp.RETROFIT().create(Api.class).getCommonInfo(ApiConfig.createParams())
                .compose(ApiTransformer.<CommonInfo>norTransformer())
                .subscribe(new ApiCallbackSubscriber<>(new ACallback<CommonInfo>() {
                    @Override
                    public void onSuccess(CommonInfo data) {
                        ViseLog.e(data.toString());
                        toMainActivity();
                    }

                    @Override
                    public void onFail(int errCode, String errMsg) {

                    }
                }));
    }


    /**
     * 获取UUID
     *
     * @return uuid
     */
    @SuppressLint("MissingPermission")
    private String getUUID() {
        String uuid;
        try {
            TelephonyManager tm = (TelephonyManager) this.getSystemService(TELEPHONY_SERVICE);
            if (tm == null) {
                uuid = SharedPreferencesUtil.getString(this, UUID_KEY, "");
                if (uuid.isEmpty()) {
                    String imei = createRandomUUID();
                    SharedPreferencesUtil.putString(this, UUID_KEY, imei);
                    uuid = imei;
                }
            } else {
                uuid = tm.getDeviceId();
                if (TextUtils.isEmpty(uuid)) {
                    uuid = SharedPreferencesUtil.getString(this, UUID_KEY, "");
                    if (uuid.isEmpty()) {
                        String imei = createRandomUUID();
                        SharedPreferencesUtil.putString(this, UUID_KEY, imei);
                        uuid = imei;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            uuid = SharedPreferencesUtil.getString(this, UUID_KEY, "");
            if (uuid.isEmpty()) {
                String imei = createRandomUUID();
                SharedPreferencesUtil.putString(this, UUID_KEY, imei);
                uuid = imei;
            }
        }
        return uuid;
    }

    private String createRandomUUID() {
        StringBuilder retStr;
        String strTable = "1234567890abcdefghijkmnpqrstuvwxyz";
        int len = strTable.length();
        boolean bDone = true;
        do {
            retStr = new StringBuilder();
            int count = 0;
            for (int i = 0; i < 64; i++) {
                double dblR = Math.random() * len;
                int intR = (int) Math.floor(dblR);
                char c = strTable.charAt(intR);
                if (('0' <= c) && (c <= '9')) {
                    count++;
                }
                retStr.append(strTable.charAt(intR));
            }
            if (count >= 20) {
                bDone = false;
            }
        } while (bDone);

        return retStr.toString();
    }

    @Override
    public void onBackPressed() {
    }
}
