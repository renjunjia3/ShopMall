package wiki.qd.shopmall;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;
import wiki.qd.newshop.R;
import wiki.qd.shopmall.base.BaseMainFragment;
import wiki.qd.shopmall.ui.MineFragment;
import wiki.qd.shopmall.ui.RankFragment;
import wiki.qd.shopmall.ui.ServiceCenterFragment;
import wiki.qd.shopmall.ui.IndexFragment;
import wiki.qd.shopmall.view.BottomBar;
import wiki.qd.shopmall.view.BottomBarTab;

/**
 * 主界面
 * Created by scene on 2017/11/2.
 */

public class MainFragment extends SupportFragment {
    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;
    public static final int FOUR = 3;
    @BindView(R.id.bottomBar)
    BottomBar bottomBar;
    Unbinder unbinder;
    private SupportFragment[] mFragments = new SupportFragment[4];

    public static MainFragment newInstance() {
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        BaseMainFragment singAndDoubleFragment = findChildFragment(IndexFragment.class);
        if (singAndDoubleFragment == null) {
            mFragments[FIRST] = IndexFragment.newInstance();
            mFragments[SECOND] = RankFragment.newInstance();
            mFragments[THIRD] = ServiceCenterFragment.newInstance();
            mFragments[FOUR] = MineFragment.newInstance();

            loadMultipleRootFragment(R.id.fl_tab_container, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND],
                    mFragments[THIRD],
                    mFragments[FOUR]);
        } else {
            // 这里我们需要拿到mFragments的引用
            mFragments[FIRST] = singAndDoubleFragment;
            mFragments[SECOND] = findChildFragment(RankFragment.class);
            mFragments[THIRD] = findChildFragment(ServiceCenterFragment.class);
            mFragments[FOUR] = findChildFragment(MineFragment.class);
        }
    }

    private void initView() {
        bottomBar
                .addItem(new BottomBarTab(_mActivity, R.drawable.ic_tab_index_d, R.drawable.ic_tab_index_s, getString(R.string.tab_index)))
                .addItem(new BottomBarTab(_mActivity, R.drawable.ic_tab_rank_d, R.drawable.ic_tab_rank_s, getString(R.string.tab_rank)))
                .addItem(new BottomBarTab(_mActivity, R.drawable.ic_tab_service_d, R.drawable.ic_tab_service_s, getString(R.string.tab_service_center)))
                .addItem(new BottomBarTab(_mActivity, R.drawable.ic_tab_mine_d, R.drawable.ic_tab_mine_s, getString(R.string.tab_mine)));

        bottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {
                showHideFragment(mFragments[position], mFragments[prePosition]);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {
            }
        });
    }

    public void startBrotherFragment(SupportFragment targetFragment) {
        start(targetFragment);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
