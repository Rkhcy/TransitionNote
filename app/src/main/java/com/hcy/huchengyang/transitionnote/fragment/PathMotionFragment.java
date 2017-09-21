package com.hcy.huchengyang.transitionnote.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.transition.ArcMotion;
import android.transition.AutoTransition;
import android.transition.ChangeBounds;
import android.transition.PatternPathMotion;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.hcy.huchengyang.transitionnote.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by huchengyang on 2017/9/20.
 */

public class PathMotionFragment extends Fragment {
    @BindView(R.id.root)
    FrameLayout mRoot;
    @BindView(R.id.target)
    TextView mTarget;
    private Transition mTransition;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_path_motion, container, false);
        ButterKnife.bind(this, view);
        mTransition = new AutoTransition();
        mTransition.setPathMotion(new ArcMotion());
       //mTransition.setPathMotion(new PatternPathMotion());
        mTransition.setDuration(1000);
        return view;
    }

    @OnClick(R.id.move)
    void toggle(){
        TransitionManager.beginDelayedTransition(mRoot, mTransition);
        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) mTarget.getLayoutParams();
        if ((lp.gravity & Gravity.START) == Gravity.START) {
            lp.gravity = Gravity.END | Gravity.BOTTOM;
        } else {
            lp.gravity = Gravity.START | Gravity.TOP;
        }
        mTarget.setLayoutParams(lp);
    }

}
