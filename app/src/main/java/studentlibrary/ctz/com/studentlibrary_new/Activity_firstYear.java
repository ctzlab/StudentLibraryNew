package studentlibrary.ctz.com.studentlibrary_new;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Activity_firstYear extends AppCompatActivity {

    LinearLayout llmain1,llmain2,llsub1,llsub2;
    ImageView llmainimg1,llmainimg2;
    LinearLayout sub31,sub32,sub33,sub34,sub35,sub36,sub41,sub42,sub43,sub44,sub45;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_firstyear);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        initViews();
        animation();
        initEvents();

    }


    private void initIntent(String str) {
        Intent intent = new Intent(Activity_firstYear.this, Activity_Result.class);
        intent.putExtra("course_code",str);
        intent.putExtra("activity_code","firstyear");
        startActivity(intent);
        finish();
    }
    private void initEvents() {


        llmain1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(llsub1.getVisibility()==View.GONE)
                {
                    llmainimg1.setImageResource(R.drawable.ic_up_arrow);
                    llsub1.setVisibility(View.VISIBLE);
                }
                else {
                    llsub1.setVisibility(View.GONE);
                    llmainimg1.setImageResource(R.drawable.ic_down_arrow);
                }
            }
        });

        llmain2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(llsub2.getVisibility()==View.GONE)
                {
                    llmainimg2.setImageResource(R.drawable.ic_up_arrow);
                    llsub2.setVisibility(View.VISIBLE);
                }
                else {
                    llsub2.setVisibility(View.GONE);

                    llmainimg2.setImageResource(R.drawable.ic_down_arrow);
                }
            }
        });



        sub31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {initIntent("GE1101");
            }
        });
        sub32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("GE1105");
            }
        });
        sub33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("GE1107");
            }
        });
        sub34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("CV1101");
            }
        });
        sub35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("EE1101");
            }
        });
        sub36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("IT1101");
            }
        });

        // 4th sem

        sub41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("GE1102");
            }
        });
        sub42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("GE1103");
            }
        });
        sub43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("GE1108");
            }
        });
        sub44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("EL1101");
            }
        });
        sub45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1101");
            }
        });






    }

    private void initViews() {

        llmain1=(LinearLayout)findViewById(R.id.ll_title_1);
        llmain2=(LinearLayout)findViewById(R.id.ll_title_2);

        sub31=(LinearLayout)findViewById(R.id.sub3_1);
        sub32=(LinearLayout)findViewById(R.id.sub3_2);
        sub33=(LinearLayout)findViewById(R.id.sub3_3);
        sub34=(LinearLayout)findViewById(R.id.sub3_4);

        sub35=(LinearLayout)findViewById(R.id.sub3_5);
        sub36=(LinearLayout)findViewById(R.id.sub3_6);



        llsub1=(LinearLayout)findViewById(R.id.ll_sem3);
        llsub2=(LinearLayout)findViewById(R.id.ll_sem4);

        llmainimg1=(ImageView)findViewById(R.id.title_img1);
        llmainimg2=(ImageView)findViewById(R.id.title_img2);



        sub41=(LinearLayout)findViewById(R.id.sub4_1);
        sub42=(LinearLayout)findViewById(R.id.sub4_2);
        sub43=(LinearLayout)findViewById(R.id.sub4_3);
        sub44=(LinearLayout)findViewById(R.id.sub4_4);
        sub45=(LinearLayout)findViewById(R.id.sub4_5);
    }

    public void animation() {


        Animation s1 = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        s1.setDuration(400);
        llmain1.setAnimation(s1);

        Animation s2 = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        s2.setDuration(500);
        llmain2.setAnimation(s2);

    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), Activity_drawer_main.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(Activity_firstYear.this, Activity_drawer_main.class);
        startActivity(intent);
        finish();
        return true;
    }
}
