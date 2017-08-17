package com.example.shago_000.chess;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by shago_000 on 8/25/2015.
 */
public class TCPServer extends Thread {
    static BufferedInputStream inFromClient = null;
    static BufferedOutputStream outToClient = null;
    MainActivity ref;
    String str="";
    byte array[] = new  byte[200];
    TCPServer(MainActivity ob){
        ref=ob;
    }
    public void create() throws IOException {
        ServerSocket s1= null;
        s1 = new ServerSocket(1234);
        Socket connectionSocket = null;
        connectionSocket = s1.accept();
        outToClient = new BufferedOutputStream(connectionSocket.getOutputStream());
        inFromClient = new BufferedInputStream(connectionSocket.getInputStream());
        board.playerone=true;
        ref.set_dialogue();
        this.start();
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
                bytesRead = inFromClient.read(array);
                str = new String(array,0,bytesRead);
            } catch (Exception e) {}
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
                    board.t2.show();
                }
                board.t1.show();
                board.playerone = true;
            }
            str = "";
        }
    }
}