package wiki.qd.newshop.db.dbmanager;

import android.util.Log;

import java.util.List;

import wiki.qd.newshop.db.DaoSession;
import wiki.qd.newshop.db.dbutil.DaoManager;
import wiki.qd.newshop.db.dbutil.IDao;
import wiki.qd.newshop.entity.CommonInfo;

/**
 * 基础信息
 * Created by scene on 2017/11/6.
 */

public class CommonInfoDaoManager implements IDao<CommonInfo> {
    private DaoSession mDaoSession = DaoManager.getInstance().getDaoSession();

    @Override
    public boolean insert(CommonInfo info) {
        return mDaoSession.getCommonInfoDao().insertOrReplace(info) > 0;
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
