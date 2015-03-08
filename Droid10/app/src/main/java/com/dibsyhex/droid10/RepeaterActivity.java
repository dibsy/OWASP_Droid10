package com.dibsyhex.droid10;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dibsyhex.droid10.asynctask.RepeaterAsync;
import com.dibsyhex.droid10.interfaces.AsyncResponse;


public class RepeaterActivity extends Activity implements AsyncResponse{

    private EditText editText_url;
    private EditText editText_response;
    private EditText editText_request;
    private Button button_fetch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repeater);

        editText_url=(EditText)findViewById(R.id.editext_repeaterurl);
        editText_request=(EditText)findViewById(R.id.editext_repeaterrequest);
        editText_response=(EditText)findViewById(R.id.editext_repeaterresponse);
        button_fetch=(Button)findViewById(R.id.button_request);

        button_fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    fetch();
                }catch (Exception e){
                    Log.e("ERROR", "Error in RepeaterActivity():" + e.toString());
                }
            }
        });






    }

    protected void fetch(){
        try{
            String url=editText_url.getText().toString();
            RepeaterAsync repeaterAsync=new RepeaterAsync(RepeaterActivity.this);
            repeaterAsync.delegate=this;
            repeaterAsync.execute(url);
        }catch (Exception e){
            Log.e("ERROR", "Error in fetch():" + e.toString());
        }
    }


    @Override
    public void processFinish(String output) {
        try{
            editText_response.setText(output);
        }catch (Exception e){
            Log.e("ERROR", "Error in RepeaterActivity():" + e.toString());
            editText_response.setText(e.toString());
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_repeater, menu);
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
