package coding.dp;

public class EditDistance {
    public static void main(String[] args) {
        String a = "leetcode";
        String b ="etco";
       // System.out.println(minDistanceRecur(a,b));
        System.out.println (del_minDistance(a,b));
    }
    //https://leetcode.com/problems/delete-operation-for-two-strings/description/
    public static int del_minDistance(String word1,String word2){
        if(word1.isEmpty()) return word2.length();
        if(word2.isEmpty()) return word1.length();
        if(word1.charAt(0)==word2.charAt(0)){
            return del_minDistance(word1.substring(1),word2.substring(1));
        }
        int x = del_minDistance(word1.substring(1),word2);
    //    int y = del_minDistance(word1.substring(1),word2.substring(1));
        int z = del_minDistance(word1,word2.substring(1));
        return Math.min(x,z)+1;
    }
    public static int minDistanceDp(String s, String b){
        int [][]dp = new int[s.length()+1][b.length()+1];
        for(int i=0;i<=s.length();i++){
            for(int j=0;j<=b.length();j++){
                if(i==0){
                    dp[i][j] = j;
                }
                else if(j==0){
                    dp[i][j] = i;
                }
                else if(s.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(s.charAt(i-1)!=b.charAt(j-1)){
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]))+1;
                }
            }
        }
        return dp[s.length()][b.length()];
    }
    public static int minDistanceRecur(String s, String b){
        if(s.isEmpty() ){
            return b.length();
        }
        if(b.isEmpty()){
            return s.length();
        }
        if(s.charAt(0)==b.charAt(0)){
            return minDistanceRecur(s.substring(1),b.substring(1));
        }

        return Math.min( minDistanceRecur(s.substring(1),b),
                Math.min(minDistanceRecur(s.substring(1),b.substring(1)),
                        minDistanceRecur(s,b.substring(1))))+1;
    }

}
