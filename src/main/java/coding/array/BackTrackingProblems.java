package coding.array;

import java.util.ArrayList;
import java.util.List;

public class BackTrackingProblems {
    public static void main(String[] args) {
        int [][]board = {
                        {5, 3, 0, 0, 7, 0, 0, 0, 0},
                        {6, 0, 0, 1, 9, 5, 0, 0, 0},
                        {0, 9, 8, 0, 0, 0, 0, 6, 0},
                        {8, 0, 0, 0, 6, 0, 0, 0, 3},
                        {4, 0, 0, 8, 0, 3, 0, 0, 1},
                        {7, 0, 0, 0, 2, 0, 0, 0, 6},
                        {0, 6, 0, 0, 0, 0, 2, 8, 0},
                        {0, 0, 0, 4, 1, 9, 0, 0, 5},
                        {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
       // System.out.println(solveSudoku(board,0));
        char [][]board2 = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        //System.out.println(isValidSudoku(board2));
    }
    public static boolean solveSudoku(int[][] ar,int cnt){
        if(cnt == 9*9) return true;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(ar[i][j]==0){
                    for(int k=1;k<=9;k++){
                        if(isValid(ar,i,j,k)){
                            ar[i][j] = k;
                            if(solveSudoku(ar,cnt+1)){
                                return true;
                            }
                            ar[i][j] = 0;
                        }
                    }
                    //not able to find any number to insert
                    return false;
                }
            }
        }
        return true;
    }
    public static  boolean isValid(int [][]ar,int r,int c,int num){
        //check row
        for(int i=0;i<9;i++){
            if(ar[r][i] == num) return false;
        }
        //check column
        for(int i=0;i<9;i++){
            if(ar[i][c] ==num ) return false;
        }
        //check in 3 by 3 section
        int row = (r/3)*3; //row index in that grid
        int col = (c/3)*3; //row index in that grid
        for(int i=row;i<row+3;i++){
            for(int j=col;j<col+3;j++){
                if(ar[i][j] == num) return false;
            }
        }
        return true;
    }
    public static boolean solveSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == '.'){
                    for(int k=1;k<=9;k++){
                        char c = (char)('0'+k);
                        if(isValid2(board,i,j,c)){
                            board[i][j] = c;
                            if(solveSudoku(board)){
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }

            }
        }
        return true;
    }
    public static boolean isValid2(char [][]board,int r,int c,char ch){
        for(int i=0;i<9;i++){
            if(board[r][i] == ch){
                return false;
            }
        }
        for(int i=0;i<9;i++){
            if(board[i][c] == ch ) return false;
        }
        int row = (r/3)*3;
        int col = (c/3)*3;
        for(int i=row;i<row+3;i++){
            for(int j=col;j<col+3;j++){
                if(board[i][j] == ch) return false;
            }
        }
        return true;
    }
}
