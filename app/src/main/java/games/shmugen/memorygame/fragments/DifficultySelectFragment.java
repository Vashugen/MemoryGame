package games.shmugen.memorygame.fragments;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Locale;

import games.shmugen.memorygame.R;
import games.shmugen.memorygame.common.Memory;
import games.shmugen.memorygame.common.Shared;
import games.shmugen.memorygame.events.ui.DifficultySelectedEvent;
import games.shmugen.memorygame.themes.Theme;
import games.shmugen.memorygame.ui.DifficultyView;

public class DifficultySelectFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = LayoutInflater.from(Shared.context).inflate(R.layout.difficulty_select_fragment, container, false);
        Theme theme = Shared.engine.getSelectedTheme();

        DifficultyView difficulty1 = (DifficultyView) view.findViewById(R.id.select_difficulty_1);
        difficulty1.setDifficulty(1, Memory.getHighStars(theme.id, 1));
        setOnClick(difficulty1, 1);

        DifficultyView difficulty2 = (DifficultyView) view.findViewById(R.id.select_difficulty_2);
        difficulty1.setDifficulty(2, Memory.getHighStars(theme.id, 2));
        setOnClick(difficulty2, 2);

        DifficultyView difficulty3 = (DifficultyView) view.findViewById(R.id.select_difficulty_3);
        difficulty1.setDifficulty(3, Memory.getHighStars(theme.id, 3));
        setOnClick(difficulty3, 3);

        DifficultyView difficulty4 = (DifficultyView) view.findViewById(R.id.select_difficulty_4);
        difficulty4.setDifficulty(4, Memory.getHighStars(theme.id, 4));
        setOnClick(difficulty4, 4);

        DifficultyView difficulty5 = (DifficultyView) view.findViewById(R.id.select_difficulty_5);
        difficulty5.setDifficulty(5, Memory.getHighStars(theme.id, 5));
        setOnClick(difficulty5, 5);

        DifficultyView difficulty6 = (DifficultyView) view.findViewById(R.id.select_difficulty_6);
        difficulty6.setDifficulty(6, Memory.getHighStars(theme.id, 6));
        setOnClick(difficulty6, 6);




        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void setOnClick(View view, final int difficulty){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Shared.eventBus.notify(new DifficultySelectedEvent(difficulty));
            }
        });
    }
}
