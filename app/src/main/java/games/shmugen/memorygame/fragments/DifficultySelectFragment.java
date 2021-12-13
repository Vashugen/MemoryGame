package games.shmugen.memorygame.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import games.shmugen.memorygame.R;
import games.shmugen.memorygame.common.Shared;

public class DifficultySelectFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = LayoutInflater.from(Shared.context).inflate(R.layout.difficulty_select_fragment, container, false);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
