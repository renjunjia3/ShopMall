package wiki.qd.shopmall.db.dbutil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.greenrobot.greendao.database.Database;

import wiki.qd.shopmall.db.CommonInfoDao;
import wiki.qd.shopmall.db.DaoMaster;
import wiki.qd.shopmall.db.UserInfoDao;

public class MySqlLiteOpenHelper extends DaoMaster.OpenHelper {

    public MySqlLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        Log.i("lxq", "oldVersion:" + oldVersion + ",newVersion" + newVersion);
        MigrationHelper.getInstance().migrate(db, UserInfoDao.class);
        MigrationHelper.getInstance().migrate(db, CommonInfoDao.class);
    }

}  