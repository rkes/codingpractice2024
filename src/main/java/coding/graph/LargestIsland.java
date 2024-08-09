package coding.graph;

import coding.java8.Coding;

public class LargestIsland {
    public static void main(String[] args) {

        Coding.T1 t1 = new Coding.T1();

        int [][]mat = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int maxSizeOfLand = 0;
        boolean [][]visited = new boolean[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++){
            int islandSize = 0;
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1 && !visited[i][j]){
                    maxSizeOfLand = Math.max(dfs(mat,visited,i,j),maxSizeOfLand);
                }
            }
        }
        System.out.println(maxSizeOfLand);
    }
    public static int dfs(int [][]mat,boolean [][]visited,int row,int col){
        if( row<0 || col<0 || row>=mat.length || col>=mat[0].length || visited[row][col] || mat[row][col]==0)
            return 0;
        visited[row][col] = true;
        return dfs(mat,visited,row+1,col) +
                dfs(mat,visited,row,col-1)+
                dfs(mat,visited,row-1,col)+
                dfs(mat,visited,row,col+1)+1;

    }
}
