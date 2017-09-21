package com.hcy.huchengyang.transitionnote.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.transition.ChangeImageTransform;
import android.transition.ChangeTransform;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.hcy.huchengyang.transitionnote.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by huchengyang on 2017/9/21.
 */

public class TransitionSetFragment extends Fragment {
    @BindView(R.id.outer_frame)
    FrameLayout mOuterFrame;
    @BindView(R.id.inner_frame)
    FrameLayout mInnerFrame;
    private TransitionSet mTransition;
    int mPhotoSize;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transition_set, container, false);
        ButterKnife.bind(this, view);
        mPhotoSize = getResources().getDimensionPixelSize(R.dimen.photo_size);
        mTransition = new TransitionSet();
        mTransition.addTransition(new ChangeImageTransform());
        mTransition.addTransition(new ChangeTransform());
        //mTransition = (TransitionSet) TransitionInflater.from(getContext()).inflateTransition(R.transition.transition);
        addImageView(mOuterFrame, ImageView.ScaleType.CENTER_CROP, mPhotoSize);
        return view;
    }

    private void addImageView(FrameLayout parent, ImageView.ScaleType scaleType, int size) {
        final ImageView photo = new ImageView(getContext());
        photo.setImageResource(R.drawable.photo);
        photo.setId(R.id.photo);
        photo.setScaleType(scaleType);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(size, size);
        parent.addView(photo, lp);
    }

    @OnClick(R.id.toggle)
    void toggle(){
        TransitionManager.beginDelayedTransition(mOuterFrame, mTransition);
        if (mInnerFrame.getChildCount() > 0) {
            mInnerFrame.removeAllViews();
            addImageView(mOuterFrame, ImageView.ScaleType.CENTER_CROP, mPhotoSize);
        } else {
            mOuterFrame.removeViewAt(1);
            addImageView(mInnerFrame, ImageView.ScaleType.FIT_XY,
                    FrameLayout.LayoutParams.MATCH_PARENT);
        }
    }
}
