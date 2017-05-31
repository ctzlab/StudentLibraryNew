package studentlibrary.ctz.com.studentlibrary_new;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity_about_us extends AppCompatActivity {

    TextView tv_credits;
    TextView tv_dev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_about_us);




        tv_credits=(TextView)findViewById(R.id.tv_credits);

        tv_credits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity_about_us.this,Activity_credit.class);
                startActivity(intent);
                finish();
            }
        });

        tv_dev=(TextView)findViewById(R.id.tv_dev);

        tv_dev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity_about_us.this,Activity_dev.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Activity_about_us.this,Activity_drawer_main.class);
        startActivity(intent);
        finish();
    }
}
////studentlibrary.ctz.com.studentlibrary