package wiki.qd.newshop.db.dbutil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.greenrobot.greendao.database.Database;

import wiki.qd.newshop.db.DaoMaster;
import wiki.qd.newshop.db.UserInfoDao;

public class MySqlLiteOpenHelper extends DaoMaster.OpenHelper {

    public MySqlLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        Log.i("lxq", "oldVersion:" + oldVersion + ",newVersion" + newVersion);
        MigrationHelper.getInstance().migrate(db, UserInfoDao.class);
    }

}  