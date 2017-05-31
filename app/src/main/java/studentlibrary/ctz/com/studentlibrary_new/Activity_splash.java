package studentlibrary.ctz.com.studentlibrary_new;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Activity_splash extends AppCompatActivity {

    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_splash);

        pb = (ProgressBar) findViewById(R.id.pb_splash);
        pb.setVisibility(View.VISIBLE);

        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {

                    Intent i = new Intent(Activity_splash.this, Activity_drawer_main.class);
                    startActivity(i);
                    finish();

           }
        }, 100);
    }
}
