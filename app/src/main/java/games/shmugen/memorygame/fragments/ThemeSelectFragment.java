package games.shmugen.memorygame.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import games.shmugen.memorygame.R;

public class ThemeSelectFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //View view = LayoutInflater.from(Shared.context).inflate()

        return inflater.inflate(R.layout.theme_select_fragment, container, false);
    }
}