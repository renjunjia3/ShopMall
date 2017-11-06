package wiki.qd.newshop.db.dbutil;

import android.content.Context;

import org.greenrobot.greendao.database.Database;

import wiki.qd.newshop.db.DaoMaster;
import wiki.qd.newshop.db.DaoSession;

public class DaoManager {
    private static String DB_NAME = "ShopMall.db";
    private static DaoManager mDaoManager;
    private static MySqlLiteOpenHelper mySqlLiteOpenHelper;
    private static DaoSession mDaoSession;
    private static Database mDatabase;

    private DaoManager() {
    }

    public static DaoManager getInstance() {
        if (mDaoManager == null) {
            synchronized (DaoManager.class) {
                if (mDaoManager == null) {
                    mDaoManager = new DaoManager();
                }
            }
        }
        return mDaoManager;
    }

    public static void init(Context context) {
        mySqlLiteOpenHelper = new MySqlLiteOpenHelper(context, DB_NAME, null);
        mDatabase = mySqlLiteOpenHelper.getWritableDb();
        mDaoSession = new DaoMaster(mDatabase).newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public void clear() {
        if (mDaoSession != null) {
            mDaoSession.clear();
            mDaoSession = null;
        }
    }

    public void close() {
        clear();
        if (mySqlLiteOpenHelper != null) {
            mySqlLiteOpenHelper.close();
            mySqlLiteOpenHelper = null;
        }
    }
}