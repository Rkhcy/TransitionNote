package com.hcy.huchengyang.transitionnote;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hcy.huchengyang.transitionnote.fragment.CustomTransitionWithSceneFragment;
import com.hcy.huchengyang.transitionnote.fragment.CustomTransitionWithoutSceneFragment;
import com.hcy.huchengyang.transitionnote.fragment.AutoTransitionFragment;
import com.hcy.huchengyang.transitionnote.fragment.ChangeBoundsFragment;
import com.hcy.huchengyang.transitionnote.fragment.ChangeClipBoundsFragment;
import com.hcy.huchengyang.transitionnote.fragment.ChangeImageTransformFragment;
import com.hcy.huchengyang.transitionnote.fragment.ChangeScrollFragment;
import com.hcy.huchengyang.transitionnote.fragment.ChangeTransformFragment;
import com.hcy.huchengyang.transitionnote.fragment.ExplodeFadeSlideFragment;
import com.hcy.huchengyang.transitionnote.fragment.MainFragment;
import com.hcy.huchengyang.transitionnote.fragment.PathMotionFragment;
import com.hcy.huchengyang.transitionnote.fragment.SceneFragment;
import com.hcy.huchengyang.transitionnote.fragment.TransitionSetFragment;

public class MainActivity extends AppCompatActivity implements MainFragment.OnListItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            MainFragment mainFragment = new MainFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content, mainFragment)
                    .commit();
        }
    }

    @Override
    public void onListItemClick(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new AutoTransitionFragment();
                break;
            case 1:
                fragment = new ChangeBoundsFragment();
                break;
            case 2:
                fragment = new ChangeClipBoundsFragment();
                break;
            case 3:
                fragment = new ChangeImageTransformFragment();
                break;
            case 4:
                fragment = new ChangeScrollFragment();
                break;
            case 5:
                fragment = new ChangeTransformFragment();
                break;
            case 6:
                fragment = new ExplodeFadeSlideFragment();
                break;
            case 7:
                fragment = new TransitionSetFragment();
                break;
            case 8:
                fragment = new PathMotionFragment();
                break;
            case 9:
                fragment = new CustomTransitionWithoutSceneFragment();
                break;
            case 10:
                fragment = new SceneFragment();
                break;
            case 11:
                fragment = new CustomTransitionWithSceneFragment();
                break;
            default:
                break;
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, fragment)
                .addToBackStack(null)
                .commit();
    }
}
