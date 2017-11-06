package wiki.qd.shopmall.db.dbmanager;

import android.util.Log;


import java.util.List;

import wiki.qd.shopmall.db.DaoSession;
import wiki.qd.shopmall.db.dbutil.DaoManager;
import wiki.qd.shopmall.db.dbutil.IDao;
import wiki.qd.shopmall.entity.CommonInfo;

/**
 * 基础信息
 * Created by scene on 2017/11/6.
 */

public class CommonInfoDaoManager implements IDao<CommonInfo> {
    private DaoSession mDaoSession = DaoManager.getInstance().getDaoSession();

    @Override
    public boolean insert(CommonInfo info) {
        try {
            return mDaoSession.getCommonInfoDao().insertOrReplace(info) > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(CommonInfo info) {
        try {
            mDaoSession.getCommonInfoDao()
                    .delete(info);
        } catch (Exception e) {
            Log.e("lxq", "删除失败");
            return false;
        }
        return true;
    }

    @Override
    public boolean update(CommonInfo info) {
        try {
            mDaoSession.getCommonInfoDao()
                    .update(info);
        } catch (Exception e) {
            Log.e("lxq", "更新失败");
            return false;
        }
        return true;
    }

    @Override
    public List<CommonInfo> queryAll() {
        return mDaoSession.getCommonInfoDao()
                .loadAll();
    }

    @Override
    public CommonInfo queryById(long id) {
        return mDaoSession.getCommonInfoDao()
                .loadByRowId(id);
    }

    @Override
    public List<CommonInfo> queryByObj(String where, String... params) {
        return null;
    }

}
