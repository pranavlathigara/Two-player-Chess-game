package com.example.shago_000.chess;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import org.w3c.dom.Text;

import java.io.IOException;

public class MainActivity extends Activity {
    Button br1;
    Button br2;
    String str;
    TCPServer ref1;
    TCPClient ref2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        ref1=new TCPServer(this);
        ref2=new TCPClient(this);
        br1=(Button)findViewById(R.id.button);
        br1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    ref1.create();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
        br2=(Button)findViewById(R.id.button2);
        br2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                final AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setCancelable(false);
                final EditText edittext= new EditText(getApplicationContext());
                edittext.setTextColor(Color.BLACK);
                alert.setMessage("Enter the IP address to connect");
                alert.setTitle("IP Address");
                alert.setView(edittext);
                alert.setPositiveButton("Connect", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        str= edittext.getText().toString();
                        try {
                            ref2.create();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {}
                });
                alert.show();
            }
        });
    }
    public void set_dialogue(){
        Intent intent=new Intent(getApplicationContext(), Main2Activity.class);
        startActivity(intent);
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