package com.Joeleniqs.LearningAlgorithm;

public class floodFill {
    int [][] pixelArray;
    int fillColor,startingPixelColor;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        fillColor = newColor;pixelArray = image;startingPixelColor = image[sr][sc];
        image[sr][sc] = fillColor;
        return floodFill(sr,sc);
    }
    public int[][] floodFill(int sr ,int sc ){
        checkTop(sr-1 , sc );
        checkLeft( sr , sc-1 );
        checkRight( sr , sc +1);
        checkBottom( sr+1 , sc );

        return pixelArray;
    }
    public void checkTop(int sr ,int sc ){
        if((sr)>=0){
            if(pixelArray[sr][sc] == startingPixelColor){
                pixelArray[sr][sc] = fillColor;
                floodFill(sr,sc);
            }
        }

    }
    public void checkLeft(int r ,int c ){
        if((c)>=0){
            if(pixelArray[r][c] == startingPixelColor){
                pixelArray[r][c] = fillColor;
                floodFill(r,c);
            }
        }
    }
    public void checkRight(int srs ,int scs ){
        if((scs)<pixelArray[0].length){
            if(pixelArray[srs][scs] == startingPixelColor){
                pixelArray[srs][scs] = fillColor;
                floodFill(srs,scs);
            }
        }
    }
    public void checkBottom(int row ,int col ){
        if((row)<pixelArray.length){
            if(pixelArray[row][col] == startingPixelColor){
                pixelArray[row][col] = fillColor;
                floodFill(row,col);
            }
        }
    }

}
