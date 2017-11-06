package wiki.qd.newshop.db.dbutil;

import java.util.List;

import wiki.qd.newshop.entity.UserInfo;

/**
 * Created by scene on 2017/11/6.
 */

public interface IDao<T> {
    boolean insert(T bean);

    boolean delete(T bean);

    boolean update(T bean);

    List<T> queryAll();

    T queryById(long id);

    List<T> queryByObj(String where, String... params);
}
