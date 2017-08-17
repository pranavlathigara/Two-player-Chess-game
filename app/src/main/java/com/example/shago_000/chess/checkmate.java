package com.example.shago_000.chess;
/**
 * Created by shago_000 on 8/25/2015.
 */
public class checkmate {
    int pawnfx[] = {1, 1, 1, 2};
    int pawnfy[] = {1, -1, 0, 0};
    check ob;
    game2 ob1;
    board ob2;
    int tx;
    int ty;
    int tempplayer;
    String tempcol;
    String colour;
    boolean flag, t;
    int block[][] = new int[10][10];
    checkmate(check ob3, game2 ob4, board ob5) {
        ob = ob3;
        ob1 = ob4;
        ob2 = ob5;
    }
    boolean edit(int row, int column, String col) {
        if (col == "white") {
            colour = "black";
        } else {
            colour = "white";
        }
        for (int k = 0; k < 8; k++) {
            tx = row + ob1.kingfx[k];
            ty = column + ob1.kingfy[k];
            if (((tx >= 1 && tx <= 8) && (ty >= 1 && ty <= 8)) && !ob2.grid[tx][ty].col.equals(col)) {
                set(col, row, column, 1, tx, ty);
                flag = pass();
                set1(col, row, column, 1, tx, ty);
                if (flag) {
                    return false;
                }
            }
        }
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                block[i][j] = 0;
            }
        }
        for (int i = 0; i < ob.r.size(); i++) {
            int x = ob.r.get(i);
            int y = ob.c.get(i);
            block[x][y] = 1;
        }
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                if (ob2.grid[i][j].col.equals(col)) {
                    if (ob2.grid[i][j].player == 6) {
                        for (int k = 0; k < 4; k++) {
                            t = false;
                            tx = i + pawnfx[k];
                            ty = j + pawnfy[k];
                            if ((tx >= 1 && tx <= 8) && (ty >= 1 && ty <= 8)) {
                                if (block[tx][ty] == 1) {
                                    if (k == 3) {
                                        if (col.equals("white")) {
                                            if ((ob2.grid[i][j].y1 >= 520 && ob2.grid[i][j].y2 <= 600) && ob2.grid[tx][ty].player == 0) {
                                                if (ob2.grid[tx + 1][ty].player == 0) {
                                                    t = true;
                                                }
                                            }
                                        } else {
                                            if ((ob2.grid[i][j].y1 >= 120 && ob2.grid[i][j].y2 <= 200) && ob2.grid[tx][ty].player == 0) {
                                                if (ob2.grid[tx - 1][ty].player == 0) {
                                                    t = true;
                                                }
                                            }
                                        }
                                    }
                                    if (k <= 1) {
                                        if (!ob2.grid[tx][ty].col.equals(col)) {
                                            t = true;
                                        }
                                    }
                                    if (k == 2) {
                                        if (ob2.grid[tx][ty].player == 0) {
                                            t = true;
                                        }
                                    }
                                    if (t) {
                                        set(col, i, j, 6, tx, ty);
                                        flag = pass();
                                        set1(col, i, j, 6, tx, ty);
                                        if (flag) {
                                            return false;
                                        }
                                    }

                                }
                            }

                        }
                    } else if (ob2.grid[i][j].player == 4) {
                        for (int k = 0; k < 8; k++) {
                            tx = i + ob1.knightfx[k];
                            ty = j + ob1.knightfy[k];
                            if ((tx >= 1 && tx <= 8) && (ty >= 1 && ty <= 8)) {

                                if (block[tx][ty] == 1 && !ob2.grid[tx][ty].col.equals(col)) {
                                    set(col, i, j, 4, tx, ty);
                                    flag = pass();
                                    set1(col, i, j, 4, tx, ty);
                                    if (flag) {
                                        return false;
                                    }
                                }
                            }
                        }
                    } else if (ob2.grid[i][j].player == 2) {
                        for (int k = 0; k < 56; k++) {
                            tx = i + ob1.queenfx[k];
                            ty = j + ob1.queenfy[k];
                            if ((tx >= 1 && tx <= 8) && (ty >= 1 && ty <= 8)) {
                                if (ob2.grid[tx][ty].player != 0) {
                                    if (k < 6) {
                                        k = 6;
                                    } else if (k < 13) {
                                        k = 13;
                                    } else if (k < 20) {
                                        k = 20;
                                    } else if (k < 27) {
                                        k = 27;
                                    } else if (k < 34) {
                                        k = 34;
                                    } else if (k < 41) {
                                        k = 41;
                                    } else if (k < 48) {
                                        k = 48;
                                    } else if (k < 55) {
                                        k = 55;
                                    }
                                }
                                if (block[tx][ty] == 1 && !ob2.grid[tx][ty].col.equals(col)) {
                                    set(col, i, j, 2, tx, ty);
                                    flag = pass();
                                    set1(col, i, j, 2, tx, ty);
                                    if (flag) {
                                        return false;
                                    }
                                }
                            }
                        }
                    } else if (ob2.grid[i][j].player == 3) {
                        for (int k = 0; k < 28; k++) {
                            tx = i + ob1.bishopfx[k];
                            ty = j + ob1.bishopfy[k];
                            if ((tx >= 1 && tx <= 8) && (ty >= 1 && ty <= 8)) {
                                if (ob2.grid[tx][ty].player != 0) {
                                    if (k < 6) {
                                        k = 6;
                                    } else if (k < 13) {
                                        k = 13;
                                    } else if (k < 20) {
                                        k = 20;
                                    } else if (k < 27) {
                                        k = 27;
                                    }
                                }
                                if (block[tx][ty] == 1 && !ob2.grid[tx][ty].col.equals(col)) {
                                    set(col, i, j, 3, tx, ty);
                                    flag = pass();
                                    set1(col, i, j, 3, tx, ty);
                                    if (flag) {
                                        return false;
                                    }
                                }
                            }
                        }
                    } else if (ob2.grid[i][j].player == 5) {
                        for (int k = 0; k < 28; k++) {
                            tx = i + ob1.rookfx[k];
                            ty = j + ob1.rookfy[k];
                            if ((tx >= 1 && tx <= 8) && (ty >= 1 && ty <= 8)) {
                                if (ob2.grid[tx][ty].player != 0) {
                                    if (k < 6) {
                                        k = 6;
                                    } else if (k < 13) {
                                        k = 13;
                                    } else if (k < 20) {
                                        k = 20;
                                    } else if (k < 27) {
                                        k = 27;
                                    }
                                }
                                if (block[tx][ty] == 1 && !ob2.grid[tx][ty].col.equals(col)) {
                                    set(col, i, j, 5, tx, ty);
                                    flag = pass();
                                    set1(col, i, j, 5, tx, ty);
                                    if (flag) {
                                        return false;
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
    public boolean pass() {
        boolean flag2 = false;
        for (int i = 1; i <= 8; i++) {
            for (int k = 1; k <= 8; k++) {
                if (ob2.grid[i][k].col.equals(this.colour)) {
                    flag2 = ob.cm(i, k, this.colour, ob2.grid[i][k].player, false);
                }
                if (flag2) {
                    return false;
                }
            }
        }
        return true;
    }
    public void set(String col, int i, int j, int player, int x, int y) {
        this.tempplayer = ob2.grid[x][y].player;
        this.tempcol = ob2.grid[x][y].col;
        ob2.grid[x][y].player = player;
        ob2.grid[x][y].col = col;
        ob2.grid[i][j].player = 0;
        ob2.grid[i][j].col = "nil";
    }
    public void set1(String col, int i, int j, int player, int x, int y) {
        ob2.grid[i][j].player = player;
        ob2.grid[i][j].col = col;
        ob2.grid[x][y].player = this.tempplayer;
        ob2.grid[x][y].col = this.tempcol;
    }
}