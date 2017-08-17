package com.example.shago_000.chess;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;

public class Main2Activity extends Activity {
    board ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        LinearLayout ll=(LinearLayout)findViewById(R.id.layout2);
        ref=new board(ll.getContext());
        ref.func(this);
        ll.addView(ref);
    }
    public void dialogue(){
        Intent intent=new Intent(getApplicationContext(),chess_dialogue.class);
        startActivity(intent);
    }
    public void show_check_mate(){
        final AlertDialog.Builder alert = new AlertDialog.Builder(Main2Activity.this);
        final TextView tx= new TextView(getApplicationContext());
        tx.setTextColor(Color.BLACK);
        tx.setGravity(Gravity.CENTER);
        if(board.checkmate) {
            tx.setText("YOU LOST!");
        }
        else{
            tx.setText("YOU WON!");
        }
        tx.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
        alert.setCancelable(true);
        alert.setMessage("CheckMate");
        alert.setTitle("");
        alert.setView(tx);
        alert.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
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
