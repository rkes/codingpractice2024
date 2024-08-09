package coding.graph;

import java.util.Arrays;
import java.util.TreeSet;

public class SearchWordInMatrix {
    static {
        test(10);
    }
    {test(15);}

    static void test(int a){
        System.out.println(a);
    }
    static boolean isValidMove(int [][]nums,int start,int end){
        if(start > nums.length || end >nums[start].length) return false;
        return nums[start][end] == 1;
    }

    public void dfs_check(int [][]nums,boolean [][]isVisited){
        int[] rd = {-1,-1,-1,0,0,1,1,1};
        int[] cd = {0,-1,1,};
    }
    public static int numIslands2(int [][]nums){
        boolean[][] visited = new boolean[nums.length][nums[0].length];
        Arrays.fill(visited,false);
        int count = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[i].length;j++){
                if(!visited[i][j] && isValidMove(nums,i,j)){
                    count++;
                    visited[i][j] = false;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        char [][]chArs = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE";
        //System.out.println(exist(chArs,word));
        //System.out.println(numIslands(new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}}));
        TreeSet<String> strings = new TreeSet<>();
        strings.add("A");
        strings.add("A");
        System.out.println(strings);
        System.out.println(numIslands(new int[][]
                {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}}));

    }

    public static boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++ ){
            for(int j=0;j<board[0].length;j++){
                if(findWord(board,word,i,j,0)) return true;
            }
        }
        return false;
    }
    public static boolean findWord(char[][] board,String word,int i,int j,int indx){
        if(word.length()==indx){
            return true;
        }
        int []dx={0,-1,0,1};
        int []dy={1,0,-1,0};
        if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]!=word.charAt(indx)) return false;
        char ch = board[i][j];
        board[i][j] = '#';//to stop looking same character
        for(int k=0;k<4;k++){
            if(findWord(board,word,dx[k]+i,dy[k]+j,indx+1))
                return true;
        }
        board[i][j] = ch;
        return false;
    }
    public static int numIslands(int[][] grid) {
        boolean [][]isVisited = new boolean[grid.length][grid[0].length];
        int isLandCount = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!isVisited[i][j] && grid[i][j]==1){
                    count=1;
                    DFS(grid,i,j,isVisited);
                    System.out.printf(" %d \t",count);
                    isLandCount++;
                }
            }
        }
        return isLandCount;
    }
    public static boolean isSafe(boolean [][]isVisited,int i,int j,int [][]grid){
        return (i>=0 && j>=0 && i<grid.length && j< grid[0].length && !isVisited[i][j]
                &&grid[i][j]=='1');
    }
    static int count =0;
    public static void DFS(int [][]grid,int i,int j,boolean [][]isVisited){
        int []dx = new int[] { -1, 0, 1, 0};
        int []dy = new int[] { 0, -1, 0, 1 };
        isVisited[i][j] = true;
        for(int k=0;k<4;k++){
            if(isSafe(isVisited,dx[k]+i,dy[k]+j,grid)) {
                count++;
                DFS(grid, dx[k] + i, dy[k] + j, isVisited);
            }
        }
    }

}
