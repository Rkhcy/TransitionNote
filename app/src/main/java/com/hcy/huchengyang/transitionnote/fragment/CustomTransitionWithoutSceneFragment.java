package com.hcy.huchengyang.transitionnote.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.hcy.huchengyang.transitionnote.custom.ChangeColor;
import com.hcy.huchengyang.transitionnote.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by huchengyang on 2017/9/21.
 */

public class CustomTransitionWithoutSceneFragment extends Fragment {
    @BindView(R.id.container)
    LinearLayout mRoot;
    @BindView(R.id.view_1)
    View mView1;
    @BindView(R.id.view_2)
    View mView2;
    @BindView(R.id.view_3)
    View mView3;
    private Transition mTransition;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_custom_transition_without_scene, container, false);
        ButterKnife.bind(this, view);
        mTransition = new ChangeColor();
        mTransition.setDuration(1000);
        return view;
    }

    @OnClick(R.id.container)
    void changeColor(){
        TransitionManager.beginDelayedTransition(mRoot, mTransition);
        mView1.setBackgroundColor(Color.GREEN);
        mView2.setBackgroundColor(Color.BLUE);
        mView3.setBackgroundColor(Color.RED);
    }
}
