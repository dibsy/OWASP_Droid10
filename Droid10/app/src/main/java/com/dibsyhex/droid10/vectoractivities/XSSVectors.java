package com.dibsyhex.droid10.vectoractivities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dibsyhex.droid10.R;
import com.dibsyhex.droid10.database.StorageHelper;
import com.dibsyhex.droid10.vectormodels.CrossSiteScriptingVectorModel;

import java.util.ArrayList;
import java.util.List;

public class XSSVectors extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xssvectors);

        final CrossSiteScriptingVectorModel crossSiteScriptingVectorModel=CrossSiteScriptingVectorModel.getInstance();

        crossSiteScriptingVectorModel.setup(XSSVectors.this);
        crossSiteScriptingVectorModel.preload();

        Button read=(Button)findViewById(R.id.btn_viewxssvectors);
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crossSiteScriptingVectorModel.read(XSSVectors.this);
            }
        });

        Button add=(Button)findViewById(R.id.btn_addxssvectors);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edttxt=(EditText)findViewById(R.id.edttxt_vector);
                String vector=edttxt.getText().toString();
                crossSiteScriptingVectorModel.add(vector);


            }
        });

        Button delete=(Button)findViewById(R.id.btn_deletexssvectors);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editext=(EditText)findViewById(R.id.edttxt_id);
                int vectorID=Integer.parseInt(editext.getText().toString());
                crossSiteScriptingVectorModel.delete(vectorID);

            }
        });



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
