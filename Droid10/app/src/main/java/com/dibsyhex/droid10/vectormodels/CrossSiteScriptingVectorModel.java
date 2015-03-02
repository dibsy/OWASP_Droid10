package com.dibsyhex.droid10.vectormodels;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.util.Log;
import android.widget.Toast;

import com.dibsyhex.droid10.database.StorageHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by WHOIS on 27-02-2015.
 */
public class CrossSiteScriptingVectorModel {
    private StorageHelper storageHelper;
    private static CrossSiteScriptingVectorModel crossSiteScriptingVectorModel=new CrossSiteScriptingVectorModel();
    private static final String[]crossSiteScriptingVectors=new String []{
            "<script>alert(1);</script>",
            "<img src=x onerror=alert(1)>",
            "\"><img src=x onerror=alert(1)>",
            "\"\"><img%20src=x>"
    };


    public void setup(Context context){
        final String vectorID="vectorid";
        final String vectorName="vectorname";
        final String databaseName="Vectors";
        final String tableName="CrossSiteScriptingVectors";
        final String createQuery = "CREATE TABLE CrossSiteScriptingVectors(vectorid integer primary key autoincrement,vectorname text not null);";

        storageHelper=new StorageHelper(context,vectorID,vectorName,databaseName,tableName,createQuery);

    }

    private CrossSiteScriptingVectorModel(){

    }

    public static CrossSiteScriptingVectorModel getInstance(){
        return crossSiteScriptingVectorModel;
    }



    public void add(String vector){
        try {
            //final StorageHelper storageHelper = new StorageHelper(this);
            storageHelper.insert(vector);
        }catch (Exception e){
            Log.e("ERROR","add()"+e.toString());

        }
    }

    public void delete(int id){
        try {
            //final StorageHelper storageHelper = new StorageHelper(this);
            storageHelper.delete(id);
        }catch (Exception e){
            Log.e("ERROR","delete()"+e.toString());
        }
    }

    public void read(Context context) {
        try {
            //final StorageHelper storageHelper = new StorageHelper(this);
            Cursor c = storageHelper.retrieve();
            String s=new String();
            if (c.moveToFirst()) {
                do{
                    //Toast.makeText(this, c.getString(0) + " " + c.getString(1), Toast.LENGTH_LONG).show();
                    s=s+c.getString(0)+" "+c.getString(1)+"\n";
                }while (c.moveToNext());

                final AlertDialog.Builder aBuilder=new AlertDialog.Builder(context);
                aBuilder.setTitle("XSS Vectors");
                aBuilder.setMessage(s);
                aBuilder.setNegativeButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog alertDialog=aBuilder.create();
                alertDialog.show();


            }else {

            }
        }catch (Exception e){
            Log.e("ERROR","read():"+e.toString());
        }

    }

    public static List getVectorsList(){
        List<String>vectorsList=new ArrayList<String>();
        try{
           vectorsList= Arrays.asList(crossSiteScriptingVectors);

        }catch (Exception e){
            Log.e("ERROR","getVectorList():"+e.toString());
        }


        return vectorsList;
    }

    public StorageHelper getStorageHelper(){
        return storageHelper;
    }

}
