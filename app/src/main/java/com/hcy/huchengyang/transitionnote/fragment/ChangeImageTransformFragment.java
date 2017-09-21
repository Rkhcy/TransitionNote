package com.hcy.huchengyang.transitionnote.fragment;

import android.graphics.Matrix;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.transition.ChangeImageTransform;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hcy.huchengyang.transitionnote.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by huchengyang on 2017/9/21.
 */

public class ChangeImageTransformFragment extends Fragment {
    @BindView(R.id.container)
    LinearLayout mRoot;
    @BindView(R.id.photo)
    ImageView mImageView;
    private Transition mTransition;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_change_image_transform, container, false);
        ButterKnife.bind(this, view);
        mTransition = new ChangeImageTransform();
        return view;
    }
    @OnClick(R.id.fit_xy)
    void fitXY(){
        TransitionManager.beginDelayedTransition(mRoot, mTransition);
        mImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    }
    @OnClick(R.id.center)
    void center(){
        TransitionManager.beginDelayedTransition(mRoot, mTransition);
        mImageView.setScaleType(ImageView.ScaleType.CENTER);
    }
    @OnClick(R.id.center_crop)
    void centerCrop(){
        TransitionManager.beginDelayedTransition(mRoot, mTransition);
        mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
    @OnClick(R.id.fit_start)
    void fitStart(){
        TransitionManager.beginDelayedTransition(mRoot, mTransition);
        mImageView.setScaleType(ImageView.ScaleType.FIT_START);
    }
    @OnClick(R.id.fit_end)
    void firEnd(){
        TransitionManager.beginDelayedTransition(mRoot, mTransition);
        mImageView.setScaleType(ImageView.ScaleType.FIT_END);
    }
    @OnClick(R.id.matrix)
    void matrix(){
        TransitionManager.beginDelayedTransition(mRoot, mTransition);
        mImageView.setScaleType(ImageView.ScaleType.MATRIX);
        final Matrix matrix = new Matrix();
        matrix.setRotate(45.f);
        matrix.postTranslate(200, 10);
        mImageView.setImageMatrix(matrix);

    }
}
