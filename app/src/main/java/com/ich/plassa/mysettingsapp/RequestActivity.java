package com.ich.plassa.mysettingsapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class RequestActivity extends ActionBarActivity {
    EditText etAge;
    RequestModel request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        // Find the edit text
        etAge = (EditText) findViewById(R.id.etAge);
        // Get the extra
        request = (RequestModel) getIntent().getSerializableExtra("request");

        // put the extra into the edit text
        etAge.setText(String.valueOf(request.age));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_request, menu);
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


    public void onRequest(View view) {
        // Set the form data
        // Get the edit text value
        request.age = Integer.parseInt(etAge.getText().toString());
        // Create an intent
        Intent i = new Intent();
        // Set the value in the intent
        i.putExtra("request", request);
        // Set the result
        setResult(RESULT_OK, i);
        // Dismiss this screen
        this.finish();  // "this." optional
    }
}
