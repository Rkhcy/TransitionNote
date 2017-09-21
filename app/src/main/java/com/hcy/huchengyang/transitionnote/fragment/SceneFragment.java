package com.hcy.huchengyang.transitionnote.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.hcy.huchengyang.transitionnote.R;

/**
 * Created by huchengyang on 2017/9/20.
 */

public class SceneFragment extends Fragment {
    private FrameLayout mSceneRoot;
    private Scene[] mScenes;
    private Scene mScene0;
    private Scene mScene1;
    private Transition mTransition;
    private Button mButton;
    private int mCurrentScene;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scene, container, false);
        mButton = view.findViewById(R.id.toggle);
        mSceneRoot = view.findViewById(R.id.root);
        /*View view0 = inflater.inflate(R.layout.scene0, container, false);
        View view1 = inflater.inflate(R.layout.scene1, container, false);
        mScene0 = new Scene(mSceneRoot, view0);
        mScene1 = new Scene(mSceneRoot, view1);*/
        mScene0 = Scene.getSceneForLayout(mSceneRoot, R.layout.scene0, getContext());
        mScene1 = Scene.getSceneForLayout(mSceneRoot, R.layout.scene1, getContext());
        mScenes = new Scene[]{mScene0, mScene1};
        mTransition = new Fade();
        TransitionManager.go(mScenes[0]);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentScene = (mCurrentScene + 1) % mScenes.length;
                TransitionManager.go(mScenes[mCurrentScene]);
            }
        });

        return view;
    }

}
