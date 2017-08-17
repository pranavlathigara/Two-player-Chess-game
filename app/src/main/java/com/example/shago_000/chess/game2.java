package com.example.shago_000.chess;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.widget.EditText;

import java.io.IOException;

/**
 * Created by shago_000 on 8/20/2015.
 */
public class game2 {
    static int total_player[]=new int[7];
    boolean check=false;
    boolean flag = false;
    boolean flag1 = false;
    board ob;
    boolean pass=true;
    game ob1;
    static int pawnrow;
    static int pawncol;
    check ob2;
    checkmate ob3;
    boolean checkmate=false;
    int tempplayer;
    String tempcol;
    int pawnfx[] = {-1, -1, -1, -2};
    int pawnfy[] = {1, -1, 0, 0};
    int knightfx[] = {-1, 1, -1, 1, -2, -2, 2, 2};
    int knightfy[] = {2, 2, -2, -2, 1, -1, 1, -1};
    int kingfx[] = {0, 0, -1, 1, -1, -1, 1, 1};
    int kingfy[] = {1, -1, 0, 0, 1, -1, 1, -1};
    int rookfx[] = {-1, -2, -3, -4, -5, -6, -7, 1, 2, 3, 4, 5, 6, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int rookfy[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, -1, -2, -3, -4, -5, -6, -7};
    int bishopfx[] = {-1, -2, -3, -4, -5, -6, -7, -1, -2, -3, -4, -5, -6, -7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7};
    int bishopfy[] = {1, 2, 3, 4, 5, 6, 7, -1, -2, -3, -4, -5, -6, -7, 1, 2, 3, 4, 5, 6, 7, -1, -2, -3, -4, -5, -6, -7};
    int queenfx[] = {-1, -2, -3, -4, -5, -6, -7, 1, 2, 3, 4, 5, 6, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -2, -3, -4, -5, -6, -7, -1, -2, -3, -4, -5, -6, -7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7};
    int queenfy[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, -1, -2, -3, -4, -5, -6, -7, 1, 2, 3, 4, 5, 6, 7, -1, -2, -3, -4, -5, -6, -7, 1, 2, 3, 4, 5, 6, 7, -1, -2, -3, -4, -5, -6, -7};
    static String state;
    game2(board ob5, game ob6) {
        ob = ob5;
        ob1 = ob6;
        ob2 = new check(ob, ob1, this);
        ob3 = new checkmate(ob2, this, ob);
    }
    public void edit() {
        int tx = 0, ty = 0;
        flag = true;
        if (ob1.player == 6) {
            for (int j = 0; j < 4; j++) {
                tx = ob1.dx + pawnfx[j];
                ty = ob1.dy + pawnfy[j];
                if ((tx >= 1 && tx <= 8) && (ty >= 1 && ty <= 8)) {
                    if ((ob1.x > ob.grid[tx][ty].x1 && ob1.x < ob.grid[tx][ty].x2) && (ob1.y > ob.grid[tx][ty].y1 && ob1.y < ob.grid[tx][ty].y2)) {
                        if (j == 3) {
                            if (!(ob1.dx==7)) {
                                break;
                            }
                        }
                        if (j <= 1 && ob.grid[tx][ty].player != 0) {
                            pawnrow=tx;
                            pawncol=ty;
                            set(tx, ty);
                            flag = false;
                            break;
                        } else if (j > 1 && ob.grid[tx][ty].player == 0) {
                            pawnrow=tx;
                            pawncol=ty;
                            set(tx, ty);
                            flag = false;
                            break;
                        }
                    }
                    if (j == 2 && ob.grid[tx][ty].player != 0) {
                        break;
                    }
                }
            }
        } else if (ob1.player == 4) {
            for (int j = 0; j < 8; j++) {
                tx = ob1.dx + knightfx[j];
                ty = ob1.dy + knightfy[j];
                if ((tx >= 1 && tx <= 8) && (ty >= 1 && ty <= 8)) {
                    if ((ob1.x > ob.grid[tx][ty].x1 && ob1.x < ob.grid[tx][ty].x2) && (ob1.y > ob.grid[tx][ty].y1 && ob1.y < ob.grid[tx][ty].y2)) {
                        set(tx, ty);
                        flag = false;
                        break;
                    }
                }
            }
        } else if (ob1.player == 1) {
            for (int j = 0; j < 8; j++) {
                tx = ob1.dx + kingfx[j];
                ty = ob1.dy + kingfy[j];
                if ((tx >= 1 && tx <= 8) && (ty >= 1 && ty <= 8)) {
                    if ((ob1.x > ob.grid[tx][ty].x1 && ob1.x < ob.grid[tx][ty].x2) && (ob1.y > ob.grid[tx][ty].y1 && ob1.y < ob.grid[tx][ty].y2)) {
                        set(tx, ty);
                        flag = false;
                        break;
                    }
                }
            }
        } else if (ob1.player == 5) {
            for (int j = 0; j < 28; j++) {
                tx = ob1.dx + rookfx[j];
                ty = ob1.dy + rookfy[j];
                if ((tx >= 1 && tx <= 8) && (ty >= 1 && ty <= 8)) {
                    if (ob.grid[tx][ty].player != 0) {
                        if (j < 6) {
                            j = 6;
                        } else if (j < 13) {
                            j = 13;
                        } else if (j < 20) {
                            j = 20;
                        } else if (j < 27) {
                            j = 27;
                        }
                    }
                    if ((ob1.x > ob.grid[tx][ty].x1 && ob1.x < ob.grid[tx][ty].x2) && (ob1.y > ob.grid[tx][ty].y1 && ob1.y < ob.grid[tx][ty].y2)) {
                        set(tx, ty);
                        flag = false;
                        break;
                    }
                }
            }
        } else if (ob1.player == 3) {
            for (int j = 0; j < 28; j++) {
                tx = ob1.dx + bishopfx[j];
                ty = ob1.dy + bishopfy[j];
                if ((tx >= 1 && tx <= 8) && (ty >= 1 && ty <= 8)) {
                    if (ob.grid[tx][ty].player != 0) {
                        if (j < 6) {
                            j = 6;
                        } else if (j < 13) {
                            j = 13;
                        } else if (j < 20) {
                            j = 20;
                        } else if (j < 27) {
                            j = 27;
                        }
                    }
                    if ((ob1.x > ob.grid[tx][ty].x1 && ob1.x < ob.grid[tx][ty].x2) && (ob1.y > ob.grid[tx][ty].y1 && ob1.y < ob.grid[tx][ty].y2)) {
                        set(tx, ty);
                        flag = false;
                        break;
                    }
                }
            }
        } else if (ob1.player == 2) {
            for (int j = 0; j < 56; j++) {
                tx = ob1.dx + queenfx[j];
                ty = ob1.dy + queenfy[j];
                if ((tx >= 1 && tx <= 8) && (ty >= 1 && ty <= 8)) {
                    if (ob.grid[tx][ty].player != 0) {
                        if (j < 6) {
                            j = 6;
                        } else if (j < 13) {
                            j = 13;
                        } else if (j < 20) {
                            j = 20;
                        } else if (j < 27) {
                            j = 27;
                        } else if (j < 34) {
                            j = 34;
                        } else if (j < 41) {
                            j = 41;
                        } else if (j < 48) {
                            j = 48;
                        } else if (j < 55) {
                            j = 55;
                        }
                    }
                    if ((ob1.x > ob.grid[tx][ty].x1 && ob1.x < ob.grid[tx][ty].x2) && (ob1.y > ob.grid[tx][ty].y1 && ob1.y < ob.grid[tx][ty].y2)) {
                        set(tx, ty);
                        flag = false;
                        break;
                    }
                }
            }
        }
        if (!flag) {
            flag1 = false;
            for (int i = 1; i <= 8; i++) {
                for (int j = 1; j <= 8; j++) {
                    if (!ob.grid[i][j].col.equals(ob1.col)) {
                        flag1 = ob2.cm(i, j, ob.grid[i][j].col, ob.grid[i][j].player, false);
                    }
                    if (flag1) {
                        ob.grid[ob1.dx][ob1.dy].col = ob1.col;
                        ob.grid[ob1.dx][ob1.dy].player = ob1.player;
                        ob.grid[tx][ty].col = this.tempcol;
                        ob.grid[tx][ty].player = this.tempplayer;
                        flag = true;
                        break;
                    }
                }
                if (flag1) {
                    break;
                }
            }
        }
        flag1 = false;
        if (flag) {
            board.t3.show();
        } else {
            if(ob1.player==1){
                ob.left_cast=false;
                ob.right_cast=false;
            }
            else if(ob1.player==5){
                if(ob1.dy==1){
                    ob.left_cast=false;
                }
                else if(ob1.dy==8){
                    ob.right_cast=false;
                }
            }
            if(ob1.player==6&&pawnrow==1){
                for(int i=1;i<=6;i++){
                    total_player[i]=0;
                }
                for(int i=1;i<=8;i++){
                    for(int j=1;j<=8;j++){
                        if(board.playerone){
                            if(board.grid[i][j].col=="white"){
                                total_player[board.grid[i][j].player]++;
                            }
                        }
                        else if(board.playertwo){
                            if(board.grid[i][j].col=="black"){
                                total_player[board.grid[i][j].player]++;
                            }
                        }
                    }
                }
                pass=false;
                ob.ref.dialogue();
            }
            if(pass) {
                setcheck();
            }
        }
    }
    public void setcheck() {
        flag1 = false;
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                if (ob.grid[i][j].col.equals(ob1.col)) {
                    flag1 = ob2.cm(i, j, ob1.col, ob.grid[i][j].player, true);
                    if (flag1) {
                        break;
                    }
                }
            }
            if (flag1) {
                break;
            }
        }
        if (flag1) {
            flag1 = false;
            boolean b = false;
            for (int i = 1; i <= 8; i++) {

                for (int j = 1; j <= 8; j++) {
                    if (ob.grid[i][j].player == 1 && !ob.grid[i][j].col.equals(ob1.col)) {
                        b = ob3.edit(i, j, ob.grid[i][j].col);
                        flag1 = true;
                        break;
                    }
                }
                if (flag1) {
                    break;
                }
            }
            if (b) {
                checkmate = true;
                ob.ref.show_check_mate();

            } else {
                check = true;
            }
        }
        state="";
        for(int i=1;i<=8;i++){
            for(int j=1;j<=8;j++){
                state=state+board.grid[i][j].player;
                if(board.grid[i][j].col=="nil"){
                    state=state+0;
                }
                else if(board.grid[i][j].col=="white"){
                    state=state+1;
                }
                else{
                    state=state+2;
                }
            }
        }
        if(checkmate){
            state=state+2;
        }
        else if(check){

            state=state+1;
        }
        else{
            state=state+0;
        }
        check=false;
        if (ob.playerone){
            try {
                TCPServer.outToClient.write(state.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            ob.playerone = false;

        } else if (ob.playertwo) {
            try {
                TCPClient.outToServer.write(state.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            ob.playertwo = false;
        }
    }
    public void set(int x, int y) {
        this.tempcol = ob.grid[x][y].col;
        this.tempplayer = ob.grid[x][y].player;
        ob.grid[x][y].col = ob1.col;
        ob.grid[x][y].player = ob1.player;
        ob.grid[ob1.dx][ob1.dy].col = "nil";
        ob.grid[ob1.dx][ob1.dy].player = 0;
    }
}