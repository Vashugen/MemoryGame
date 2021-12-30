package games.shmugen.memorygame.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import games.shmugen.memorygame.R;
import games.shmugen.memorygame.common.Shared;
import games.shmugen.memorygame.utils.FontLoader;

public class GameFragment extends BaseFragment {

    private TextView mTime;
    private ImageView mTimeImage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.game_fragment, container, false);
        view.setClipChildren(false);
        ((ViewGroup)view.findViewById(R.id.game_board)).setClipChildren(false);

        mTime = (TextView) view.findViewById(R.id.time_bar_text);
        mTimeImage = (ImageView) view.findViewById(R.id.time_bar_image);
        FontLoader.setTypeFace(Shared.context, new TextView[]{mTime}, FontLoader.Font.GROBOLD);



        return view;
    }
}
