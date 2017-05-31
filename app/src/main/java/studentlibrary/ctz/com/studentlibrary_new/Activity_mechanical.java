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

public class Activity_mechanical extends AppCompatActivity {
    LinearLayout llmain1,llmain2,llmain3,llmain4,llmain5,llmain6,llsub1,llsub2,llsub3,llsub4,llsub5,llsub6;
    ImageView llmainimg1,llmainimg2,llmainimg3,llmainimg4,llmainimg5,llmainimg6;
    LinearLayout sub31,sub32,sub33,sub34,sub35,sub36,sub41,sub42,sub43,sub44,sub45,sub46,sub51,sub52,sub53,sub54,sub55,sub56,sub57,sub58,sub61,sub62,sub63,sub64,sub65,sub66,sub67;
    LinearLayout sub71,sub72,sub73,sub74,sub75,sub76,sub77,sub78,sub79,sub710,sub711,sub712,sub713,sub714,sub715,sub716,sub717,sub718,sub81,sub82,sub83,sub84,sub85,sub86,sub87,sub88,sub89,sub810,sub811,sub812,sub813,sub814,sub815,sub816;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mechanical);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);

        initViews();
        animation();
        initEvents();
    }


    private void initIntent(String str) {
        Intent intent = new Intent(Activity_mechanical.this, Activity_Result.class);
        intent.putExtra("course_code",str);
        intent.putExtra("activity_code","mech");
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
                initIntent("ME1201");
            }
        });
        sub33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1203");
            }
        });
        sub34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1205");
            }
        });
        sub35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("EE1206");
            }
        });
        sub36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1207");
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
                initIntent("ME1210");
            }
        });
        sub43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1212");
            }
        });
        sub44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1213");
            }
        });
        sub45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1215");
            }
        });
        sub46.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1217");
            }
        });

        // Fifth Sem

        sub51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("GE1311");
            }
        });
        sub52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1301");
            }
        });
        sub53.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1303");
            }
        });
        sub54.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1323");
            }
        });
        sub55.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1307");
            }
        });
        sub56.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1317");
            }
        });
        sub57.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1315");
            }
        });
        sub58.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1321");
            }
        });

        //sixth sem

        sub61.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("GE1312");
            }
        });
        sub62.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1310");
            }
        });
        sub63.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {initIntent("ME1312");
            }
        });
        sub64.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1320");
            }
        });
        sub65.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1331");
            }
        });
        sub66.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1332");
            }
        });
        sub67.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1333");
            }
        });

        //seventh sem

        sub71.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1447");
            }
        });
        sub72.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1448");
            }
        });
        sub73.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1401");
            }
        });
        sub74.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1402");
            }
        });
        sub75.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1449");
            }
        });
        sub76.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1404");
            }
        });
        sub77.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1405");
            }
        });
        sub78.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1456");
            }
        });
        sub79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1408");
            }
        });
        sub710.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1409");
            }
        });
        sub711.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1410");
            }
        });
        sub712.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1411");
            }
        });
        sub713.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1412");
            }
        });
        sub714.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1445");
            }
        });
        sub715.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1417");
            }
        });
        sub716.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1419");
            }
        });
        sub717.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1406");
            }
        });
        sub718.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1421");
            }
        });

        //eight sem

        sub81.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1435");
            }
        });
        sub82.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1475");
            }
        });
        sub83.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1437");
            }
        });
        sub84.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1439");
            }
        });
        sub85.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1441");
            }
        });
        sub86.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1443");
            }
        });
        sub87.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1415");
            }
        });
        sub88.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1451");
            }
        });
        sub89.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1452");
            }
        });
        sub810.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1453");
            }
        });
        sub811.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1454");
            }
        });
        sub812.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1455");
            }
        });
        sub813.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1457");
            }
        });
        sub814.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1458");
            }
        });
        sub815.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1459");
            }
        });
        sub816.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIntent("ME1460");
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
        sub36=(LinearLayout)findViewById(R.id.sub3_6);



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
        sub46=(LinearLayout)findViewById(R.id.sub4_6);


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

        sub71=(LinearLayout)findViewById(R.id.sub7_1);
        sub72=(LinearLayout)findViewById(R.id.sub7_2);
        sub73=(LinearLayout)findViewById(R.id.sub7_3);
        sub74=(LinearLayout)findViewById(R.id.sub7_4);
        sub75=(LinearLayout)findViewById(R.id.sub7_5);
        sub76=(LinearLayout)findViewById(R.id.sub7_6);
        sub77=(LinearLayout)findViewById(R.id.sub7_7);
        sub78=(LinearLayout)findViewById(R.id.sub7_8);
        sub79=(LinearLayout)findViewById(R.id.sub7_9);
        sub710=(LinearLayout)findViewById(R.id.sub7_10);
        sub711=(LinearLayout)findViewById(R.id.sub7_11);
        sub712=(LinearLayout)findViewById(R.id.sub7_12);
        sub713=(LinearLayout)findViewById(R.id.sub7_13);
        sub714=(LinearLayout)findViewById(R.id.sub7_14);
        sub715=(LinearLayout)findViewById(R.id.sub7_15);
        sub716=(LinearLayout)findViewById(R.id.sub7_16);
        sub717=(LinearLayout)findViewById(R.id.sub7_17);
        sub718=(LinearLayout)findViewById(R.id.sub7_18);



        sub81=(LinearLayout)findViewById(R.id.sub8_1);
        sub82=(LinearLayout)findViewById(R.id.sub8_2);
        sub83=(LinearLayout)findViewById(R.id.sub8_3);
        sub84=(LinearLayout)findViewById(R.id.sub8_4);
        sub85=(LinearLayout)findViewById(R.id.sub8_5);
        sub86=(LinearLayout)findViewById(R.id.sub8_6);
        sub87=(LinearLayout)findViewById(R.id.sub8_7);
        sub88=(LinearLayout)findViewById(R.id.sub8_8);
        sub89=(LinearLayout)findViewById(R.id.sub8_9);
        sub810=(LinearLayout)findViewById(R.id.sub8_10);
        sub811=(LinearLayout)findViewById(R.id.sub8_11);
        sub812=(LinearLayout)findViewById(R.id.sub8_12);
        sub813=(LinearLayout)findViewById(R.id.sub8_13);
        sub814=(LinearLayout)findViewById(R.id.sub8_14);
        sub815=(LinearLayout)findViewById(R.id.sub8_15);
        sub816=(LinearLayout)findViewById(R.id.sub8_16);

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
        Intent intent = new Intent(Activity_mechanical.this, Activity_drawer_main.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent = new Intent(Activity_mechanical.this, Activity_drawer_main.class);
        startActivity(intent);
        finish();
        return true;
    }
}
