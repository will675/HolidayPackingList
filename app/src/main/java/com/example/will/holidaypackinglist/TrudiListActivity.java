package com.example.will.holidaypackinglist;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;


public class TrudiListActivity extends ActionBarActivity {

    public int trudiCount = 0;
    public boolean trudiClothes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trudi_list);
     }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_trudi_list, menu);
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

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        System.out.println(checked);
        // Create object of SharedPreferences.
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        //now get Editor
        SharedPreferences.Editor editor = sharedPref.edit();

        if (checked) {
            trudiCount++;
            editor.putBoolean("trudiClothes", true);
            editor.commit();
            System.out.println(sharedPref.getBoolean("trudiClothes", trudiClothes));
            System.out.println("count added " + trudiCount);
        }
        else {
            trudiCount--;
            System.out.println("count reduced " + trudiCount);
        }
        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.checkbox_clothes:
                if (checked)
                    System.out.println("clothes selected");
                break;
            case R.id.checkbox_shoes:
                if (checked)
                    System.out.println("shoes selected");
                break;
            //TODO add use of saving to an activity level sharedpreference = http://developer.android.com/training/basics/data-storage/shared-preferences.html
        }
        //put your value
        editor.putInt("trudiCount", trudiCount);
        System.out.println("trudiCount =" + trudiCount);
        //commits your edits
        editor.commit();
    }


}
