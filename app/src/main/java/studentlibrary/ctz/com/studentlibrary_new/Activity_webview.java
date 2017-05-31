package studentlibrary.ctz.com.studentlibrary_new;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class Activity_webview extends AppCompatActivity {
    String pdf_link,code,actv;
    WebView webView;
    ProgressDialog pd;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        pd = new ProgressDialog(Activity_webview.this);
        pd.setMessage("Loading. Please wait...");
        pd.setCancelable(false);

        //  getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        final Activity activity = this;

        pdf_link = getIntent().getExtras().getString("LINK", "");
        code = getIntent().getExtras().getString("course_code", "");
        actv = getIntent().getExtras().getString("activity_code", "");
        webView = new WebView(Activity_webview.this);
        webView.getSettings().setJavaScriptEnabled(true);

        webView.setWebViewClient(new Callback());


            pd.show();
            webView.loadUrl(pdf_link);

        setContentView(webView);


        webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                if (progress < 90) {
                    pd.setMessage("Loading. Please wait... (" + String.valueOf(progress) + " %)");
                } else {
                    pd.dismiss();
                }
            }
        });


    }



    private class Callback extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(
                WebView view, String url) {
            return(false);
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Activity_webview.this,Activity_Result.class);
      //  intent.putExtra("LINK",pdf_link);
        intent.putExtra("course_code",code);
        intent.putExtra("activity_code",actv);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.download) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(pdf_link));
            startActivity(browserIntent);
            return true;
        }

        Intent intent=new Intent(Activity_webview.this,Activity_Result.class);
        intent.putExtra("course_code",code);
        intent.putExtra("activity_code",actv);
        startActivity(intent);
        finish();
        return true;

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.webview_menu, menu);
        return true;
    }



}
