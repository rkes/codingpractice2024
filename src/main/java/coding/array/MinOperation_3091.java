package coding.array;

public class MinOperation_3091 {
    public static void main(String[] args) {
        System.out.println(minOperations(2));
    }
    public static int minOperations(int k) {
        int []ar = {1};
        int n = 1;
        int cnt = Integer.MAX_VALUE;
        int i;
        int replicas = 1;
        for(i=1;i<k;i++){
            n = 1;
            int localCnt = 1;
            while (n*i< k){
                localCnt++;
                n++;
            }
            if(cnt > (localCnt + i )){
                cnt = localCnt+i;
                replicas = localCnt;
            }
        }
        int incr = replicas - 1;
        return incr + ((int)Math.ceil(k/(double)replicas)-1);
    }
}
