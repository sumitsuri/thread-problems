package com.solution.lld.ludo.model;

import com.solution.lld.ludo.constants.Constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LudoBoard {

    // board layout arrays
    private String[][] square = new String[15][15];
    private String[][] border = new String[16][15];

    // record of pieces in a block
    // first two ints are coords, third is the piece
    // max 4 pieces possible in one block
    Piece[][][] pieceRecord = new Piece[15][15][4];

    int[][] greenHomePos = {{2,2},{2,3},{3,2},{3,3}};
    int[][] yellowHomePos = {{2,11},{2,12},{3,11},{3,12}};
    int[][] redHomePos = {{11,2},{11,3},{12,2},{12,3}};
    int[][] blueHomePos = {{11,11},{11,12},{12,11},{12,12}};

    Map<String, int[][]> positionMap;

    // x and y coordinates of each color's path
    int[][] greenPath = { { 6, 1 }, { 6, 2 }, { 6, 3 }, { 6, 4 }, { 6, 5 },
            { 5, 6 }, { 4, 6 }, { 3, 6 }, { 2, 6 }, { 1, 6 }, { 0, 6 },
            { 0, 7 }, { 0, 8 }, { 2, 8 }, { 3, 8 }, { 4, 8 }, { 5, 8 },
            { 6, 9 }, { 6, 10 }, { 6, 11 }, { 6, 12 }, { 6, 13 }, { 6, 14 },
            { 7, 14 }, { 8, 14 }, { 8, 12 }, { 8, 11 }, { 8, 10 }, { 8, 9 },
            { 9, 8 }, { 10, 8 }, { 11, 8 }, { 12, 8 }, { 13, 8 }, { 14, 8 },
            { 14, 7}, { 14, 6 }, { 12, 6 }, { 11, 6 }, { 10, 6 }, { 9, 6 },
            { 8, 5 }, { 8, 4 }, { 8, 3 }, { 8, 2 }, { 8, 1 }, { 8, 0 },
            { 7, 0 }, { 7, 1 }, { 7, 2 }, { 7, 3 }, { 7, 4 }, { 7, 5 }, { 7, 6 } };

    int[][] yellowPath = { { 1, 8 }, { 2, 8 }, { 3, 8 }, { 4, 8 }, { 5, 8 },
            { 6, 9 }, { 6, 10 }, { 6, 11 }, { 6, 12 }, { 6, 13 }, { 6, 14 },
            { 7, 14 }, { 8, 14 }, { 8, 12 }, { 8, 11 }, { 8, 10 }, { 8, 9 },
            { 9, 8 }, { 10, 8 }, { 11, 8 }, { 12, 8 }, { 13, 8 }, { 14, 8 },
            { 14, 7}, { 14, 6 }, { 12, 6 }, { 11, 6 }, { 10, 6 }, { 9, 6 },
            { 8, 5 }, { 8, 4 }, { 8, 3 }, { 8, 2 }, { 8, 1 }, { 8, 0 },
            { 7, 0 }, { 6, 0 }, { 6, 2 }, { 6, 3 }, { 6, 4 }, { 6, 5 },
            { 5, 6 }, { 4, 6 }, { 3, 6 }, { 2, 6 }, { 1, 6 }, { 0, 6 },
            { 0, 7 }, { 1, 7 }, { 2, 7 }, { 3, 7 }, { 4, 7 }, { 5, 7 }, { 6, 7 } };

    int[][] redPath = { { 13, 6 }, { 12, 6 }, { 11, 6 }, { 10, 6 }, { 9, 6 },
            { 8, 5 }, { 8, 4 }, { 8, 3 }, { 8, 2 }, { 8, 1 }, { 8, 0 },
            { 7, 0 }, { 6, 0 }, { 6, 2 }, { 6, 3 }, { 6, 4 }, { 6, 5 },
            { 5, 6 }, { 4, 6 }, { 3, 6 }, { 2, 6 }, { 1, 6 }, { 0, 6 },
            { 0, 7 }, { 0, 8 }, { 2, 8 }, { 3, 8 }, { 4, 8 }, { 5, 8 },
            { 6, 9 }, { 6, 10 }, { 6, 11 }, { 6, 12 }, { 6, 13 }, { 6, 14 },
            { 7, 14 }, { 8, 14 }, { 8, 12 }, { 8, 11 }, { 8, 10 }, { 8, 9 },
            { 9, 8 }, { 10, 8 }, { 11, 8 }, { 12, 8 }, { 13, 8 }, { 14, 8 },
            { 14, 7}, { 13, 7}, { 12, 7}, { 11, 7}, { 10, 7}, { 9, 7}, { 8, 7} };

    int[][] bluePath = { { 8, 13 }, { 8, 12 }, { 8, 11 }, { 8, 10 }, { 8, 9 },
            { 9, 8 }, { 10, 8 }, { 11, 8 }, { 12, 8 }, { 13, 8 }, { 14, 8 },
            { 14, 7}, { 14, 6 }, { 12, 6 }, { 11, 6 }, { 10, 6 }, { 9, 6 },
            { 8, 5 }, { 8, 4 }, { 8, 3 }, { 8, 2 }, { 8, 1 }, { 8, 0 },
            { 7, 0 }, { 6, 0 }, { 6, 2 }, { 6, 3 }, { 6, 4 }, { 6, 5 },
            { 5, 6 }, { 4, 6 }, { 3, 6 }, { 2, 6 }, { 1, 6 }, { 0, 6 },
            { 0, 7 }, { 0, 8 }, { 2, 8 }, { 3, 8 }, { 4, 8 }, { 5, 8 },
            { 6, 9 }, { 6, 10 }, { 6, 11 }, { 6, 12 }, { 6, 13 }, { 6, 14 },
            { 7, 14 }, { 7, 13 }, { 7, 12 }, { 7, 11 }, { 7, 10 }, { 7, 9 }, { 7, 8 } };

    Map<String, int[][]> pathMap;

    public LudoBoard(){
        positionMap = new HashMap<>();
        positionMap.put(Constant.Color.GREEN, greenHomePos);
        positionMap.put(Constant.Color.YELLOW, yellowHomePos);
        positionMap.put(Constant.Color.RED, redHomePos);
        positionMap.put(Constant.Color.BLUE, blueHomePos);

        pathMap = new HashMap<>();
        pathMap.put(Constant.Color.GREEN, greenPath);
        pathMap.put(Constant.Color.YELLOW, yellowPath);
        pathMap.put(Constant.Color.RED, redPath);
        pathMap.put(Constant.Color.BLUE, bluePath);

        /*
         *
         * Initialize pieceRecord
         * Not needed as all position will be null by default in java.
         */

        for(int i=0; i<pieceRecord.length; i++) {

            pieceRecord[i] = new Piece[15][4];

            for(int j=0; j<pieceRecord[i].length; j++) {

                pieceRecord[i][j] = new Piece[4];

                for(int k=0; k<pieceRecord[i][j].length; k++)

                    pieceRecord[i][j][k] = null;

            }

        }

        System.out.println(pieceRecord[3][3]);
        System.out.println(pieceRecord[3][3][0]);
        initSquareAndBorders();
    }

    /*
     *
     * Initialize the board's layout
     *
     */
    private void initSquareAndBorders(){
        square[0][0] = "|Green";
        square[0][1] = "      ";
        square[0][2] = "      ";
        square[0][3] = "      ";
        square[0][4] = "      ";
        square[0][5] = "     |";
        square[0][6] = "|    |";
        square[0][7] = "|    |";
        square[0][8] = "|    |";
        square[0][9] = "|     ";
        square[0][10] = "      ";
        square[0][11] = "      ";
        square[0][12] = "      ";
        square[0][13] = "     Y";
        square[0][14] = "ellow|";
        square[1][0] = "|    |";
        square[1][1] = "|     ";
        square[1][2] = "      ";
        square[1][3] = "      ";
        square[1][4] = "     |";
        square[1][5] = "|    |";
        square[1][6] = "|    |";
        square[1][7] = "|    |";
        square[1][8] = "|    |";
        square[1][9] = "|    |";
        square[1][10] = "|     ";
        square[1][11] = "      ";
        square[1][12] = "      ";
        square[1][13] = "     |";
        square[1][14] = "|    |";
        square[2][0] = "|    |";
        square[2][1] = "|    |";
        square[2][2] = "|    |";
        square[2][3] = "|    |";
        square[2][4] = "|    |";
        square[2][5] = "|    |";
        square[2][6] = "|    |";
        square[2][7] = "|    |";
        square[2][8] = "|    |";
        square[2][9] = "|    |";
        square[2][10] = "|    |";
        square[2][11] = "|    |";
        square[2][12] = "|    |";
        square[2][13] = "|    |";
        square[2][14] = "|    |";
        square[3][0] = "|    |";
        square[3][1] = "|    |";
        square[3][2] = "|    |";
        square[3][3] = "|    |";
        square[3][4] = "|    |";
        square[3][5] = "|    |";
        square[3][6] = "|    |";
        square[3][7] = "|    |";
        square[3][8] = "|    |";
        square[3][9] = "|    |";
        square[3][10] = "|    |";
        square[3][11] = "|    |";
        square[3][12] = "|    |";
        square[3][13] = "|    |";
        square[3][14] = "|    |";
        square[4][0] = "|    |";
        square[4][1] = "|     ";
        square[4][2] = "      ";
        square[4][3] = "      ";
        square[4][4] = "     |";
        square[4][5] = "|    |";
        square[4][6] = "|    |";
        square[4][7] = "|    |";
        square[4][8] = "|    |";
        square[4][9] = "|    |";
        square[4][10] = "|     ";
        square[4][11] = "      ";
        square[4][12] = "      ";
        square[4][13] = "     |";
        square[4][14] = "|    |";
        square[5][0] = "|     ";
        square[5][1] = "      ";
        square[5][2] = "      ";
        square[5][3] = "      ";
        square[5][4] = "      ";
        square[5][5] = "     |";
        square[5][6] = "|    |";
        square[5][7] = "|    |";
        square[5][8] = "|    |";
        square[5][9] = "|     ";
        square[5][10] = "      ";
        square[5][11] = "      ";
        square[5][12] = "      ";
        square[5][13] = "      ";
        square[5][14] = "     |";
        square[6][0] = "|    |";
        square[6][1] = "|    |";
        square[6][2] = "|    |";
        square[6][3] = "|    |";
        square[6][4] = "|    |";
        square[6][5] = "|    |";
        square[6][6] = "|     ";
        square[6][7] = "      ";
        square[6][8] = "     |";
        square[6][9] = "|    |";
        square[6][10] = "|    |";
        square[6][11] = "|    |";
        square[6][12] = "|    |";
        square[6][13] = "|    |";
        square[6][14] = "|    |";
        square[7][0] = "|    |";
        square[7][1] = "|    |";
        square[7][2] = "|    |";
        square[7][3] = "|    |";
        square[7][4] = "|    |";
        square[7][5] = "|    |";
        square[7][6] = "|     ";
        square[7][7] = "      ";
        square[7][8] = "     |";
        square[7][9] = "|    |";
        square[7][10] = "|    |";
        square[7][11] = "|    |";
        square[7][12] = "|    |";
        square[7][13] = "|    |";
        square[7][14] = "|    |";
        square[8][0] = "|    |";
        square[8][1] = "|    |";
        square[8][2] = "|    |";
        square[8][3] = "|    |";
        square[8][4] = "|    |";
        square[8][5] = "|    |";
        square[8][6] = "|     ";
        square[8][7] = "      ";
        square[8][8] = "     |";
        square[8][9] = "|    |";
        square[8][10] = "|    |";
        square[8][11] = "|    |";
        square[8][12] = "|    |";
        square[8][13] = "|    |";
        square[8][14] = "|    |";
        square[9][0] = "|     ";
        square[9][1] = "      ";
        square[9][2] = "      ";
        square[9][3] = "      ";
        square[9][4] = "      ";
        square[9][5] = "     |";
        square[9][6] = "|    |";
        square[9][7] = "|    |";
        square[9][8] = "|    |";
        square[9][9] = "|     ";
        square[9][10] = "      ";
        square[9][11] = "      ";
        square[9][12] = "      ";
        square[9][13] = "      ";
        square[9][14] = "     |";
        square[10][0] = "|    |";
        square[10][1] = "|     ";
        square[10][2] = "      ";
        square[10][3] = "      ";
        square[10][4] = "     |";
        square[10][5] = "|    |";
        square[10][6] = "|    |";
        square[10][7] = "|    |";
        square[10][8] = "|    |";
        square[10][9] = "|    |";
        square[10][10] = "|     ";
        square[10][11] = "      ";
        square[10][12] = "      ";
        square[10][13] = "     |";
        square[10][14] = "|    |";
        square[11][0] = "|    |";
        square[11][1] = "|    |";
        square[11][2] = "|    |";
        square[11][3] = "|    |";
        square[11][4] = "|    |";
        square[11][5] = "|    |";
        square[11][6] = "|    |";
        square[11][7] = "|    |";
        square[11][8] = "|    |";
        square[11][9] = "|    |";
        square[11][10] = "|    |";
        square[11][11] = "|    |";
        square[11][12] = "|    |";
        square[11][13] = "|    |";
        square[11][14] = "|    |";
        square[12][0] = "|    |";
        square[12][1] = "|    |";
        square[12][2] = "|    |";
        square[12][3] = "|    |";
        square[12][4] = "|    |";
        square[12][5] = "|    |";
        square[12][6] = "|    |";
        square[12][7] = "|    |";
        square[12][8] = "|    |";
        square[12][9] = "|    |";
        square[12][10] = "|    |";
        square[12][11] = "|    |";
        square[12][12] = "|    |";
        square[12][13] = "|    |";
        square[12][14] = "|    |";
        square[13][0] = "|    |";
        square[13][1] = "|     ";
        square[13][2] = "      ";
        square[13][3] = "      ";
        square[13][4] = "     |";
        square[13][5] = "|    |";
        square[13][6] = "|    |";
        square[13][7] = "|    |";
        square[13][8] = "|    |";
        square[13][9] = "|    |";
        square[13][10] = "|     ";
        square[13][11] = "      ";
        square[13][12] = "      ";
        square[13][13] = "     |";
        square[13][14] = "|    |";
        square[14][0] = "|Red  ";
        square[14][1] = "      ";
        square[14][2] = "      ";
        square[14][3] = "      ";
        square[14][4] = "      ";
        square[14][5] = "     |";
        square[14][6] = "|    |";
        square[14][7] = "|    |";
        square[14][8] = "|    |";
        square[14][9] = "|     ";
        square[14][10] = "      ";
        square[14][11] = "      ";
        square[14][12] = "      ";
        square[14][13] = "      ";
        square[14][14] = " Blue|";

        border[0][0] = "------";
        border[0][1] = "------";
        border[0][2] = "------";
        border[0][3] = "------";
        border[0][4] = "------";
        border[0][5] = "------";
        border[0][6] = "------";
        border[0][7] = "------";
        border[0][8] = "------";
        border[0][9] = "------";
        border[0][10] = "------";
        border[0][11] = "------";
        border[0][12] = "------";
        border[0][13] = "------";
        border[0][14] = "------";
        border[1][0] = "      ";
        border[1][1] = "------";
        border[1][2] = "------";
        border[1][3] = "------";
        border[1][4] = "------";
        border[1][5] = "      ";
        border[1][6] = "------";
        border[1][7] = "------";
        border[1][8] = "------";
        border[1][9] = "      ";
        border[1][10] = "------";
        border[1][11] = "------";
        border[1][12] = "------";
        border[1][13] = "------";
        border[1][14] = "      ";
        border[2][0] = "      ";
        border[2][1] = "      ";
        border[2][2] = "------";
        border[2][3] = "------";
        border[2][4] = "      ";
        border[2][5] = "      ";
        border[2][6] = "------";
        border[2][7] = "------";
        border[2][8] = "------";
        border[2][9] = "      ";
        border[2][10] = "      ";
        border[2][11] = "------";
        border[2][12] = "------";
        border[2][13] = "      ";
        border[2][14] = "      ";
        border[3][0] = "      ";
        border[3][1] = "      ";
        border[3][2] = "------";
        border[3][3] = "------";
        border[3][4] = "      ";
        border[3][5] = "      ";
        border[3][6] = "------";
        border[3][7] = "------";
        border[3][8] = "------";
        border[3][9] = "      ";
        border[3][10] = "      ";
        border[3][11] = "------";
        border[3][12] = "------";
        border[3][13] = "      ";
        border[3][14] = "      ";
        border[4][0] = "      ";
        border[4][1] = "      ";
        border[4][2] = "------";
        border[4][3] = "------";
        border[4][4] = "      ";
        border[4][5] = "      ";
        border[4][6] = "------";
        border[4][7] = "------";
        border[4][8] = "------";
        border[4][9] = "      ";
        border[4][10] = "      ";
        border[4][11] = "------";
        border[4][12] = "------";
        border[4][13] = "      ";
        border[4][14] = "      ";
        border[5][0] = "      ";
        border[5][1] = "------";
        border[5][2] = "------";
        border[5][3] = "------";
        border[5][4] = "------";
        border[5][5] = "      ";
        border[5][6] = "------";
        border[5][7] = "------";
        border[5][8] = "------";
        border[5][9] = "      ";
        border[5][10] = "------";
        border[5][11] = "------";
        border[5][12] = "------";
        border[5][13] = "------";
        border[5][14] = "      ";
        border[6][0] = "------";
        border[6][1] = "------";
        border[6][2] = "------";
        border[6][3] = "------";
        border[6][4] = "------";
        border[6][5] = "------";
        border[6][6] = "------";
        border[6][7] = "------";
        border[6][8] = "------";
        border[6][9] = "------";
        border[6][10] = "------";
        border[6][11] = "------";
        border[6][12] = "------";
        border[6][13] = "------";
        border[6][14] = "------";
        border[7][0] = "------";
        border[7][1] = "------";
        border[7][2] = "------";
        border[7][3] = "------";
        border[7][4] = "------";
        border[7][5] = "------";
        border[7][6] = "      ";
        border[7][7] = "      ";
        border[7][8] = "      ";
        border[7][9] = "------";
        border[7][10] = "------";
        border[7][11] = "------";
        border[7][12] = "------";
        border[7][13] = "------";
        border[7][14] = "------";
        border[8][0] = "------";
        border[8][1] = "------";
        border[8][2] = "------";
        border[8][3] = "------";
        border[8][4] = "------";
        border[8][5] = "------";
        border[8][6] = "      ";
        border[8][7] = "      ";
        border[8][8] = "      ";
        border[8][9] = "------";
        border[8][10] = "------";
        border[8][11] = "------";
        border[8][12] = "------";
        border[8][13] = "------";
        border[8][14] = "------";
        border[9][0] = "------";
        border[9][1] = "------";
        border[9][2] = "------";
        border[9][3] = "------";
        border[9][4] = "------";
        border[9][5] = "------";
        border[9][6] = "------";
        border[9][7] = "------";
        border[9][8] = "------";
        border[9][9] = "------";
        border[9][10] = "------";
        border[9][11] = "------";
        border[9][12] = "------";
        border[9][13] = "------";
        border[9][14] = "------";
        border[10][0] = "      ";
        border[10][1] = "------";
        border[10][2] = "------";
        border[10][3] = "------";
        border[10][4] = "------";
        border[10][5] = "      ";
        border[10][6] = "------";
        border[10][7] = "------";
        border[10][8] = "------";
        border[10][9] = "      ";
        border[10][10] = "------";
        border[10][11] = "------";
        border[10][12] = "------";
        border[10][13] = "------";
        border[10][14] = "      ";
        border[11][0] = "      ";
        border[11][1] = "      ";
        border[11][2] = "------";
        border[11][3] = "------";
        border[11][4] = "      ";
        border[11][5] = "      ";
        border[11][6] = "------";
        border[11][7] = "------";
        border[11][8] = "------";
        border[11][9] = "      ";
        border[11][10] = "      ";
        border[11][11] = "------";
        border[11][12] = "------";
        border[11][13] = "      ";
        border[11][14] = "      ";
        border[12][0] = "      ";
        border[12][1] = "      ";
        border[12][2] = "------";
        border[12][3] = "------";
        border[12][4] = "      ";
        border[12][5] = "      ";
        border[12][6] = "------";
        border[12][7] = "------";
        border[12][8] = "------";
        border[12][9] = "      ";
        border[12][10] = "      ";
        border[12][11] = "------";
        border[12][12] = "------";
        border[12][13] = "      ";
        border[12][14] = "      ";
        border[13][0] = "      ";
        border[13][1] = "      ";
        border[13][2] = "------";
        border[13][3] = "------";
        border[13][4] = "      ";
        border[13][5] = "      ";
        border[13][6] = "------";
        border[13][7] = "------";
        border[13][8] = "------";
        border[13][9] = "      ";
        border[13][10] = "      ";
        border[13][11] = "------";
        border[13][12] = "------";
        border[13][13] = "      ";
        border[13][14] = "      ";
        border[14][0] = "      ";
        border[14][1] = "------";
        border[14][2] = "------";
        border[14][3] = "------";
        border[14][4] = "------";
        border[14][5] = "      ";
        border[14][6] = "------";
        border[14][7] = "------";
        border[14][8] = "------";
        border[14][9] = "      ";
        border[14][10] = "------";
        border[14][11] = "------";
        border[14][12] = "------";
        border[14][13] = "------";
        border[14][14] = "      ";
        border[15][0] = "------";
        border[15][1] = "------";
        border[15][2] = "------";
        border[15][3] = "------";
        border[15][4] = "------";
        border[15][5] = "------";
        border[15][6] = "------";
        border[15][7] = "------";
        border[15][8] = "------";
        border[15][9] = "------";
        border[15][10] = "------";
        border[15][11] = "------";
        border[15][12] = "------";
        border[15][13] = "------";
        border[15][14] = "------";
    }

    public void initializePieces(Player player){
        String color = player.getColor();
        int[][] coordinates = positionMap.get(color);
        for(int i=0;i<4;i++){
            int xCoordinate = coordinates[i][0];
            int yCoordinate = coordinates[i][1];
            setPieceCoordinates(player.getPieces().get(i), xCoordinate, yCoordinate);
        }
    }

    public void setPieceCoordinates(Piece piece, int xCoordinate, int yCoordinate){
        boolean notInitialized = (piece.getXCoordinate() == 0 && piece.getYCoordinate() == 0);
        if(notInitialized){
            pieceRecord[xCoordinate][yCoordinate][0] = piece;
            piece.setXCoordinate(xCoordinate);
            piece.setYCoordinate(yCoordinate);
        }else{
            // sort out the block the piece was currently in

            int currentY = piece.getYCoordinate();
            int currentX = piece.getXCoordinate();

            for(int i=0; i<pieceRecord[currentY][currentX].length; i++) {

                if(pieceRecord[currentY][currentX][i]==piece) {

                    pieceRecord[currentY][currentX][i] = null;

                    rearrangeBlock(currentY, currentX);
                    break;

                }

            }

            // sort out new piece's block
            pieceRecord[xCoordinate][yCoordinate][3] = piece;
            piece.setYCoordinate(yCoordinate);
            piece.setXCoordinate(xCoordinate);
            rearrangeBlock(yCoordinate, xCoordinate);
        }


    }

    private void rearrangeBlock(int yCoord, int xCoord) {

        List<Piece> pieceList = new ArrayList<Piece>();

        for(int i=0; i<4; i++) {

            Piece piece = pieceRecord[yCoord][xCoord][i];

            if(piece!=null) {

                pieceList.add(piece);
                pieceRecord[yCoord][xCoord][i] = null;

            }

        }

        if(pieceList.size()!=0) {

            int numberOfPieces = pieceList.size();

            for(int i=0; i<numberOfPieces; i++) {

                int lowestPieceNumber = 5;
                int lowestPieceIndex = 5;

                for(int j=i; j<numberOfPieces; j++) {

                    int nextPieceNumber = pieceList.get(j).getNumber();
                    boolean isLower = nextPieceNumber < lowestPieceNumber;

                    if(isLower) {

                        lowestPieceNumber = nextPieceNumber;
                        lowestPieceIndex = j;

                    }
                    lowestPieceNumber = isLower ? nextPieceNumber : lowestPieceNumber;

                }

                pieceRecord[yCoord][xCoord][i] = pieceList.get(lowestPieceIndex);

            }

        }

    }

    public boolean takePieceOut(Piece piece){
        if(piece.isTakenOut()){
            return false;
        }
        boolean successfullyMovedOut = movePiece(piece, 6);
        if(successfullyMovedOut){
            piece.setTakenOut(true);
            return true;
        }
        return false;
    }

    public boolean movePiece(Piece piece, int howManySquares){
        if(!piece.isTakenOut() && howManySquares != 6){
            return false;
        }
        String color = piece.getColor();
        int[][] path = pathMap.get(color);
        int currentXCoordinate = piece.getXCoordinate();
        int currentYCoordinate = piece.getYCoordinate();
        int currentBlock = 0;
        for(int i=0;i<path.length;i++){
            if(path[i][0] == currentXCoordinate && path[i][1] == currentYCoordinate){
                currentBlock = i;
                break;
            }
        }
        int endPosition = currentBlock + howManySquares;
        if(endPosition >= path.length){
            return false;
        }
        for(int i=currentBlock+1;i<=endPosition;i++){
            if(isBlocked(piece, path[i][0], path[i][1])){
                return false;
            }
        }
        if(containsOneEnemyPiece(piece, path[endPosition][0], path[endPosition][1])){
            consumeEnemy(path[endPosition][0], path[endPosition][1]);
        }
        if(!piece.isTakenOut()){
            setPieceCoordinates(piece, path[endPosition-1][0], path[endPosition-1][1]);
            piece.setTakenOut(true);
        }else{
            setPieceCoordinates(piece, path[endPosition][0], path[endPosition][1]);
        }
        if(endPosition+1==path.length)
            piece.setCompleted(true);
        return true;
    }

    private boolean containsOneEnemyPiece(Piece piece, int xCoordinate, int yCoordinate){
        List<Piece> pieceList = new ArrayList<Piece>();
        for(int i=0;i<4;i++){
            Piece currentPiece= pieceRecord[xCoordinate][yCoordinate][i];
            if(currentPiece != null && piece.getColor().equals(currentPiece.getColor())){
                return true;
            }else if(currentPiece != null){
                pieceList.add(currentPiece);
            }else{
                break;
            }
        }
        if(pieceList.size() == 1){
            return true;
        }
        return false;
    }
    public boolean movesPossible(Player player, int numberRolled){
        if(numberRolled == 6){
            for(Piece piece: player.getPieces()){
                if(canTakePieceOut(piece)){
                    return true;
                }
            }
        }
        for(Piece piece: player.getPieces()){
            if(canMovePiece(piece, numberRolled)){
                return true;
            }
        }
        return false;
    }

    private boolean canTakePieceOut(Piece piece){
        if(piece.isTakenOut()){
            return false;
        }
        boolean canMove = canMovePiece(piece, 6);
        if(canMove){
            return true;
        }
        return false;
    }

    private boolean canMovePiece(Piece piece, int howManySquares){
        if(!piece.isTakenOut() && howManySquares != 6){
            return false;
        }
        String color = piece.getColor();
        int[][] path = pathMap.get(color);
        int xCoordinate = piece.getXCoordinate();
        int yCoordinate = piece.getYCoordinate();
        int currentBlock = 0;

        for(int i=0;i<path.length;i++){
            if((path[i][0] == xCoordinate) && (path[i][1] == yCoordinate)){
                currentBlock = i;
                break;
            }
        }
        int endPosition = currentBlock + howManySquares;
        if(endPosition >= path.length){
            return false;
        }
        for(int i=currentBlock+1;i<=endPosition;i++){
            if(isBlocked(piece, path[i][0], path[i][1])){
                return false;
            }
        }
        return true;
    }

    private boolean isBlocked(Piece piece, int xCoordinate, int yCoordinate){
        List<Piece> pieces = new ArrayList<>();
        for(int i=0;i<4;i++){
            Piece currentPiece = pieceRecord[xCoordinate][yCoordinate][i];
            if(currentPiece != null && piece.getColor().equals(currentPiece.getColor())){
                return false;
            }else if(currentPiece != null){
                return true;
            }else{
                break;
            }
        }
        return false;
    }

    private void consumeEnemy(int xCoordinate, int yCoordinate){
        Piece piece = pieceRecord[xCoordinate][yCoordinate][0];
        String color = piece.getColor();
        int[][] homeCoordinates = positionMap.get(color);
        for(int i=0;i<4;i++){
            int homeXCoordinate = homeCoordinates[i][0];
            int homeYCoordinate = homeCoordinates[i][1];
            if(pieceRecord[homeXCoordinate][homeYCoordinate][0] == null){
                piece.setTakenOut(false);
                setPieceCoordinates(piece, homeXCoordinate, homeYCoordinate);
                break;
            }
        }
    }


  public static void main(String[] args) {
    //
      new LudoBoard();
  }
}
