package com.dibsyhex.droid10;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dibsyhex.droid10.appscanner.CrossSiteScriptingScan;
import com.dibsyhex.droid10.asynctask.CrossSiteScriptingAsync;


public class CrossSiteScriptingScanActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cross_site_scripting_scan);

        Button btn_hack=(Button)findViewById(R.id.btn_hack);
        btn_hack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edittxtUrl=(EditText)findViewById(R.id.url);//added
                //new XSSAsync(AppScan.this).execute(url.getText().toString(),element.getText().toString());
                String url=edittxtUrl.getText().toString();
                new CrossSiteScriptingAsync(CrossSiteScriptingScanActivity.this).execute(url);

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cross_site_scripting_scan, menu);
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
