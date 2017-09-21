package com.hcy.huchengyang.transitionnote.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.transition.ChangeTransform;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.hcy.huchengyang.transitionnote.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by huchengyang on 2017/9/21.
 */

public class ChangeTransformFragment extends Fragment {
    @BindView(R.id.root)
    LinearLayout mRoot;
    @BindView(R.id.container_1)
    FrameLayout mContainer1;
    @BindView(R.id.container_2)
    FrameLayout mContainer2;
    private Transition mTransition;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_change_transform, container, false);
        ButterKnife.bind(this, view);
        mTransition = new ChangeTransform();
        showRedSquare(mContainer1);
        return view;
    }
    @OnClick(R.id.toggle)
    void toggle(){
        TransitionManager.beginDelayedTransition(mRoot, mTransition);
        if (mContainer2.getChildCount() > 0) {
            mContainer2.removeAllViews();
            showRedSquare(mContainer1);
        } else {
            mContainer1.removeAllViews();
            showRedSquare(mContainer2);
            mContainer2.getChildAt(0).setRotation(45);
        }
    }

    private void showRedSquare(FrameLayout container) {
        final View view = LayoutInflater.from(getContext())
                .inflate(R.layout.red_square, container, false);
        container.addView(view);
    }
}
