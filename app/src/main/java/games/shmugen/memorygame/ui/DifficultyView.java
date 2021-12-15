package games.shmugen.memorygame.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import java.util.Locale;

import games.shmugen.memorygame.R;
import games.shmugen.memorygame.common.Shared;

public class DifficultyView extends LinearLayout {

    private ImageView mTitile;

    public DifficultyView(Context context) {
        super(context, null);
    }

    public DifficultyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.difficulty_view, this, true);
        setOrientation(LinearLayout.VERTICAL);
        mTitile = (ImageView) findViewById(R.id.title);
    }

    public void setDifficulty(int dificulty, int stars){
        String titleResource = String.format(Locale.US, "button_difficulty_%d_star_%d", dificulty, stars);
        int drawableResourceId = Shared.context.getResources().getIdentifier(titleResource, "drawable", Shared.context.getPackageName());
        mTitile.setImageResource(drawableResourceId);
    }
}
