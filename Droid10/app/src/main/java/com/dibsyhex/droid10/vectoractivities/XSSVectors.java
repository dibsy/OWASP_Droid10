package com.dibsyhex.droid10.vectoractivities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dibsyhex.droid10.R;
import com.dibsyhex.droid10.database.StorageHelper;

public class XSSVectors extends ActionBarActivity {
    private StorageHelper storageHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xssvectors);

        setup();

        Button read=(Button)findViewById(R.id.btn_viewxssvectors);
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                read();
            }
        });

        Button add=(Button)findViewById(R.id.btn_addxssvectors);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edttxt=(EditText)findViewById(R.id.edttxt_vector);
                String vector=edttxt.getText().toString();
                add(vector);


            }
        });

        Button delete=(Button)findViewById(R.id.btn_deletexssvectors);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editext=(EditText)findViewById(R.id.edttxt_id);
                int vectorID=Integer.parseInt(editext.getText().toString());
                delete(vectorID);

            }
        });



    }

    public void setup(){
        final String vectorID="vectorid";
        final String vectorName="vectorname";
        final String databaseName="Vectors";
        final String tableName="CrossSiteScriptingVectors";
        final String createQuery = "CREATE TABLE CrossSiteScriptingVectors(vectorid integer primary key autoincrement,vectorname text not null);";

        storageHelper=new StorageHelper(this,vectorID,vectorName,databaseName,tableName,createQuery);

    }

    public void add(String vector){
        try {
            //final StorageHelper storageHelper = new StorageHelper(this);
            storageHelper.insert(vector);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete(int id){
        try {
            //final StorageHelper storageHelper = new StorageHelper(this);
            storageHelper.delete(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void read() {
        try {
            //final StorageHelper storageHelper = new StorageHelper(this);
            Cursor c = storageHelper.retrieve();
            String s=new String();
            if (c.moveToFirst()) {
                do{
                    //Toast.makeText(this, c.getString(0) + " " + c.getString(1), Toast.LENGTH_LONG).show();
                    s=s+c.getString(0)+" "+c.getString(1)+"\n";
                }while (c.moveToNext());

                final AlertDialog.Builder aBuilder=new AlertDialog.Builder(this);
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
                Toast.makeText(this, "No vectors", Toast.LENGTH_LONG);
            }
        }catch (Exception e){
            Toast.makeText(this,e.toString(),Toast.LENGTH_LONG).show();
        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_xssvectors, menu);
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
