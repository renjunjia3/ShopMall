package wiki.qd.newshop;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.vise.utils.view.DialogUtil;
import com.vise.xsnow.permission.OnPermissionCallback;
import com.vise.xsnow.permission.PermissionManager;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkReadExternalPermission();
        } else {
            toMainActivity();
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
                toMainActivity();
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


    @Override
    public void onBackPressed() {
    }
}
