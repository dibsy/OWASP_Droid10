package com.dibsyhex.droid10.vectormodels;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by WHOIS on 06-03-2015.
 */
public class ServerSideIncludeVectorModel {
    private static ServerSideIncludeVectorModel serverSideIncludeVectorModel=new ServerSideIncludeVectorModel();

    private ServerSideIncludeVectorModel(){

    }

    private static final String[]serverSideIncludeVectors=new String []{
            "<!--#exec cmd=\"ls\" -->",
            "<!--#include virtual=\"/etc/passwd\" -->",
            "<!--#echo var=\"DOCUMENT_URI\" -->",
            "<!--#echo var=\"DOCUMENT_NAME\" -->",
            "<!--#printenv -->",
            "<!--#fsize file=\"index.html\" -->"
    };

    public static ServerSideIncludeVectorModel getInstance(){
        return serverSideIncludeVectorModel;
    }

    public static List getVectorsList(){
        List<String>vectorsList=null;
        try{
            List<String>list=Arrays.asList(serverSideIncludeVectors);
            vectorsList=new ArrayList<String>(list);

        }catch (Exception e){
            Log.e("ERROR", "getVectorList():" + e.toString());
        }


        return vectorsList;
    }


    public static List getUserDefinedVectorList(){
        List<String>vectorsList=new ArrayList<String>();

        return vectorsList;
    }

    public static List getInbuiltVectorList(){
        List<String>vectorsList=new ArrayList<String>();

        return vectorsList;
    }

}
