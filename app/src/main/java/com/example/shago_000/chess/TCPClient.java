package com.example.shago_000.chess;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by shago_000 on 8/25/2015.
 */
public class TCPClient extends Thread{
    MainActivity ref;
    byte array[] = new byte[200];
    static BufferedInputStream inFromServer;
    static BufferedOutputStream outToServer;
    String str="";
    Socket clientSocket;
    TCPClient(MainActivity ob)  {
        ref=ob;
    }
    public void create() throws IOException {
        clientSocket = new Socket(ref.str,1234);
        inFromServer = new BufferedInputStream(clientSocket.getInputStream());
        outToServer = new BufferedOutputStream(clientSocket.getOutputStream());
        ref.set_dialogue();
        board.player_two=true;
    }
    @Override
    public void run(){
        while(true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                int bytesRead;
                bytesRead = inFromServer.read(array);
                str = new String(array,0,bytesRead);
            } catch (Exception e) {
            }
            if (str != "") {
                int k = 0;
                for (int i = 8; i >= 1; i--) {
                    for (int j = 1; j <= 8; j++) {
                        char c = str.charAt(k);
                        board.grid[i][j].player = c - '0';
                        k++;
                        if (str.charAt(k) == '0') {
                            board.grid[i][j].col = "nil";
                        } else if (str.charAt(k) == '1') {
                            board.grid[i][j].col = "white";

                        } else {
                            board.grid[i][j].col = "black";
                        }
                        k++;
                    }
                }
                if (str.charAt(k) == '2') {
                    board.checkmate = true;
                } else if (str.charAt(k) == '1') {
                    board.mycheck = true;
                    board.t2.show();
                } else {
                    board.mycheck = false;
                }
                board.t1.show();
                board.playertwo = true;
            }
            str = "";
        }
    }
}