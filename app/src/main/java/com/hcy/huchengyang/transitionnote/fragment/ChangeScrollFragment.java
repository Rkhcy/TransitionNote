package com.hcy.huchengyang.transitionnote.fragment;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.transition.ChangeScroll;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.hcy.huchengyang.transitionnote.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by huchengyang on 2017/9/21.
 */

public class ChangeScrollFragment extends Fragment {

    @BindView(R.id.root)
    FrameLayout mRoot;
    @BindView(R.id.target)
    View mTarget;
    private Transition mTransition;
    @TargetApi(Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_change_scroll, container, false);
        ButterKnife.bind(this, view);
        mTransition = new ChangeScroll();
        return view;
    }
    @OnClick(R.id.move)
    void move(){
        TransitionManager.beginDelayedTransition(mRoot, mTransition);
        mTarget.scrollBy(-100, -100);
    }
}
