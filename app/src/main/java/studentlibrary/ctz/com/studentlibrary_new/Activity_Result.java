package studentlibrary.ctz.com.studentlibrary_new;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import studentlibrary.ctz.com.studentlibrary_new.Adapter.DTO;
import studentlibrary.ctz.com.studentlibrary_new.Adapter.List_Adapter;

public class Activity_Result extends AppCompatActivity {
    String PDF_ID,PDF_REFNO,PDF_TYPE,PDF_NAME,PDF_LINK;
    AlertDialog.Builder builder;

    Context ctx;
    ListView listView;
    ArrayList<DTO> arrayDTO=new ArrayList<>();
    String COURSE_CODE,Activity_code;
    TextView tv1;
    String TAG;
    DTO dtoObject;
    int resultSize;
    String array[]=new String[100];
    WebView webView;
    ProgressDialog pd;
    LinearLayout ll_error;
    Button btn_goback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_result);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        COURSE_CODE=getIntent().getExtras().getString("course_code","CODE");
        Activity_code=getIntent().getExtras().getString("activity_code","");
        webView=(WebView)findViewById(R.id.downloader);

        ctx=getApplicationContext();
        tv1=(TextView)findViewById(R.id.resultTV);
        ll_error=(LinearLayout)findViewById(R.id.ll_result_error);
        btn_goback=(Button)findViewById(R.id.goback_button);
        ll_error.setVisibility(View.GONE);

        pd= new ProgressDialog(Activity_Result.this);
        pd.setMessage("Loading...");

        if (isNetAvailable()) {
            pd.show();
            new GetContacts().execute();
        } else {
            generate_alert();
        }





//        new GetContacts().execute();

        listView=(ListView)findViewById(R.id.listview_main);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(Activity_Result.this,Activity_webview.class);
                intent.putExtra("LINK",array[position]);
                intent.putExtra("course_code",COURSE_CODE);
                intent.putExtra("activity_code",Activity_code);
                startActivity(intent);
                finish();


            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

//                Intent i = new Intent();
//                i.setAction(Intent.ACTION_SEND);
//                i.putExtra(Intent.EXTRA_TEXT, array[position]);
//                i.setType("text/plain");                                                                                            //Important Area
//                startActivity(Intent.createChooser(i, "Share document via..."));

                webView.loadUrl(array[position]);
                return true;
            }
        });

        btn_goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();
            }
        });


    }



    private void generate_alert() {

        builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Please review your network");
        builder.setTitle("Alert");
        builder.setPositiveButton("Retry", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (isNetAvailable()) {
                    new GetContacts().execute();

                } else {
                    generate_alert();
                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                goBack();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    public void goBack() {
        if(Activity_code.equals("mech"))
        {
            Intent intent=new Intent(Activity_Result.this,Activity_mechanical.class);
            startActivity(intent);
            finish();
        }else if(Activity_code.equals("civil"))
        {
            Intent intent=new Intent(Activity_Result.this,Activity_civil_main.class);
            startActivity(intent);
            finish();
        }else if(Activity_code.equals("electrical"))
        {
            Intent intent=new Intent(Activity_Result.this,Activity_electrical.class);
            startActivity(intent);
            finish();
        }else if(Activity_code.equals("firstyear"))
        {
            Intent intent=new Intent(Activity_Result.this,Activity_firstYear.class);
            startActivity(intent);
            finish();
        }else if(Activity_code.equals("computer"))
        {
            Intent intent=new Intent(Activity_Result.this,Activity_computer.class);
            startActivity(intent);
            finish();
        }else if(Activity_code.equals("electronics"))
        {
            Intent intent=new Intent(Activity_Result.this,Activity_electronics.class);
            startActivity(intent);
            finish();
        }else if(Activity_code.equals("elec_tele"))
        {
            Intent intent=new Intent(Activity_Result.this,Activity_elec_tele.class);
            startActivity(intent);
            finish();
        }else if(Activity_code.equals("information"))
        {
            Intent intent=new Intent(Activity_Result.this,Activity_information.class);
            startActivity(intent);
            finish();
        }
    }


    private boolean isNetAvailable() {

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        return info != null && info.isConnected();
    }
    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {

            int j=1;

            HttpHandler h1 = new HttpHandler();
           TAG = h1.makeServiceCall("http://rpi1.pe.hu/getfile.php?refno="+COURSE_CODE+"&type=3");
           try {
               JSONArray j1=new JSONArray(TAG);
                resultSize=j1.length();

               if (TAG.equals("null"))
               {
                   dtoObject=new DTO();
                   dtoObject.setPdf_name("No Data Found");
                   arrayDTO.add(dtoObject);

               }
               else {
                   for (int i = 0; i < j1.length(); i++) {
                       dtoObject = new DTO();

                       JSONObject e = j1.getJSONObject(i);
                       String PDF_ID = e.getString("id");
                       String PDF_REFNO = e.getString("refno");
                       String PDF_TYPE = e.getString("type");
                       String PDF_NAME = e.getString("name");
                       String PDF_LINK = e.getString("link");

                       dtoObject.setPdf_name(PDF_NAME.toUpperCase());
                       dtoObject.setPdf_number(PDF_REFNO);
                       dtoObject.setPdf_type(PDF_TYPE);
                       dtoObject.setPdf_link(PDF_LINK);

                       array[i] = PDF_LINK;
                       arrayDTO.add(dtoObject);


                   }

               }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            pd.dismiss();
            List_Adapter adapter=new List_Adapter(arrayDTO,Activity_Result.this);
            listView.setAdapter(adapter);

            if (resultSize<=0){
                ll_error.setVisibility(View.VISIBLE);
            }

        }


    }

    @Override
    public void onBackPressed() {
        goBack();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(Activity_code.equals("mech"))
        {
            Intent intent=new Intent(Activity_Result.this,Activity_mechanical.class);
            startActivity(intent);
            finish();
        }else if(Activity_code.equals("civil"))
        {
            Intent intent=new Intent(Activity_Result.this,Activity_civil_main.class);
            startActivity(intent);
            finish();
        }else if(Activity_code.equals("electrical"))
        {
            Intent intent=new Intent(Activity_Result.this,Activity_electrical.class);
            startActivity(intent);
            finish();
        }else if(Activity_code.equals("firstyear"))
        {
            Intent intent=new Intent(Activity_Result.this,Activity_firstYear.class);
            startActivity(intent);
            finish();
        }else if(Activity_code.equals("computer"))
        {
            Intent intent=new Intent(Activity_Result.this,Activity_computer.class);
            startActivity(intent);
            finish();
        }else if(Activity_code.equals("electronics"))
        {
            Intent intent=new Intent(Activity_Result.this,Activity_electronics.class);
            startActivity(intent);
            finish();
        }else if(Activity_code.equals("elec_tele"))
        {
            Intent intent=new Intent(Activity_Result.this,Activity_elec_tele.class);
            startActivity(intent);
            finish();
        }else if(Activity_code.equals("information"))
        {
            Intent intent=new Intent(Activity_Result.this,Activity_information.class);
            startActivity(intent);
            finish();
        }
        return true;
    }
}
