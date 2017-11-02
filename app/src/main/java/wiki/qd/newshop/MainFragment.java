package wiki.qd.newshop;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;
import wiki.qd.newshop.base.BaseMainFragment;
import wiki.qd.newshop.ui.BigAndSmallFragment;
import wiki.qd.newshop.ui.MineFragment;
import wiki.qd.newshop.ui.RankFragment;
import wiki.qd.newshop.ui.ServiceCenterFragment;
import wiki.qd.newshop.ui.SingleAndDoubleFragment;
import wiki.qd.newshop.view.bottombar.view.BottomBar;
import wiki.qd.newshop.view.bottombar.view.BottomBarTab;

/**
 * 主界面
 * Created by scene on 2017/11/2.
 */

public class MainFragment extends SupportFragment {
    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;
    public static final int FOUR = 3;
    public static final int FIVE = 4;
    @BindView(R.id.bottomBar)
    BottomBar bottomBar;
    Unbinder unbinder;
    private SupportFragment[] mFragments = new SupportFragment[5];

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
        BaseMainFragment singAndDoubleFragment = findChildFragment(SingleAndDoubleFragment.class);
        if (singAndDoubleFragment == null) {
            mFragments[FIRST] = SingleAndDoubleFragment.newInstance();
            mFragments[SECOND] = BigAndSmallFragment.newInstance();
            mFragments[THIRD] = RankFragment.newInstance();
            mFragments[FOUR] = ServiceCenterFragment.newInstance();
            mFragments[FIVE] = MineFragment.newInstance();

            loadMultipleRootFragment(R.id.fl_tab_container, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND],
                    mFragments[THIRD],
                    mFragments[FOUR],
                    mFragments[FIVE]);
        } else {
            // 这里我们需要拿到mFragments的引用
            mFragments[FIRST] = singAndDoubleFragment;
            mFragments[SECOND] = findChildFragment(BigAndSmallFragment.class);
            mFragments[THIRD] = findChildFragment(RankFragment.class);
            mFragments[FOUR] = findChildFragment(ServiceCenterFragment.class);
            mFragments[FIVE] = findChildFragment(MineFragment.class);
        }
    }

    private void initView() {
        bottomBar
                .addItem(new BottomBarTab(_mActivity, R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round, getString(R.string.tab_single_and_double)))
                .addItem(new BottomBarTab(_mActivity, R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round, getString(R.string.tab_big_and_small)))
                .addItem(new BottomBarTab(_mActivity, R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round, getString(R.string.tab_rank)))
                .addItem(new BottomBarTab(_mActivity, R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round, getString(R.string.tab_service_center)))
                .addItem(new BottomBarTab(_mActivity, R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round, getString(R.string.tab_mine)));

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
