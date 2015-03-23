package com.ich.plassa.mysettingsapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    public int age;
    public static final int REQUEST_RESULT = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        age = -1;
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
        //if (id == R.id.action_settings) {
        //        return true;
        // }

        if (id == R.id.miRequest) {
            Toast.makeText(this, "Clicked",
                   Toast.LENGTH_SHORT).show();
            // Navigate to the new activity
            // Create your intent
            Intent i = new Intent(this, RequestActivity.class);
            // Bundle "extra"
            i.putExtra("age", age);
            // Run the startActivity
            startActivityForResult(i, REQUEST_RESULT);
                // Pass the current value

        }

        return super.onOptionsItemSelected(item);
    }

    /// Fires automatically when "form data" is posted
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Handle the form data
        if (requestCode == REQUEST_RESULT) {
            if (resultCode == RESULT_OK) {
                // Toast YES or NO based on if age is greater than 21
                // Get the age out of the form data
                age = data.getIntExtra("age", -1);
                // Check the age
                String message;
                if (age >= 21) {
                    message = "DRINK UP!";
                } else {
                    message = "NONE FOR YOU!";
                }
                // Toast
                Toast.makeText(this, message,Toast.LENGTH_SHORT).show();
            }
        }
    }
}
