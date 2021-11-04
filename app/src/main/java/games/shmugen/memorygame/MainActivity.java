package games.shmugen.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

import games.shmugen.memorygame.common.Shared;
import games.shmugen.memorygame.engine.Engine;
import games.shmugen.memorygame.events.EventBus;

public class MainActivity extends AppCompatActivity {

    private ImageView mBackgroundImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView mBackgroundImage = findViewById(R.id.background_image);

        //Shared.context = getApplicationContext();
        Context context = getApplicationContext();
        Shared.engine = Engine.getInstance();
        Shared.eventBus = EventBus.getInstance();


        mBackgroundImage = findViewById(R.id.background_image);

        Shared.activity = this;
        Shared.engine.start();
        Shared.engine.setBackgroundImageView(mBackgroundImage);



    }

    private void setmBackgroundImage(){

    }
}