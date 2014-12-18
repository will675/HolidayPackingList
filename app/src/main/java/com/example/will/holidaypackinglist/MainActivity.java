package com.example.will.holidaypackinglist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    static int trudiCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        trudiCount = sharedPref.getInt("trudiCount", trudiCount);
        System.out.println("trudiCount = " + trudiCount);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_reset_all:
                resetAll();
                return true;
            case R.id.action_add_new_list:
                addNewList();
                return true;
            case R.id.action_settings:
                openSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void resetAll() {
        Context context = getApplicationContext();
        CharSequence text = "RESET ALL PRESSED!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    public void addNewList() {
        Context context = getApplicationContext();
        CharSequence text = "ADD NEW LIST PRESSED!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void openSettings() {
        Context context = getApplicationContext();
        CharSequence text = "OPEN SETTINGS PRESSED!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void showTrudiList(View view) {
        Intent intent = new Intent(this, TrudiListActivity.class);
        startActivity(intent);
    }

}
