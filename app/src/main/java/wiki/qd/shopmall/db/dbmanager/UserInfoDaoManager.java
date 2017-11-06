package wiki.qd.shopmall.db.dbmanager;

import android.util.Log;

import java.util.List;

import wiki.qd.shopmall.db.DaoSession;
import wiki.qd.shopmall.db.UserInfoDao;
import wiki.qd.shopmall.db.dbutil.DaoManager;
import wiki.qd.shopmall.db.dbutil.IDao;
import wiki.qd.shopmall.entity.UserInfo;

/**
 * 用户信息
 * Created by scene on 2017/11/6.
 */

public class UserInfoDaoManager implements IDao<UserInfo> {

    private DaoSession mDaoSession = DaoManager.getInstance().getDaoSession();

    @Override
    public boolean insert(UserInfo user) {
        return mDaoSession.getUserInfoDao().insert(user) > 0;
    }

    @Override
    public boolean delete(UserInfo user) {
        try {
            mDaoSession.getUserInfoDao()
                    .delete(user);
        } catch (Exception e) {
            Log.e("lxq", "删除失败");
            return false;
        }
        return true;
    }

    @Override
    public boolean update(UserInfo user) {
        try {
            mDaoSession.getUserInfoDao()
                    .update(user);
        } catch (Exception e) {
            Log.e("lxq", "更新失败");
            return false;
        }
        return true;
    }

    @Override
    public List<UserInfo> queryAll() {
        return mDaoSession.getUserInfoDao()
                .loadAll();
    }

    @Override
    public UserInfo queryById(long id) {
        return mDaoSession.getUserInfoDao()
                .loadByRowId(id);
    }

    @Override
    public List<UserInfo> queryByObj(String where, String... params) {
        return mDaoSession.getUserInfoDao()
                .queryRaw(where, params);
    }

    public UserInfo queryByName(String name) {
        return mDaoSession.getUserInfoDao()
                .queryBuilder()
                .where(UserInfoDao.Properties.Nickname.eq(name))
                .build()
                .unique();
    }
}
