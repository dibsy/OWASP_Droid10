package com.dibsyhex.droid10.asynctask;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;

import com.dibsyhex.droid10.appscanner.CrossSiteScriptingScan;


/**
 * Created by WHOIS on 30-01-2015.
 */
public class CrossSiteScriptingAsync extends AsyncTask<String,Void,Void> {
    private String response;
    private Context context;
    private ProgressDialog progressDialog;
    public CrossSiteScriptingAsync(Context context) {
        this.context=context;

        response="";


    }


    @Override
    protected  void onPreExecute(){
        super.onPreExecute();
        progressDialog=new ProgressDialog(context);
        progressDialog.setTitle("Scanning for XSS");
        progressDialog.setMessage("Scanning..");
        progressDialog.setIndeterminate(false);
        progressDialog.show();
    }

    @Override
    protected Void doInBackground(String... params) {

        CrossSiteScriptingScan crossSiteScriptingScan =new CrossSiteScriptingScan();
        String url=params[0];


        crossSiteScriptingScan.scanXSS(url);
        if(crossSiteScriptingScan.isVulnerable()){
            response= crossSiteScriptingScan.getResponse();
        }else{
            response= crossSiteScriptingScan.getResponse();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        // Set title into TextView
        //Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
        progressDialog.dismiss();


        final AlertDialog.Builder aBuilder=new AlertDialog.Builder(context);
        aBuilder.setTitle("Scan Result");
        aBuilder.setMessage(response);
        aBuilder.setNegativeButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alertDialog=aBuilder.create();
        alertDialog.show();




    }
}

