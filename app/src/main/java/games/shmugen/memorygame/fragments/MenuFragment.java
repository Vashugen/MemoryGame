package games.shmugen.memorygame.fragments;

import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import games.shmugen.memorygame.R;
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
                //animateA
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

        ObjectAnimator titleAnimator = ObjectAnimator.ofFloat(mTitle, "translationY", Utils.px(-200));
        titleAnimator.setInterpolator(new AccelerateInterpolator(2));
        titleAnimator.setDuration(300);

    }
}
