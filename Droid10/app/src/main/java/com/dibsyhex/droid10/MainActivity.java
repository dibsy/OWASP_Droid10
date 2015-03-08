package com.dibsyhex.droid10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Intitalize the database

        //Scan Button
        Button btn_scan=(Button)findViewById(R.id.btn_scan);
        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scan_intent=new Intent(MainActivity.this,ScanActivity.class);
                MainActivity.this.startActivity(scan_intent);
            }
        });


        //Live Scan Button
        Button btn_livescan=(Button)findViewById(R.id.btn_livescan);
        btn_livescan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent livescan_inten=new Intent(MainActivity.this,LiveScanActivity.class);
                MainActivity.this.startActivity(livescan_inten);
            }
        });


        //Credits Button
        Button btn_credits=(Button)findViewById(R.id.btn_credits);
        btn_credits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent credits_intent=new Intent(MainActivity.this,CreditsActivity.class);
                MainActivity.this.startActivity(credits_intent);
            }
        });


        //About Button
        Button btn_about=(Button)findViewById(R.id.btn_about);
        btn_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent about_intent=new Intent(MainActivity.this,About.class);
                MainActivity.this.startActivity(about_intent);
            }
        });


        //Vector Button
        Button btn_vector=(Button)findViewById(R.id.btn_vectors);
        btn_vector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vector_intent=new Intent(MainActivity.this,VectorActivity.class);
                MainActivity.this.startActivity(vector_intent);
            }
        });

        //Repeater Button
        Button btn_repeater=(Button)findViewById(R.id.btn_repeater);
        btn_repeater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repeater_intent=new Intent(MainActivity.this,RepeaterActivity.class);
                MainActivity.this.startActivity(repeater_intent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
