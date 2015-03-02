package com.dibsyhex.droid10;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.dibsyhex.droid10.asynctask.LiveScanAsync;
import com.dibsyhex.droid10.interfaces.AsyncResponse;
import com.dibsyhex.droid10.vectoractivities.XSSVectors;
import com.dibsyhex.droid10.vectormodels.CrossSiteScriptingVectorModel;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
/*
    This activity is for the LiveScan Feature . This features allows the pentesters to select a vulnerability
    and scan them, and see the live results in WebView .

*/
public class LiveScanActivity extends ActionBarActivity implements AsyncResponse {

    private int vulnIndex;//stored the item index of the vulnerability list
    private EditText scanurl;//url to scan
    private TextView updateVectorHeading;
    private List<String>vectorList;//List of vectors
    private static int count=0;//count the vectors
    private int totalVectors;//total vectors in the list
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_scan);


        //Webview
        try {


            Button button=(Button)findViewById(R.id.qwee);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(LiveScanActivity.this,"SD",Toast.LENGTH_LONG).show();
                    selectScan();
                    vulnScan();

                }
            });

            //To update Vector heading
            updateVectorHeading = (TextView) findViewById(R.id.progress);


            //To select the type of vulnerability
            Spinner spinner = (Spinner) findViewById(R.id.spinner_vuln);


            //List of vulnerabilities . The first one has an index 0 ,second one has 1 ,and so on
            List<String> vulnlist = new ArrayList<String>();
            vulnlist.add("Cross Site Scripting");
            vulnlist.add("SQL Injection");
            vulnlist.add("Command Injection");
            vulnlist.add("File Inclusion");



            //ArrayAdapter to set the dislay list
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, vulnlist);
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(arrayAdapter);




            //Get the URL
            scanurl = (EditText) findViewById(R.id.edttxt_vulnurl);


            //Get the Type of vulnerability . Once the type is selected store the index in the vulIndex url which will be used to select the vuln scan option form a switch case
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    //Toast.makeText(LiveScanActivity.this, "Selected: " + position, Toast.LENGTH_LONG).show();
                    vulnIndex = position;
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });


            //Button for scan

            //selectScan()
            //Vulnscan



        }catch (Exception e){
            Log.e("ERROR",e.toString());
        }

    }


    private void selectScan() {
    /*
       This function is used to select the type of scan and call the required async task to carry out the work

    */
        switch (vulnIndex){
            case 0:
                vectorList = CrossSiteScriptingVectorModel.getVectorsList();
                totalVectors = vectorList.size();
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                vectorList=CrossSiteScriptingVectorModel.getVectorsList();

        }

    }

    public void vulnScan(){
        try {

            if(count == vectorList.size())
                count=0;

            String vector=vectorList.get(count);
            //Now URL Encode it
            vector= URLEncoder.encode(vector,"UTF-8");

            updateVectorHeading.setText("Trying vector "+"("+count+"/"+totalVectors+") "+vector);
            String url=scanurl.getText().toString()+vector;

            count++;

            //new LiveScanAsync(LiveScanActivity.this).execute(url);

            LiveScanAsync liveScanAsync=new LiveScanAsync(LiveScanActivity.this);
            liveScanAsync.delegate=this;

            liveScanAsync.execute(url);

        }catch (Exception e){
            Log.e("ERROR",e.toString());

        }
        /*

        */

    }

    @Override
    public void processFinish(String output) {
        try {
            Log.d("RES2",output);
            webView = (WebView) findViewById(R.id.webview_vuln);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            webView.setWebViewClient(new WebViewClient());
            webView.setWebChromeClient(new WebChromeClient());
            webView.loadUrl("about:blank");
            webView.loadData(output, "text/html", "UTF-8");
        }catch (Exception e){
            Log.e("ERROR",e.toString());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_live_scan, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
