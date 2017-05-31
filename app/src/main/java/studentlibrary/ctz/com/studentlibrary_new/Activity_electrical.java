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

public class Activity_electrical extends AppCompatActivity {
    LinearLayout llmain1,llmain2,llmain3,llmain4,llmain5,llmain6,llsub1,llsub2,llsub3,llsub4,llsub5,llsub6;
    ImageView llmainimg1,llmainimg2,llmainimg3,llmainimg4,llmainimg5,llmainimg6;
    LinearLayout sub31,sub32,sub33,sub34,sub35,sub41,sub42,sub43,sub44,sub45,sub51,sub52,sub53,sub54,sub55,sub56,sub57,sub58,sub61,sub62,sub63,sub64,sub65,sub66,sub67,sub68,sub69;
    LinearLayout sub71,sub72,sub73,sub74,sub75,sub76,sub81,sub82,sub83,sub84,sub85,sub86,sub87,sub88;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_electrical);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        initViews();
        animation();
        initEvents();
    }

    private void initIntent(String str) {
        Intent intent = new Intent(Activity_electrical.this, Result_Main.class);
        intent.putExtra("course_code",str);
        intent.putExtra("activity_code","electrical");
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

        llmain3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(llsub3.getVisibility()==View.GONE)
                {
                    llmainimg3.setImageResource(R.drawable.ic_up_arrow);
                    llsub3.setVisibility(View.VISIBLE);
                }
                else {
                    llsub3.setVisibility(View.GONE);

                    llmainimg3.setImageResource(R.drawable.ic_down_arrow);
                }
            }
        });

        llmain4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(llsub4.getVisibility()==View.GONE)
                {
                    llmainimg4.setImageResource(R.drawable.ic_up_arrow);
                    llsub4.setVisibility(View.VISIBLE);
                }
                else {
                    llsub4.setVisibility(View.GONE);

                    llmainimg4.setImageResource(R.drawable.ic_down_arrow);
                }
            }
        });

        llmain5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(llsub5.getVisibility()==View.GONE)
                {
                    llmainimg5.setImageResource(R.drawable.ic_up_arrow);
                    llsub5.setVisibility(View.VISIBLE);
                }
                else {
                    llsub5.setVisibility(View.GONE);

                    llmainimg5.setImageResource(R.drawable.ic_down_arrow);
                }
            }
        });


        llmain6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(llsub6.getVisibility()==View.GONE)
                {
                    llmainimg6.setImageResource(R.drawable.ic_up_arrow);
                    llsub6.setVisibility(View.VISIBLE);
                }
                else {
                    llsub6.setVisibility(View.GONE);

                    llmainimg6.setImageResource(R.drawable.ic_down_arrow);
                }
            }
        });

        sub31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {initIntent("GE1201");
            }
        });
        sub32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("EL1215");
            }
        });
        sub33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("EL1201");
            }
        });
        sub34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("EL1203");
            }
        });
        sub35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("EL1205");
            }
        });

        // 4th sem

        sub41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("GE1204");
            }
        });
        sub42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("EL1207");
            }
        });
        sub43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("EL1209");
            }
        });
        sub44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("EL1211");
            }
        });
        sub45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("EL1213");
            }
        });

        // Fifth Sem

        sub51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("GE1312");
            }
        });
        sub52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("EL1301");
            }
        });
        sub53.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("EL1302");
            }
        });
        sub54.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("EL1304");
            }
        });
        sub55.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("EL1329");
            }
        });
        sub56.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("EL1316");
            }
        });
        sub57.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("EL1320");
            }
        });
        sub58.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("EL1321");
            }
        });


        sub61.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("GE1311");
            }
        });
        sub62.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("EL1306");
            }
        });
        sub63.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {initIntent("EL1308");
            }
        });
        sub64.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("EL1309");
            }
        });
        sub65.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("EL1311");
            }
        });
        sub66.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("EL1322");
            }
        });
        sub67.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("EL1323");
            }
        });
        sub68.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("EL1324");
            }
        });
        sub69.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("EL1325");
            }
        });

        sub71.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("EL1401");
            }
        });
        sub72.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("EL1403");
            }
        });
        sub73.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("EL1432");
            }
        });
        sub74.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("EL1410");
            }
        });
        sub75.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("EL1427");
            }
        });
        sub76.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("EL1431");
            }
        });

        sub81.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("EL1416");
            }
        });
        sub82.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("EL1433");
            }
        });
        sub83.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("EL1411");
            }
        });
        sub84.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("EL1422");
            }
        });
        sub85.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("EL1435");
            }
        });
        sub86.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("EL1424");
            }
        });
        sub87.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("EL1425");
            }
        });
        sub88.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("EL1426");
            }
        });





    }

    private void initViews() {

        llmain1=(LinearLayout)findViewById(R.id.ll_title_1);
        llmain2=(LinearLayout)findViewById(R.id.ll_title_2);
        llmain3=(LinearLayout)findViewById(R.id.ll_title_3);
        llmain4=(LinearLayout)findViewById(R.id.ll_title_4);
        llmain5=(LinearLayout)findViewById(R.id.ll_title_5);
        llmain6=(LinearLayout)findViewById(R.id.ll_title_6);

        sub31=(LinearLayout)findViewById(R.id.sub3_1);
        sub32=(LinearLayout)findViewById(R.id.sub3_2);
        sub33=(LinearLayout)findViewById(R.id.sub3_3);
        sub34=(LinearLayout)findViewById(R.id.sub3_4);
        sub35=(LinearLayout)findViewById(R.id.sub3_5);



        llsub1=(LinearLayout)findViewById(R.id.ll_sem3);
        llsub2=(LinearLayout)findViewById(R.id.ll_sem4);
        llsub3=(LinearLayout)findViewById(R.id.ll_sem5);
        llsub4=(LinearLayout)findViewById(R.id.ll_sem6);
        llsub5=(LinearLayout)findViewById(R.id.ll_sem7);
        llsub6=(LinearLayout)findViewById(R.id.ll_sem8);

        llmainimg1=(ImageView)findViewById(R.id.title_img1);
        llmainimg2=(ImageView)findViewById(R.id.title_img2);
        llmainimg3=(ImageView)findViewById(R.id.title_img3);
        llmainimg4=(ImageView)findViewById(R.id.title_img4);
        llmainimg5=(ImageView)findViewById(R.id.title_img5);
        llmainimg6=(ImageView)findViewById(R.id.title_img6);



        sub41=(LinearLayout)findViewById(R.id.sub4_1);
        sub42=(LinearLayout)findViewById(R.id.sub4_2);
        sub43=(LinearLayout)findViewById(R.id.sub4_3);
        sub44=(LinearLayout)findViewById(R.id.sub4_4);
        sub45=(LinearLayout)findViewById(R.id.sub4_5);


        sub51=(LinearLayout)findViewById(R.id.sub5_1);
        sub52=(LinearLayout)findViewById(R.id.sub5_2);
        sub53=(LinearLayout)findViewById(R.id.sub5_3);
        sub54=(LinearLayout)findViewById(R.id.sub5_4);
        sub55=(LinearLayout)findViewById(R.id.sub5_5);
        sub56=(LinearLayout)findViewById(R.id.sub5_6);
        sub57=(LinearLayout)findViewById(R.id.sub5_7);
        sub58=(LinearLayout)findViewById(R.id.sub5_8);



        sub61=(LinearLayout)findViewById(R.id.sub6_1);
        sub62=(LinearLayout)findViewById(R.id.sub6_2);
        sub63=(LinearLayout)findViewById(R.id.sub6_3);
        sub64=(LinearLayout)findViewById(R.id.sub6_4);
        sub65=(LinearLayout)findViewById(R.id.sub6_5);
        sub66=(LinearLayout)findViewById(R.id.sub6_6);
        sub67=(LinearLayout)findViewById(R.id.sub6_7);
        sub68=(LinearLayout)findViewById(R.id.sub6_8);
        sub69=(LinearLayout)findViewById(R.id.sub6_9);


        sub71=(LinearLayout)findViewById(R.id.sub7_1);
        sub72=(LinearLayout)findViewById(R.id.sub7_2);
        sub73=(LinearLayout)findViewById(R.id.sub7_3);
        sub74=(LinearLayout)findViewById(R.id.sub7_4);
        sub75=(LinearLayout)findViewById(R.id.sub7_5);
        sub76=(LinearLayout)findViewById(R.id.sub7_6);



        sub81=(LinearLayout)findViewById(R.id.sub8_1);
        sub82=(LinearLayout)findViewById(R.id.sub8_2);
        sub83=(LinearLayout)findViewById(R.id.sub8_3);
        sub84=(LinearLayout)findViewById(R.id.sub8_4);
        sub85=(LinearLayout)findViewById(R.id.sub8_5);
        sub86=(LinearLayout)findViewById(R.id.sub8_6);
        sub87=(LinearLayout)findViewById(R.id.sub8_7);
        sub88=(LinearLayout)findViewById(R.id.sub8_8);

    }

    public void animation() {


        Animation s1 = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        s1.setDuration(400);
        llmain1.setAnimation(s1);

        Animation s2 = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        s2.setDuration(500);
        llmain2.setAnimation(s2);

        Animation s3 = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        s3.setDuration(600);
        llmain3.setAnimation(s3);

        Animation s4 = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        s4.setDuration(700);
        llmain4.setAnimation(s4);

        Animation s5 = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        s5.setDuration(800);
        llmain5.setAnimation(s5);

        Animation s6 = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        s6.setDuration(900);
        llmain6.setAnimation(s6);





    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), Activity_drawer_main.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(Activity_electrical.this, Activity_drawer_main.class);
        startActivity(intent);
        finish();

        return true;
    }
}
