package com.example.shago_000.chess;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by shago_000 on 8/18/2015.
 */
public class board extends View implements GestureDetector.OnGestureListener {

    boolean right_cast=true;
    boolean left_cast=true;
    boolean update=true;
    static boolean checkmate=false;
    static boolean player_two=false;
    GestureDetector gestureDetector;
    game ob;
    Paint p3;
    int playeronecounter=0;
    int playertwocounter=0;
    boolean start1=true;
    boolean start = true;
    static boolean playerone = false;
    static boolean playertwo = false;
    Rect bor;
    static boolean mycheck=false;
    float border;
    float board_size;
    float grid_size;
    float space;
    static boolean call=false;
    float xcor;
    Main2Activity ref;
    float ycor;
    Paint p1;
    Bitmap bm;
    Paint p2;
    player pl;
    static Toast t1;
    static Toast t2;
    static Toast t3;
    static info grid[][]=new info[10][10];
    Bitmap btm[]=new Bitmap[14];
    Rect rec[][]=new Rect[9][9];
    public board(Context context) {
        super(context);
        gestureDetector=new GestureDetector(context,this);
        set_bitmap();
        pl=new player(this);
        ob = new game(this);
        t1=Toast.makeText(context,"Your Turn",Toast.LENGTH_LONG);
        t1.setGravity(Gravity.BOTTOM| Gravity.CENTER, 0, 10);
        t2=Toast.makeText(context,"Check",Toast.LENGTH_SHORT);
        t2.setGravity(Gravity.TOP|Gravity.CENTER,0,110);
        t3=Toast.makeText(context,"invalid move",Toast.LENGTH_SHORT);
        t3.setGravity(Gravity.TOP|Gravity.CENTER,0,110);
        if(playerone){
            t1.show();
        }
    }
    public void func(Main2Activity ob){
        ref=ob;
    }
    @Override
    protected void onDraw(Canvas canvas){
        if(start1){
            if(canvas.getHeight()>canvas.getWidth()){
                board_size=canvas.getWidth();
            }
            else{
                board_size=canvas.getHeight();
            }
            grid_size=board_size/8;
            space=canvas.getWidth()-(grid_size*8);
            space=space/2;
            border=grid_size/32;
            grid_size=grid_size-border;
            border=border*4;
            ycor=border;
            bor=new Rect();
            bor.set((int) space, 0, (int) (space + (grid_size * 8) + (border * 2)), (int) ((grid_size * 8) + (border * 2)));
            for(int i=1;i<=8;i++){
                xcor=space+border;
                for(int j=1;j<=8;j++){
                     rec[i][j]=new Rect();
                     rec[i][j].set((int)xcor,(int)ycor,(int)(xcor+grid_size),(int)(ycor+grid_size));
                     xcor=xcor+grid_size;
                }
                ycor=ycor+grid_size;
            }
            p1=new Paint();
            p2=new Paint();
            p3=new Paint();
            pl.set_player();
            p3.setColor(Color.parseColor("#4c2404"));
            start1=false;
            if(player_two){
                for(int i=1;i<=2;i++){
                    for(int j=1;j<=8;j++){
                        grid[i][j].col="white";
                    }
                }
                for(int i=7;i<=8;i++){
                    for(int j=1;j<=8;j++){
                        grid[i][j].col="black";
                    }
                }
            }
        }
        canvas.drawRect(bor,p3);
        for(int i=1;i<=8;i++){
            if(i%2==0){
                p1.setColor(Color.parseColor("#d3ba79"));
                p2.setColor(Color.parseColor("#9a5e22"));
            }
            else{
                p1.setColor(Color.parseColor("#9a5e22"));
                p2.setColor(Color.parseColor("#d3ba79"));
            }
            for(int j=1;j<=8;j=j+2){
                canvas.drawRect(rec[i][j],p1);
                canvas.drawRect(rec[i][j + 1], p2);
              synchronized (grid) {
                  if (grid[i][j].player != 0) {
                      get_bitmap(i, j);
                      canvas.drawBitmap(bm, null, rec[i][j], null);
                  }
                  if (grid[i][j + 1].player != 0) {
                      get_bitmap(i, j + 1);
                      canvas.drawBitmap(bm, null, rec[i][j + 1], null);
                  }
              }

            }
        }
        if(checkmate){
            ref.show_check_mate();
            update=false;
            playertwo=false;
            playerone=false;
        }
        if(call){
            ob.ob2.setcheck();
            call=false;
            ob.ob2.pass=true;
        }
        if(update) {
            invalidate();
        }
    }
    public void set_bitmap(){
        btm[1]=BitmapFactory.decodeResource(getResources(), R.drawable.whiteking);
        btm[2]=BitmapFactory.decodeResource(getResources(), R.drawable.whitequeen);
        btm[3]=BitmapFactory.decodeResource(getResources(), R.drawable.whiterook);
        btm[4]=BitmapFactory.decodeResource(getResources(), R.drawable.whiteknight);
        btm[5]=BitmapFactory.decodeResource(getResources(), R.drawable.whitebishop);
        btm[6]=BitmapFactory.decodeResource(getResources(), R.drawable.whitepawn);
        btm[7]=BitmapFactory.decodeResource(getResources(), R.drawable.blackking);
        btm[8]=BitmapFactory.decodeResource(getResources(), R.drawable.blackqueen);
        btm[9]=BitmapFactory.decodeResource(getResources(), R.drawable.blackrook);
        btm[10]=BitmapFactory.decodeResource(getResources(), R.drawable.blackknight);
        btm[11]=BitmapFactory.decodeResource(getResources(), R.drawable.blackbishop);
        btm[12]=BitmapFactory.decodeResource(getResources(), R.drawable.blackpawn);
    }
    public void get_bitmap(int r,int c){
        if(grid[r][c].player==1){
            if(grid[r][c].col=="black"){
                bm=btm[7];
            }
            else{
                bm=btm[1];
            }
        }
        else if(grid[r][c].player==2){
            if(grid[r][c].col=="black"){
                bm=btm[8];
            }
            else{
                bm=btm[2];
            }
        }
        else if(grid[r][c].player==3){
            if(grid[r][c].col=="black"){
                bm=btm[11];
            }
            else{
                bm=btm[5];
            }
        }
        else if(grid[r][c].player==4){
            if(grid[r][c].col=="black"){
                bm=btm[10];
            }
            else{
                bm=btm[4];
            }
        }
        else if(grid[r][c].player==5){
            if(grid[r][c].col=="black"){
                bm=btm[9];
            }
            else{
                bm=btm[3];
            }
        }
        else if(grid[r][c].player==6){
            if(grid[r][c].col=="black"){
                bm=btm[12];
            }
            else{
                bm=btm[6];
            }
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event) ;
    }
    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return true;
    }
    @Override
    public void onShowPress(MotionEvent motionEvent) {}
    @Override
    public boolean onSingleTapUp(MotionEvent me) {
        if (start) {
            if (playerone){
                if (playeronecounter == 0) {
                    ob.move(0, me.getX(), me.getY());
                } else if (playeronecounter == 1) {
                    ob.move(1, me.getX(), me.getY());
                }
            } else if (playertwo) {
                if (playertwocounter == 0) {
                    ob.move(0, me.getX(), me.getY());
                } else if (playertwocounter == 1) {
                    ob.move(1, me.getX(), me.getY());
                }
            }
        }
        return true;
    }
    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }
    @Override
    public void onLongPress(MotionEvent motionEvent) {}
    @Override
    public boolean onFling(MotionEvent me1, MotionEvent me2, float v1, float v2) {
        if(right_cast){
            if(grid[8][6].player==0&&grid[8][7].player==0&&grid[8][8].player==5){
                if(me1.getY()>grid[8][1].y1&&me2.getY()>grid[8][1].y1){
                    if(me1.getX()>grid[8][5].x1&&me1.getX()<grid[8][5].x2){
                        if(me2.getX()>grid[8][8].x1&&me2.getX()<grid[8][8].x2){
                            if(!mycheck){
                                if(playerone){
                                    boolean flag=false;
                                    grid[8][5].player=0;
                                    grid[8][5].col="nil";
                                    grid[8][7].player=1;
                                    grid[8][7].col="white";
                                    for(int i=1;i<=8;i++){
                                        for(int j=1;j<=8;j++){
                                            if(grid[i][j].col=="black"){
                                                flag=ob.ob2.ob2.cm(i,j,"black",grid[i][j].player,false);
                                            }
                                            if(flag){
                                                break;
                                            }
                                        }
                                        if(flag){
                                            break;
                                        }
                                    }
                                    if(flag){
                                        grid[8][5].player=1;
                                        grid[8][5].col="white";
                                        grid[8][7].player=0;
                                        grid[8][7].col="nil";
                                    }
                                    else{
                                        grid[8][7].player=1;
                                        grid[8][7].col="white";
                                        grid[8][8].player=0;
                                        grid[8][8].col="nil";
                                        grid[8][6].player=5;
                                        grid[8][6].col="white";
                                        ob.col="white";
                                        ob.player=5;
                                        ob.ob2.setcheck();
                                    }
                                }
                                else if(playertwo){
                                    boolean flag=false;
                                    grid[8][5].player=0;
                                    grid[8][5].col="nil";
                                    grid[8][7].player=1;
                                    grid[8][7].col="black";
                                    for(int i=1;i<=8;i++){
                                        for(int j=1;j<=8;j++){
                                            if(grid[i][j].col=="white"){
                                                flag=ob.ob2.ob2.cm(i,j,"white",grid[i][j].player,false);
                                            }
                                            if(flag){
                                                break;
                                            }
                                        }
                                        if(flag){
                                            break;
                                        }
                                    }
                                    if(flag){
                                        grid[8][5].player=1;
                                        grid[8][5].col="black";
                                        grid[8][7].player=0;
                                        grid[8][7].col="nil";
                                    }
                                    else{
                                        grid[8][7].player=1;
                                        grid[8][7].col="black";
                                        grid[8][8].player=0;
                                        grid[8][8].col="nil";
                                        grid[8][6].player=5;
                                        grid[8][6].col="black";
                                        ob.col="black";
                                        ob.player=5;
                                        ob.ob2.setcheck();
                                    }
                                }

                            }
                        }
                    }

                }
            }
        }
        if(left_cast){
            if(grid[8][2].player==0&&grid[8][3].player==0&&grid[8][4].player==0&&grid[8][1].player==5){
                if(me1.getY()>grid[8][1].y1&&me2.getY()>grid[8][1].y1){
                    if(me1.getX()>grid[8][5].x1&&me1.getX()<grid[8][5].x2){
                        if(me2.getX()>grid[8][1].x1&&me2.getX()<grid[8][1].x2){
                            if(!mycheck){
                                if(playerone){
                                    boolean flag=false;
                                    grid[8][5].player=0;
                                    grid[8][5].col="nil";
                                    grid[8][3].player=1;
                                    grid[8][3].col="white";
                                    for(int i=1;i<=8;i++){
                                        for(int j=1;j<=8;j++){
                                            if(grid[i][j].col=="black"){
                                                flag=ob.ob2.ob2.cm(i,j,"black",grid[i][j].player,false);
                                            }
                                            if(flag){
                                                break;
                                            }
                                        }
                                        if(flag){
                                            break;
                                        }
                                    }
                                    if(flag){
                                        grid[8][5].player=1;
                                        grid[8][5].col="white";
                                        grid[8][3].player=0;
                                        grid[8][3].col="nil";
                                    }
                                    else{
                                        grid[8][3].player=1;
                                        grid[8][3].col="white";
                                        grid[8][1].player=0;
                                        grid[8][1].col="nil";
                                        grid[8][4].player=5;
                                        grid[8][4].col="white";
                                        ob.col="white";
                                        ob.player=5;
                                        ob.ob2.setcheck();
                                    }
                                }
                                else if(playertwo){
                                    boolean flag=false;
                                    grid[8][5].player=0;
                                    grid[8][5].col="nil";
                                    grid[8][3].player=1;
                                    grid[8][3].col="black";
                                    for(int i=1;i<=8;i++){
                                        for(int j=1;j<=8;j++){
                                            if(grid[i][j].col=="white"){
                                                flag=ob.ob2.ob2.cm(i,j,"white",grid[i][j].player,false);
                                            }
                                            if(flag){
                                                break;
                                            }
                                        }
                                        if(flag){
                                            break;
                                        }
                                    }
                                    if(flag){
                                        grid[8][5].player=1;
                                        grid[8][5].col="black";
                                        grid[8][3].player=0;
                                        grid[8][3].col="nil";
                                    }
                                    else{
                                        grid[8][3].player=1;
                                        grid[8][3].col="black";
                                        grid[8][1].player=0;
                                        grid[8][1].col="nil";
                                        grid[8][4].player=5;
                                        grid[8][4].col="black";
                                        ob.col="black";
                                        ob.player=5;
                                        ob.ob2.setcheck();
                                    }
                                }

                            }
                        }
                    }

                }
            }
        }
        return true;
    }
}