package com.dibsyhex.droid10.appscanner;

/**
 * Cross Site Scripting Scan
 */

import android.content.Context;
import android.util.Log;

import com.dibsyhex.droid10.database.StorageHelper;
import com.dibsyhex.droid10.vectoractivities.XSSVectors;
import com.dibsyhex.droid10.vectormodels.CrossSiteScriptingVectorModel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.List;


public class CrossSiteScriptingScan {
    private boolean vulnerable;
    private String url;
    private String response="";
    private String vectors[]={
            "<script>alert(1);</script>",
            "<img src=x onerror=alert(1)>"

    };



    public void scanXSS(String u){
        try {

           CrossSiteScriptingVectorModel crossSiteScriptingVectorModel=CrossSiteScriptingVectorModel.getInstance();
           List<String>vectorList=crossSiteScriptingVectorModel.getVectorsList();




            for (String v : vectorList) {
                System.out.println(v);
                //String url = "http://localhost:8080/VulnWeb/XssScan?search=" + v;
                String url = u + v;
                Document doc = Jsoup.connect(url).get();
                //Element result = doc.getElementById(el);// e is the element
                String output = doc.toString();
                //System.out.println(output);

                if (output.indexOf(v) >= 0) {
                    vulnerable = true;
                    //System.out.println("XSS : PoC : "+v);
                    response = "XSS : PoC : " + v;
                    break;
                }
            }
        }catch (Exception e){
            Log.e("ERROR","scanXSS()"+e.toString());
        }
    }

    public boolean isVulnerable(){
        return vulnerable;
    }

    public String getResponse(){
        return response;
    }

}
