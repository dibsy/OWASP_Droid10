package com.dibsyhex.droid10.asynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.dibsyhex.droid10.interfaces.AsyncResponse;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by WHOIS on 08-03-2015.
 */
public class RepeaterAsync extends AsyncTask<String,Void,String> {
    private String response;//Response from the JSOUP request
    private Context context;//Application Context
    public AsyncResponse delegate=null;

    public RepeaterAsync(Context context){
        this.context=context;
        response="";
    }

    @Override
    protected  void onPreExecute(){
        super.onPreExecute();

    }



    @Override
    protected String doInBackground(String... params) {
        String url=params[0];
        response="";
        Map<String, List<String>>headers;

        try {
            if(url.indexOf("https")>=0){
                headers=httpsConnection(url);
            }else {
                headers=httpConnection(url);
            }
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                response=response+entry.getKey()+":" + entry.getValue()+"\n";
            }

            return response;

        }catch (Exception e){
            Log.e("ERROR","Error in doInBackground():"+e.toString());
            return response;
        }

    }

    protected Map<String, List<String>> httpConnection(String url){
        Map<String, List<String>>headers=null;
        try{
            URL urlobj = new URL(url);
            HttpURLConnection con = (HttpURLConnection)urlobj.openConnection();
            headers=con.getHeaderFields();
            Log.d("RES",headers.toString());
            return  headers;
        }catch (Exception e){
            Log.e("ERROR","Error in httpsConnection():"+e.toString());
            return headers;
        }
    }

    protected Map<String, List<String>> httpsConnection(String url){

        Map<String, List<String>>headers=null;
        try{
            URL urlobj = new URL(url);
            HttpsURLConnection con = (HttpsURLConnection)urlobj.openConnection();
            headers=con.getHeaderFields();
            Log.d("RES",headers.toString());
            return  headers;
        }catch (Exception e){
            Log.e("ERROR","Error in httpsConnection():"+e.toString());
            return headers;
        }
    }






    protected void onPostExecute(String result) {
        // Set title into TextView
        //Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
        try {
            delegate.processFinish(result);
            Log.d("RESULT", result);
        }catch (Exception e){
            Log.e("ERROR",e.toString());
        }


    }




}
