package games.shmugen.memorygame.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import games.shmugen.memorygame.R;
import games.shmugen.memorygame.common.Shared;
import games.shmugen.memorygame.themes.Theme;
import games.shmugen.memorygame.themes.Themes;

public class ThemeSelectFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = LayoutInflater.from(Shared.context).inflate(R.layout.theme_select_fragment, container, false);
        View animals = view.findViewById(R.id.theme_animals_container);
        View monsters = view.findViewById(R.id.theme_monsters_container);
        View emoji = view.findViewById(R.id.theme_emoji_container);

        final Theme themeAnimals = Themes.createAnimalsTheme();
        setStars((ImageView) animals.findViewById(R.id.theme_animals), themeAnimals, "animals");

        return inflater.inflate(R.layout.theme_select_fragment, container, false);
    }

    private void setStars(ImageView imageView, Theme theme, String type){
        int sum = 0;

        for (int difficulty = 1; difficulty <= 6; difficulty++){

        }
    }
}
