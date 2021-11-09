package games.shmugen.memorygame.fragments;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationSet;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import games.shmugen.memorygame.R;
import games.shmugen.memorygame.common.Shared;
import games.shmugen.memorygame.events.ui.StartEvent;
import games.shmugen.memorygame.utils.Utils;

public class MenuFragment extends Fragment {

    private ImageView mTitle;
    private ImageView mStartGameButton;
    private ImageView mSettingsGameButton;
    private ImageView mGooglePlayGameButton;
    private ImageView mStartButtonLights;
    private ImageView mTooltip;


    @Override
    public View onCreateView(LayoutInflater inFlater, ViewGroup container, Bundle savedInstanceState) {
        View view = inFlater.inflate(R.layout.menu_fragment, container, false);
        mTitle = (ImageView) view.findViewById(R.id.title);
        mStartGameButton = (ImageView) view.findViewById(R.id.start_game_button);
        mStartGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateAllAssetsOff(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        Shared.eventBus.notify(new StartEvent());
                    }
                });
            }
        });
        mSettingsGameButton = (ImageView) view.findViewById(R.id.settings_game_button);
        mSettingsGameButton.setSoundEffectsEnabled(false);

        mGooglePlayGameButton = (ImageView) view.findViewById(R.id.google_play_button);
        mStartButtonLights = (ImageView) view.findViewById(R.id.start_game_button_light);
        mTooltip = (ImageView) view.findViewById(R.id.tooltip);






        return view;


    }

    private void animateAllAssetsOff(AnimatorListenerAdapter adapter){

        //title
        ObjectAnimator titleAnimator = ObjectAnimator.ofFloat(mTitle, "translationY", Utils.px(-200));
        titleAnimator.setInterpolator(new AccelerateInterpolator(2));
        titleAnimator.setDuration(300);

        //lights
        ObjectAnimator lightsAnimatorX = ObjectAnimator.ofFloat(mStartButtonLights, "scaleX", 0f);
        ObjectAnimator lightsAnimatorY = ObjectAnimator.ofFloat(mStartButtonLights, "scaleY", 0f);

        //tooltip
        ObjectAnimator tooltipAnimator = ObjectAnimator.ofFloat(mTooltip, "alpha", 0f);
        tooltipAnimator.setDuration(100);

        //settingsButton
        ObjectAnimator settingsAnimator = ObjectAnimator.ofFloat(mSettingsGameButton, "translationY", Utils.px(120));
        settingsAnimator.setInterpolator(new AccelerateInterpolator(2));
        settingsAnimator.setDuration(300);

        //google play button
        ObjectAnimator googlePlayAnimator = ObjectAnimator.ofFloat(mGooglePlayGameButton, "translationY", Utils.px(120));
        googlePlayAnimator.setInterpolator(new AccelerateInterpolator(2));
        googlePlayAnimator.setDuration(300);

        //start button
        ObjectAnimator startButtonAnimator = ObjectAnimator.ofFloat(mStartGameButton, "translationY", Utils.px(130));
        startButtonAnimator.setInterpolator(new AccelerateInterpolator(2));
        startButtonAnimator.setDuration(300);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(titleAnimator, lightsAnimatorX, lightsAnimatorY, tooltipAnimator, settingsAnimator, googlePlayAnimator, startButtonAnimator);
        animatorSet.addListener(adapter);
        animatorSet.start();

    }
}
