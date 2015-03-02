package com.dibsyhex.droid10.asynctask;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;

import com.dibsyhex.droid10.interfaces.AsyncResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WHOIS on 02-03-2015.
 */
public class LiveScanAsync extends AsyncTask<String,Void,String> {
    private String response;//Response from the JSOUP request
    private Context context;//Application Context
    public AsyncResponse delegate=null;

    public LiveScanAsync(Context context){
        this.context=context;
        response="";
    }

    @Override
    protected  void onPreExecute(){
        super.onPreExecute();

    }

    @Override
    protected String doInBackground(String... params) {

        //Get the url
        String url=params[0];
        try {
            Document document = Jsoup.connect(url).timeout(0).get();
            response = document.toString();
            Log.d("RES",response);
        }catch (Exception e) {
                Log.e("ERROR",e.toString());
                response=e.toString();
        }
        return response;
    }

    protected void onPostExecute(String result) {
        // Set title into TextView
        //Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
        try {
            delegate.processFinish(result);
            Log.d("RESP",result);
        }catch (Exception e){
            Log.e("ERROR",e.toString());
        }


    }




}
