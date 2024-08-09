package coding.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;
import java.lang.Math;
public class ClosestSum {
    public static void main(String[] args) {
        Integer []ar = {4,0,5,-5,3,3,0,-4,-5};
       // System.out.println(threeSumClosest(ar,-2));
        int[] nums = new int[]{1,2,3};
        System.out.println(sumOfEncryptedInt(nums));
    }

    public static int threeSumClosest(Integer[] ar, int target) {
        Arrays.sort(ar);
        int min_sum = Integer.MAX_VALUE;

        for(int i=0;i<ar.length-2;i++){
             int j = i+1;
             int k = ar.length -1;
             while(k>j){
                 int localSum =  ar[i]+ar[j] + ar[k];
                 if(Math.abs(target - min_sum) > Math.abs( target - localSum) ){
                     min_sum = localSum;
                 }
                 if(localSum > target){
                    k--;
                 }else{
                     j++;
                 }

             }
        }
        return min_sum;
    }

    public static int sumOfEncryptedInt(int[] nums) {
       int sum = 0;
       for(int k:nums){
           sum+=encrypted(k);
       }
       return sum;
    }
    public  static int encrypted(int num){
        String strNum = String.valueOf(num);
        char []chAr = strNum.toCharArray();
        Arrays.sort(chAr);
        char c  = chAr[chAr.length-1];
        Arrays.fill(chAr,c);
        return Integer.parseInt(String.valueOf(chAr));
    }
}
