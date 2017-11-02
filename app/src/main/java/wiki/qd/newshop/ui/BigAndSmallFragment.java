package wiki.qd.newshop.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import wiki.qd.newshop.R;
import wiki.qd.newshop.base.BaseMainFragment;

/**
 * 大小夺宝
 * Created by scene on 2017/11/2.
 */

public class BigAndSmallFragment extends BaseMainFragment {
    public static BigAndSmallFragment newInstance() {
        Bundle args = new Bundle();
        BigAndSmallFragment fragment = new BigAndSmallFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_big_and_small, container, false);
        return view;
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
    }
}
