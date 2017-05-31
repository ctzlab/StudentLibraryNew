package studentlibrary.ctz.com.studentlibrary_new;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import studentlibrary.ctz.com.studentlibrary_new.Adapter.HomeDTO;
import studentlibrary.ctz.com.studentlibrary_new.Adapter.Home_List_Adapter;

public class Activity_drawer_main extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    WebView wb1;
    String TAG;
    String array[] = new String[100];
    HomeDTO dtoObject;
    ListView listView;
    ProgressBar pb_home;
    TextView tv_home;
    ArrayList<HomeDTO> arrayDTO = new ArrayList<>();
    AlertDialog.Builder builder;
    BroadcastReceiver downcomplete,notification;
    DownloadManager downloadManager;


    private BroadcastReceiver mRegistrationBroadcastReceiver;


    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.layout_drawer_main);
        FirebaseMessaging.getInstance().subscribeToTopic(Config.TOPIC_GLOBAL);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            listView=(ListView)findViewById(R.id.listview_home);
            pb_home=(ProgressBar)findViewById(R.id.pb_home);
            pb_home.setVisibility(View.VISIBLE);
            tv_home=(TextView)findViewById(R.id.tv_home);

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.setDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);

            wb1 = (WebView) findViewById(R.id.webview_main);
            wb1.getSettings().setJavaScriptEnabled(true);
            wb1.getSettings().setLoadWithOverviewMode(true);
            wb1.getSettings().setUseWideViewPort(true);
            new GetContacts().execute();
            listView.setDivider(null);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                   String str=array[position];

                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(str));
                    startActivity(browserIntent);
                }



            });

        wb1.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading (WebView view, String url) {
                if (url.endsWith(".pdf")) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                    // if want to download pdf manually create AsyncTask here
                    // and download file
                    return true;
                }
                return false;
            }
        });

        mRegistrationBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                // checking for type intent filter
                if (intent.getAction().equals(Config.REGISTRATION_COMPLETE)) {
                    // gcm successfully registered
                    // now subscribe to `global` topic to receive app wide notifications
                    FirebaseMessaging.getInstance().subscribeToTopic(Config.TOPIC_GLOBAL);

                    displayFirebaseRegId();

                } else if (intent.getAction().equals(Config.PUSH_NOTIFICATION)) {
                    // new push notification is received
                    String message = intent.getStringExtra("message");
                    Toast.makeText(getApplicationContext(), "Push notification: " + message, Toast.LENGTH_LONG).show();

                }
            }
        };
        displayFirebaseRegId();

    }


    private void displayFirebaseRegId() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences(Config.SHARED_PREF, 0);
        String regId = pref.getString("regId", null);

        Log.e(TAG, "Firebase reg id: " + regId);

    }

    @Override
    protected void onResume() {
        super.onResume();

        // register GCM registration complete receiver
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
                new IntentFilter(Config.REGISTRATION_COMPLETE));

        // register new push message receiver
        // by doing this, the activity will be notified each time a new message arrives
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
                new IntentFilter(Config.PUSH_NOTIFICATION));

        // clear the notification area when the app is opened
        NotificationUtils.clearNotifications(getApplicationContext());
    }

    @Override
    protected void onPause() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mRegistrationBroadcastReceiver);
        super.onPause();
    }




//    private void initDownload(String str) {
//        mrequest = new DownloadManager.Request(Uri.parse(str));
//        downloadManager.enqueue(mrequest);
//    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            builder = new AlertDialog.Builder(this);
            builder.setCancelable(false);
            builder.setMessage("Do you want to exit ?");
            builder.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_drawer_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_refresh) {
            new GetContacts().execute();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.first_year) {
            Intent intent1 = new Intent(this, Activity_firstYear.class);
            startActivity(intent1);
            finish();
        } else if (id==R.id.fee_pay) {

//            Intent intent1 = new Intent(this,MainActivity.class);
//            startActivity(intent1);
//            finish();

            String str=array[0];
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(str));
            startActivity(browserIntent);


        } else {
            if (id == R.id.civil) {
                Intent intent1 = new Intent(this, Activity_civil_main.class);
                startActivity(intent1);
                finish();
            } else if (id == R.id.computer) {
                Intent intent1 = new Intent(this, Activity_computer.class);
                startActivity(intent1);
                finish();
            } else if (id == R.id.mechanical) {
                Intent intent1 = new Intent(this, Activity_mechanical.class);
                startActivity(intent1);
                finish();
            } else if (id == R.id.electrical) {
                Intent intent1 = new Intent(this, Activity_electrical.class);
                startActivity(intent1);
                finish();
            } else if (id == R.id.information) {
                Intent intent1 = new Intent(this, Activity_information.class);
                startActivity(intent1);
                finish();
            } else if (id == R.id.electronics) {
                Intent intent1 = new Intent(this, Activity_electronics.class);
                startActivity(intent1);
                finish();
            } else if (id == R.id.electronicandtc) {
                Intent intent1 = new Intent(this, Activity_elec_tele.class);
                startActivity(intent1);
                finish();
            } else if (id == R.id.about) {
                Intent intent1 = new Intent(this, Activity_about_us.class);
                startActivity(intent1);
                finish();
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {


            HttpHandler h1 = new HttpHandler();
            TAG = h1.makeServiceCall("http://rpi1.pe.hu/newsgrabber.php");
            try {
                JSONArray j1 = new JSONArray(TAG);



                    for (int i = 0; i < j1.length(); i++) {
                        dtoObject = new HomeDTO();

                        JSONObject e = j1.getJSONObject(i);

                        String TILE_NAME = e.getString("text");
                        String TILE_LINK = e.getString("link");

                        dtoObject.setTile_name(TILE_NAME);
                        dtoObject.setTile_link(TILE_LINK);

                        array[i] = TILE_LINK;

                        arrayDTO.add(dtoObject);


                    }


            } catch (JSONException e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            pb_home.setVisibility(View.GONE);
          //  tv_home.setText(TAG);
            Home_List_Adapter adapter=new Home_List_Adapter(arrayDTO,Activity_drawer_main.this);
            listView.setAdapter(adapter);

        }
    }
}
