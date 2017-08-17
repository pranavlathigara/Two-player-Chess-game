package com.example.shago_000.chess;

import java.util.ArrayList;

/**
 * Created by shago_000 on 8/23/2015.
 */
public class check {

    ArrayList<Integer> r = new ArrayList<Integer>();
    ArrayList<Integer> c = new ArrayList<Integer>();
    int tx;
    int ty;
    int j;
    int x;
    int y;
    int z;
    board ob;
    game ob1;
    game2 ob2;

    check(board ob3, game ob4, game2 ob5) {

        ob = ob3;
        ob1 = ob4;
        ob2 = ob5;

    }

    boolean cm(int row, int column, String col, int player, boolean b) {
        if (b) {
            r.clear();
            c.clear();
        }
        if (player == 1) {
            for (j = 0; j < 8; j++) {
                tx = row + ob2.kingfx[j];
                ty = column + ob2.kingfy[j];
                if ((tx >= 1 && tx <= 8) && (ty >= 1 && ty <= 8)) {
                    if (!ob.grid[tx][ty].col.equals(col) && ob.grid[tx][ty].player == 1) {
                        return true;
                    }
                }
            }
        } else if (player == 6) {
            for (int i = 0; i <= 1; i++) {
                tx = row + ob2.pawnfx[i];
                ty = column + ob2.pawnfy[i];
                if ((tx >= 1 && tx <= 8) && (ty >= 1 && ty <= 8)) {
                    if (!ob.grid[tx][ty].col.equals(col) && ob.grid[tx][ty].player == 1) {
                        if (b) {
                            r.add(row);
                            c.add(column);
                        }
                        return true;
                    }
                }
            }
        } else if (player == 5) {
            for (j = 0; j < 28; j++) {
                tx = row + ob2.rookfx[j];
                ty = column + ob2.rookfy[j];
                if ((tx >= 1 && tx <= 8) && (ty >= 1 && ty <= 8)) {
                    z = j;
                    if (!"nil".equals(ob.grid[tx][ty].col)) {
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
                    if (!ob.grid[tx][ty].col.equals(col) && ob.grid[tx][ty].player == 1) {
                        if (b) {
                            r.add(row);
                            c.add(column);
                        }
                        if (j <= 6) {
                            x = 0;
                            y = z - 1;
                        } else if (j <= 13) {
                            x = 7;
                            y = z - 1;
                        } else if (j <= 20) {
                            x = 14;
                            y = z - 1;
                        } else if (j <= 27) {
                            x = 21;
                            y = z - 1;
                        }
                        if (b) {
                            for (int k = x; k <= y; k++) {
                                r.add(row + ob2.rookfx[k]);
                                c.add(column + ob2.rookfy[k]);
                            }
                        }
                        return true;
                    }
                }
            }
        } else if (player == 4) {
            for (j = 0; j < 8; j++) {
                tx = row + ob2.knightfx[j];
                ty = column + ob2.knightfy[j];
                if ((tx >= 1 && tx <= 8) && (ty >= 1 && ty <= 8)) {
                    if (!ob.grid[tx][ty].col.equals(col) && ob.grid[tx][ty].player == 1) {
                        if (b) {
                            r.add(row);
                            c.add(column);
                        }
                        return true;
                    }
                }
            }
        } else if (player == 3) {
            for (j = 0; j < 28; j++) {
                tx = row + ob2.bishopfx[j];
                ty = column + ob2.bishopfy[j];
                if ((tx >= 1 && tx <= 8) && (ty >= 1 && ty <= 8)) {
                    z = j;
                    if (!"nil".equals(ob.grid[tx][ty].col)) {
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
                    if (!ob.grid[tx][ty].col.equals(col) && ob.grid[tx][ty].player == 1) {
                        if (b) {
                            r.add(row);
                            c.add(column);
                        }
                        if (j <= 6) {
                            x = 0;
                            y = z - 1;
                        } else if (j <= 13) {
                            x = 7;
                            y = z - 1;
                        } else if (j <= 20) {
                            x = 14;
                            y = z - 1;
                        } else if (j <= 27) {
                            x = 21;
                            y = z - 1;
                        }
                        if (b) {
                            for (int k = x; k <= y; k++) {
                                r.add(row + ob2.bishopfx[k]);
                                c.add(column + ob2.bishopfy[k]);
                            }
                        }
                        return true;
                    }
                }
            }
        } else if (player == 2) {
            for (j = 0; j < 56; j++) {
                tx = row + ob2.queenfx[j];
                ty = column + ob2.queenfy[j];
                if ((tx >= 1 && tx <= 8) && (ty >= 1 && ty <= 8)) {
                    z = j;
                    if (!"nil".equals(ob.grid[tx][ty].col)) {
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
                    if (!ob.grid[tx][ty].col.equals(col) && ob.grid[tx][ty].player == 1) {
                        if (b) {
                            r.add(row);
                            c.add(column);
                        }
                        if (j <= 6) {
                            x = 0;
                            y = z - 1;
                        } else if (j <= 13) {
                            x = 7;
                            y = z - 1;
                        } else if (j <= 20) {
                            x = 14;
                            y = z - 1;
                        } else if (j <= 27) {
                            x = 21;
                            y = z - 1;
                        } else if (j <= 34) {
                            x = 28;
                            y = z - 1;
                        } else if (j <= 41) {
                            x = 35;
                            y = z - 1;
                        } else if (j <= 48) {
                            x = 42;
                            y = z - 1;
                        } else if (j <= 55) {
                            x = 49;
                            y = z - 1;
                        }
                        if (b) {
                            for (int k = x; k <= y; k++) {
                                r.add(row + ob2.queenfx[k]);
                                c.add(column + ob2.queenfy[k]);
                            }
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }
}