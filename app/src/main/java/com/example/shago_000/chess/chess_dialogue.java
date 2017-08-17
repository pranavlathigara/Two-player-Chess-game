package com.example.shago_000.chess;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class chess_dialogue extends Activity {
    ArrayList<String> str=new ArrayList<>();
    ListView list;
    boolean Stop=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFinishOnTouchOutside(false);
        this.
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_chess_dialogue);
        list= (ListView) findViewById(R.id.listview);
        if(game2.total_player[2]==0){
            str.add("Queen");
        }
        if(game2.total_player[3]<2){
            str.add("Bishop");
        }
        if(game2.total_player[4]<2){
            str.add("Knight");
        }
        if(game2.total_player[5]<2){
            str.add("Rook");
        }
        String title[]=new String[str.size()];
        int res[]=new int[str.size()];
        for(int i=0;i<str.size();i++){
            title[i]=str.get(i);
            if(str.get(i)=="Queen"){
                if(board.playerone){
                    res[i]=R.drawable.whitequeen;
                }
                else{
                    res[i]=R.drawable.blackqueen;
                }
            }
           else if(str.get(i)=="Bishop"){
                if(board.playerone){
                    res[i]=R.drawable.whitebishop;
                }
                else{
                    res[i]=R.drawable.blackbishop;
                }
            }
           else if(str.get(i)=="Knight"){
                if(board.playerone){
                    res[i]=R.drawable.whiteknight;
                }
                else{
                    res[i]=R.drawable.blackknight;
                }
            }
           else if(str.get(i)=="Rook"){
                if(board.playerone){
                    res[i]=R.drawable.whiterook;
                }
                else{
                    res[i]=R.drawable.blackrook;
                }
            }
        }
        customadapter adp=new customadapter(this,title,res);
        list.setAdapter(adp);
        list.setClickable(true);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
               String tc=(String) list.getItemAtPosition(position);
                     if(tc=="Queen"){
                         board.grid[1][game2.pawncol].player=2;
                     }
                     else if(tc=="Bishop"){
                         board.grid[1][game2.pawncol].player=3;
                     }
                     else if(tc=="Knight"){
                         board.grid[1][game2.pawncol].player=4;
                     }
                     else if(tc=="Rook"){
                         board.grid[1][game2.pawncol].player=5;
                     }
                    board.call=true;
                    Stop=true;
                    finish();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chess_dialogue, menu);
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
    @Override
    protected void onStop() {
        if(Stop){
            super.onStop();
        }
        else{
            Toast toast=Toast.makeText(this,"select any player",Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}