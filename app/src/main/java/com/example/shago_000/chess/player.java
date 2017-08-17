package com.example.shago_000.chess;

/**
 * Created by shago_000 on 8/18/2015.
 */
public class player {

    board board;
    info ref;
    player(board ob){
        board =ob;
    }
    public  void set_player(){
        ref=new info();
        ref.col="black";
        ref.player=5;
        board.grid[1][1]=ref;
        ref=new info();
        ref.col="black";
        ref.player=4;
        board.grid[1][2]=ref;
        ref=new info();
        ref.col="black";
        ref.player=3;
        board.grid[1][3]=ref;
        ref=new info();
        ref.col="black";
        ref.player=2;
        board.grid[1][4]=ref;
        ref=new info();
        ref.col="black";
        ref.player=1;
        board.grid[1][5]=ref;
        ref=new info();
        ref.col="black";
        ref.player=3;
        board.grid[1][6]=ref;
        ref=new info();
        ref.col="black";
        ref.player=4;
        board.grid[1][7]=ref;
        ref=new info();
        ref.col="black";
        ref.player=5;
        board.grid[1][8]=ref;
        for(int i=1;i<=8;i++){
            ref=new info();
            ref.col="black";
            ref.player=6;
            board.grid[2][i]=ref;
        }
        for(int i=1;i<=8;i++){
            ref=new info();
            ref.col="white";
            ref.player=6;
            board.grid[7][i]=ref;
        }
        ref=new info();
        ref.col="white";
        ref.player=5;
        board.grid[8][1]=ref;
        ref=new info();
        ref.col="white";
        ref.player=4;
        board.grid[8][2]=ref;
        ref=new info();
        ref.col="white";
        ref.player=3;
        board.grid[8][3]=ref;
        ref=new info();
        ref.col="white";
        ref.player=2;
        board.grid[8][4]=ref;
        ref=new info();
        ref.col="white";
        ref.player=1;
        board.grid[8][5]=ref;
        ref=new info();
        ref.col="white";
        ref.player=3;
        board.grid[8][6]=ref;
        ref=new info();
        ref.col="white";
        ref.player=4;
        board.grid[8][7]=ref;
        ref=new info();
        ref.col="white";
        ref.player=5;
        board.grid[8][8]=ref;
        for(int i=1;i<=8;i++){
            for(int j=1;j<=8;j++){
                if(i>=3&&i<=6){
                    ref=new info();
                    board.grid[i][j]=ref;
                    board.grid[i][j].player=0;
                    board.grid[i][j].col="nil";
                }
                board.grid[i][j].x1= board.rec[i][j].left;
                board.grid[i][j].x2= board.rec[i][j].right;
                board.grid[i][j].y1= board.rec[i][j].top;
                board.grid[i][j].y2= board.rec[i][j].bottom;
            }
        }
    }
}