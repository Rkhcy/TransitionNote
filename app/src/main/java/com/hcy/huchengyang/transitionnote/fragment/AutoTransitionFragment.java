package com.hcy.huchengyang.transitionnote.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.transition.AutoTransition;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hcy.huchengyang.transitionnote.R;

/**
 * Created by huchengyang on 2017/9/21.
 */

public class AutoTransitionFragment extends Fragment {
    private Button mButton;
    private TextView mTextView;
    private LinearLayout mRoot;
    private Transition mTransition;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_auto_transition, container, false);
        mButton = view.findViewById(R.id.button);
        mTextView = view.findViewById(R.id.message);
        mRoot = view.findViewById(R.id.root);
        mTransition = new AutoTransition();
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggle();
            }
        });
        return view;
    }

    private void toggle() {
        TransitionManager.beginDelayedTransition(mRoot, mTransition);
        if (mTextView.getVisibility() != View.VISIBLE) {
            mTextView.setVisibility(View.VISIBLE);
        } else {
            mTextView.setVisibility(View.GONE);
        }
    }

}
