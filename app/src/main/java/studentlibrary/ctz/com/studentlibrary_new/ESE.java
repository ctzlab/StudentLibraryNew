package studentlibrary.ctz.com.studentlibrary_new;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import studentlibrary.ctz.com.studentlibrary_new.R;


public class ESE extends Fragment{


    String COURSE_CODE,Activity_code;
    private String TAG = Result_Main.class.getSimpleName();
    private ProgressDialog pDialog;
    private ListView lv;
    int size;
    private static String url;
    ArrayList<HashMap<String, String>> contactList;
    String array[]=new String[100];
    public ESE() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Result_Main activity = (Result_Main)getActivity();
        url="http://rpi1.pe.hu/getfile.php?refno=";
        COURSE_CODE = activity.COURSE_CODE;
        Activity_code= activity.Activity_code;
        url=url.concat(COURSE_CODE);
        url=url.concat("&type=3");
        contactList = new ArrayList<>();
        new GetContacts().execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.layout_fragment_ese,container,false);
        lv = (ListView) rootView.findViewById(R.id.list1);
        return rootView;
    }





    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(getActivity());
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {

                    JSONArray contacts = new JSONArray(jsonStr);

                    // looping through All Contacts
                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);

                        //  String id = c.getString("id");
                        String name = c.getString("name");
                        String link = c.getString("link");
                        String year = c.getString("year");
                        String by = c.getString("uploadby");

                        size=name.length();

                        // tmp hash map for single contact
                        HashMap<String, String> contact = new HashMap<>();

                        // adding each child node to HashMap key => value
                        //  contact.put("id", id);
                        contact.put("name", (i+1)+". "+name.substring(0,size - 8).replace('_',' ').replaceFirst("E ","ESE_").replace('-',' '));
                        contact.put("link", link);
                        contact.put("year", year);
                        contact.put("by",by);
                        array[i] = link;
                        // adding contact to contact list
                        contactList.add(contact);
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());

                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");


            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */
            ListAdapter adapter = new SimpleAdapter(
                    getActivity(), contactList,
                    R.layout.list_item, new String[]{"name",
                    "year","by"}, new int[]{R.id.name,
                    R.id.year,R.id.by});

            lv.setAdapter(adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent=new Intent(getActivity(),Activity_webview.class);
                    intent.putExtra("LINK",array[position]);
                    intent.putExtra("course_code",COURSE_CODE);
                    intent.putExtra("activity_code",Activity_code);
                    startActivity(intent);
                }
            });
        }

    }

}