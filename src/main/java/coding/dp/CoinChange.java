package coding.dp;

import java.util.List;

public class CoinChange {

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{2},3));
    }
    public static int coinChangeDP(int []coins,int amount){
        int []dp = new int[coins.length+1];
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                dp[j] = Math.min(dp[j],dp[j-coins[i]]);
            }
        }
        return dp[0];
    }
    public static int coinChange(int[] coins, int amount) {
        int result = coinChangeHelper(coins,amount);
        if(result==Integer.MAX_VALUE) return -1;
        return result;
    }
    public static int coinChangeHelper(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }
        if(amount<0) return Integer.MAX_VALUE;
        int count = Integer.MAX_VALUE;
        for(int x:coins){
            int result = coinChangeHelper(coins,amount-x);
            if(result!=Integer.MAX_VALUE){
                count = Math.min(result+1,count);
            }
        }

        return count;
    }
    public static long getWays(int n , List<Long> c,int start){
        if(n==0){
            return 1;
        }
        for(int i=start;i<c.size();i++){
            long val = c.get(i);
            if(((long)n)%val == 0L){
                return 1+getWays(n,c,start+1);
            }
            else{
                if(val>n){
                    return 0;
                }
                long res = getWays(n-(int)val,c,start+1);

            }
        }

        throw new UnsupportedOperationException("Method not implemented");
    }

}
