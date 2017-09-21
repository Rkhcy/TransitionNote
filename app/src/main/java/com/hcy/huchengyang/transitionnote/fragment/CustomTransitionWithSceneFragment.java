package com.hcy.huchengyang.transitionnote.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.hcy.huchengyang.transitionnote.R;
import com.hcy.huchengyang.transitionnote.custom.ChangeSceneColor;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by huchengyang on 2017/9/21.
 */

public class CustomTransitionWithSceneFragment extends Fragment {
    @BindView(R.id.root)
    FrameLayout mRoot;
    private Scene[] mScenes;
    private int mCurrentScene;
    private Transition mTransition;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_custom_transition_with_scene, container, false);
        ButterKnife.bind(this, view);
        mScenes = new Scene[]{
                Scene.getSceneForLayout(mRoot, R.layout.custom0, getActivity()),
                Scene.getSceneForLayout(mRoot, R.layout.custom1, getActivity()),
                Scene.getSceneForLayout(mRoot, R.layout.custom2, getActivity())
        };
        mTransition = new ChangeSceneColor();
        TransitionManager.go(mScenes[0], mTransition);
        return view;
    }

    @OnClick(R.id.root)
    void toggle(){
        mCurrentScene = (mCurrentScene + 1) % mScenes.length;
        TransitionManager.go(mScenes[mCurrentScene], mTransition);
    }
}
