package wiki.qd.newshop.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import wiki.qd.newshop.R;
import wiki.qd.newshop.base.BaseMainFragment;

/**
 * 单双夺宝
 * Created by scene on 2017/11/2.
 */

public class SingleAndDoubleFragment extends BaseMainFragment {
    public static SingleAndDoubleFragment newInstance() {
        Bundle args = new Bundle();
        SingleAndDoubleFragment fragment = new SingleAndDoubleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_single_and_double, container, false);
        return view;
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
    }
}
