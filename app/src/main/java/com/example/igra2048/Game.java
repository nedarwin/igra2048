package com.example.igra2048;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    public static final int COUNT_CELLS_X = 4;
    public static final int COUNT_CELLS_Y = 4;
    public int[][] theField, sells;
    public int score;
    public boolean evoli;
    public ArrayList<Integer> dowm = new ArrayList<>();
    public ArrayList<Integer> foran = new ArrayList<>();
    public int x = (int) (Math.random() * 2);

    public Game() {
        theField = new int[COUNT_CELLS_X][COUNT_CELLS_Y];
        for (int i = 0; i < theField.length; i++) {
            for (int j = 0; j < theField[i].length; j++) {
                theField[i][j] = (int) (Math.random() * 2);
            }
        }
        sells = new int[COUNT_CELLS_X][COUNT_CELLS_Y];
        for (int[] sell : sells) {
            Arrays.fill(sell, 1);
        }
    }
    public void random(){
        for (int i = 0; i < theField.length; i++) {
            for (int j = 0; j < theField[i].length; j++) {
                int rndj=(int) (Math.random() * 3);
                int rndi=(int) (Math.random() * 3);
                int rch = theField[rndi][rndj];
                int rh=sells[rndi][rndj];
                theField[rndi][rndj]=theField[i][j];
                theField[i][j]=rch;
                sells[rndi][rndj]=sells[i][j];
                sells[i][j]=rh;
            }
        }
    }

    public void evol(int i, int j) {
        evoli=false;
        foran.removeAll(foran);
        dowm.removeAll(dowm);
        ArrayList<Integer> ij = new ArrayList<>();
        int size = 2;
        ij.add(i);
        ij.add(j);
        int o = 1;
        int kg=0;
        int a = theField[ij.get(0)][ij.get(1)];
        int lp = sells[ij.get(0)][ij.get(1)];
        int newa = a;
        theField[i][j] = -1;

        int l = 1;
        for (int c = 0; c < o; c += 2) {
            i = ij.get(c);
            j = ij.get(c + 1);
            if(i==ij.get(0) && j==ij.get(1)){
                kg+=1;
            }
            for (int k = -1; k <= 1; k += 2) {
                int ak = i - k;
                int jk = j - k;
                if (j == 3 ) {

                    jk = j - Math.abs(k);
                }
                if (j == 0 ) {

                    jk = Math.abs(jk);
                }
                if (i == 3) {
                    ak = i - Math.abs(k);

                }
                if (i == 0) {
                    ak = Math.abs(ak);

                }


                if (theField[ak][j] == a) {
                    ij.add(ak);
                    ij.add(j);
                    theField[ak][j] = -1;
                    evoli=true;
                    switch (a) {
                        case 0:
                        case 1:
                            sells[ij.get(0)][ij.get(1)] += 1;
                            if (sells[ij.get(0)][ij.get(1)] >= 3) {
                                newa = 2;
                            }
                            if (sells[ij.get(0)][ij.get(1)] >= 9) {
                                newa = 3;
                            }
                            break;
                        case 2:
                            sells[ij.get(0)][ij.get(1)] += 3;
                            if (sells[ij.get(0)][ij.get(1)] >= 9) {
                                newa = 3;
                            }
                            if (sells[ij.get(0)][ij.get(1)] >= 27) {
                                newa = 4;
                            }
                            break;
                        case 3:
                            sells[ij.get(0)][ij.get(1)] += 9;
                            if (sells[ij.get(0)][ij.get(1)] >= 27) {
                                newa = 4;
                            }
                            if (sells[ij.get(0)][ij.get(1)] >= 81) {
                                newa = 5;
                            }
                            break;
                        case 4:
                            sells[ij.get(0)][ij.get(1)] += 27;
                            if (sells[ij.get(0)][ij.get(1)] >= 81) {
                                newa = 5;
                            }
                            if (sells[ij.get(0)][ij.get(1)] >= 243) {
                                newa = 6;
                            }
                            break;
                        default:
                            sells[ij.get(0)][ij.get(1)] += 81;
                            if (sells[ij.get(0)][ij.get(1)] >= 729) {
                                newa = 6;
                            }
                            break;
                    }

                }

                if (theField[i][jk] == a) {
                    evoli=true;
                    ij.add(i);
                    ij.add(jk);
                    theField[i][jk] = -1;

                    switch (a) {
                        case 0:
                        case 1:
                            sells[ij.get(0)][ij.get(1)] += 1;
                            if (sells[ij.get(0)][ij.get(1)] >= 3) {
                                newa = 2;
                            }
                            if (sells[ij.get(0)][ij.get(1)] >= 9) {
                                newa = 3;
                            }
                            break;
                        case 2:
                            sells[ij.get(0)][ij.get(1)] += 3;
                            if (sells[ij.get(0)][ij.get(1)] >= 9) {
                                newa = 3;
                            }
                            if (sells[ij.get(0)][ij.get(1)] >= 27) {
                                newa = 4;
                            }
                            break;
                        case 3:
                            sells[ij.get(0)][ij.get(1)] += 9;
                            if (sells[ij.get(0)][ij.get(1)] >= 27) {
                                newa = 4;
                            }
                            if (sells[ij.get(0)][ij.get(1)] >= 81) {
                                newa = 5;
                            }
                            break;
                        case 4:
                            sells[ij.get(0)][ij.get(1)] += 27;
                            if (sells[ij.get(0)][ij.get(1)] >= 81) {
                                newa = 5;
                            }
                            if (sells[ij.get(0)][ij.get(1)] >= 243) {
                                newa = 6;
                            }
                            break;
                        default:
                            sells[ij.get(0)][ij.get(1)] += 81;
                            if (sells[ij.get(0)][ij.get(1)] >= 729) {
                                newa = 6;
                            }
                            break;
                    }
                }
                size = ij.size();
            }
            o = size / 2 + l;
            l += 1;
            if (size == 2) {
                o = 0;
            }
        }
        if(kg>1){
            sells[ij.get(0)][ij.get(1)]-=kg*lp;
        }
        theField[ij.get(0)][ij.get(1)] = newa;
        for (int h = ij.get(0); h < 3; h++) {
            if (theField[h + 1][ij.get(1)] == -1) {
                theField[h + 1][ij.get(1)] = theField[h][ij.get(1)];
                theField[h][ij.get(1)] = -1;
                sells[h + 1][ij.get(1)] = sells[h][ij.get(1)];
                sells[h][ij.get(1)] =-1;
            }
        }
        for(int kol=0;kol<4;kol++){
            for(int q=0;q<4;q++) {
                for (int z = 3; z > 0; z--) {
                    if (theField[z][q] == -1) {
                        theField[z][q] = theField[z - 1][q];
                        theField[z - 1][q] = -1;
                        sells[z][q] = sells[z - 1][q];
                        sells[z - 1][q] = -1;
                        dowm.add((z * 4 + q));
                    }
                }
            }
        }
        System.out.println(ij.size());
        for (int r = 0; r < theField.length; r++) {
            for (int t = 0; t < theField[r].length; t++) {
                if (theField[r][t] == -1) {
                    sells[r][t]=1;
                    theField[r][t] = (int) (Math.random() * 2);
                    foran.add(r);
                    foran.add(t);
                }
            }
        }
    }
}
