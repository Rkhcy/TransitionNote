package com.hcy.huchengyang.transitionnote.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.hcy.huchengyang.transitionnote.R;

/**
 * Created by huchengyang on 2017/9/21.
 */

public class ChangeBoundsFragment extends Fragment {
    private Button mButton;
    private FrameLayout mRoot;
    private View mTarget;
    private Transition mTransition;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_change_bounds, container, false);
        mRoot = view.findViewById(R.id.root);
        mTarget = view.findViewById(R.id.target);
        mButton = view.findViewById(R.id.move);
        mTransition = new ChangeBounds();
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                move();
            }
        });
        return view;
    }

    private void move() {
        TransitionManager.beginDelayedTransition(mRoot, mTransition);
        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) mTarget.getLayoutParams();
        if ((lp.gravity & Gravity.START) == Gravity.START) {
            lp.gravity = Gravity.BOTTOM | Gravity.END;
        } else {
            lp.gravity = Gravity.TOP | Gravity.START;
        }
        mTarget.setLayoutParams(lp);
    }
}
