package studentlibrary.ctz.com.studentlibrary_new;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class Result_Main extends AppCompatActivity {
    String COURSE_CODE, Activity_code;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = new Bundle();
        bundle.putString("edttext", "From Activity");
        setContentView(R.layout.layout_result_main);
        COURSE_CODE=getIntent().getExtras().getString("course_code","CODE");
        Activity_code=getIntent().getExtras().getString("activity_code","");

//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(2);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void goBack() {
        if(Activity_code.equals("mech"))
        {
            Intent intent=new Intent(Result_Main.this,Activity_mechanical.class);
            startActivity(intent);
            finish();
        }else if(Activity_code.equals("civil"))
        {
            Intent intent=new Intent(Result_Main.this,Activity_civil_main.class);
            startActivity(intent);
            finish();
        }else if(Activity_code.equals("electrical"))
        {
            Intent intent=new Intent(Result_Main.this,Activity_electrical.class);
            startActivity(intent);
            finish();
        }else if(Activity_code.equals("firstyear"))
        {
            Intent intent=new Intent(Result_Main.this,Activity_firstYear.class);
            startActivity(intent);
            finish();
        }else if(Activity_code.equals("computer"))
        {
            Intent intent=new Intent(Result_Main.this,Activity_computer.class);
            startActivity(intent);
            finish();
        }else if(Activity_code.equals("electronics"))
        {
            Intent intent=new Intent(Result_Main.this,Activity_electronics.class);
            startActivity(intent);
            finish();
        }else if(Activity_code.equals("elec_tele"))
        {
            Intent intent=new Intent(Result_Main.this,Activity_elec_tele.class);
            startActivity(intent);
            finish();
        }else if(Activity_code.equals("information"))
        {
            Intent intent=new Intent(Result_Main.this,Activity_information.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        goBack();
    }



    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new MSE(), "MSE");
        adapter.addFragment(new ESE(), "ESE");
        adapter.addFragment(new Study_Material(), "Study Material");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}