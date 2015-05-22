package com.infinitable.charlescrain.infinitable2;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.Set;
import java.util.UUID;


public class MainActivity extends ActionBarActivity {

    //---Private Variables---//
    private Button sleep_button, games_button, demo_button, music_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //---Setup UI Buttons---//
        games_button = (Button) findViewById(R.id.games_b);
        music_button = (Button) findViewById(R.id.music_b);
        demo_button = (Button) findViewById(R.id.demo_b);
        sleep_button = (Button) findViewById(R.id.sleep_b);


        games_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Bluetooth.mmOutStream.write('1');
                } catch (Exception e){}
                Intent intent = new Intent(MainActivity.this,GamesActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
        music_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Bluetooth.mmOutStream.write('2');
                } catch (Exception e){}
                Intent intent = new Intent(MainActivity.this,MusicActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
        demo_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Bluetooth.mmOutStream.write('3');
                } catch (Exception e){
                    Log.e("BLuetooth App", "exception", e);
                }
                Intent intent = new Intent(MainActivity.this, DemoActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
        sleep_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Bluetooth.mmOutStream.write('4');
                } catch (Exception e){}

                Intent intent = new Intent(MainActivity.this,Sleep.class);
                MainActivity.this.startActivity(intent);
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
