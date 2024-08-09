package coding.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.*;
public class Contest {
    public static void main(String[] args) {
        int [][]ar = {
                {3, 2},
                {3, 9},
                {7, 10},
                {4, 4},
                {8, 10},
                {2, 7}
       };
        //System.out.println(minimumLevels(ar));
        //System.out.println(minimumDistance(ar));
        //System.out.println(maxWaterBottles(13,6));
        System.out.println(lengthOfLastWord( "a"));
    }
    public static int lengthOfLastWord(String s) {
        List<String> strs = Arrays.stream(s.trim().split(" ")).map(String::trim).filter(x->x.length()>=1).collect(Collectors.toList());
        if(strs.size() == 0){
            return 0;
        }
        return strs.get(strs.size()-1).length();
    }
    public static int countAlternatingSubarrays(int []nums){
        int cnt = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isAlternate(nums,i,j)){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static boolean isAlternate(int []nums,int s,int e){
        for(int i=s+1;i<=e;i++){
            if(nums[i] == nums[i-1]){
                return false;
            }
        }
        return true;
    }
    public static int minimumDistance(int[][] points) {
        int n = points.length;
        int maxDistance = 0;

        // Calculate the maximum distance between any two points
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                maxDistance = Math.max(maxDistance, distance);
            }
        }

        int minMaxDistance = Integer.MAX_VALUE;

        // Simulate removing each point and recalculate the maximum distance
        for (int i = 0; i < n; i++) {
            int maxDistanceAfterRemoval = 0;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                    maxDistanceAfterRemoval = Math.max(maxDistanceAfterRemoval, distance);
                }
            }
            // Update the minimum possible value for the maximum distance
            minMaxDistance = Math.min(minMaxDistance, maxDistanceAfterRemoval);
        }

        return Math.max(minMaxDistance, maxDistance);

    }
    public static long countAlternatingSubarraysOP(int[] nums) {
        int n = nums.length;
        long count = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (right > 0 && nums[right] == nums[right - 1]) {
                left = right;
            }
            count += right - left + 1;
        }

        return count;
    }
    
    public static int maxWaterBottles(int numBottles, int numExchange) {
       int fb = numBottles;
       int x = numExchange;
       int finalValue = 0;
       int empty = 0;
       while (fb!=0){
           int cnt = fb+finalValue;
           empty = empty + fb;
           fb = 0;
           while(empty >= x){
               fb++;
               empty = empty -x;
               x++;
           }
           finalValue = Math.max(cnt,finalValue);
       }
       return finalValue;
    }
    public  static int sumOfTheDigitsOfHarshadNumber(int x) {
        String s = String.valueOf(x);
        if(s.length() == 1) return x;
        Integer sumDigit = s.chars().mapToObj(i->(char)i).map(j->j-'0').mapToInt(i->i).sum();
        if(x%sumDigit == 0) return sumDigit;
        return -1;
    }
    public static int minimumLevels(int[] possible) {
        int totalPoints = possible.length;
        int danielPoints = 0;
        int bobPoints = 0;
        int maxDiff = Integer.MIN_VALUE;
        for(int i=0;i<possible.length;i++){
            if(possible[i] == 1){
                danielPoints++;
            }
            bobPoints = possible.length - danielPoints;
            maxDiff = Math.max(maxDiff,danielPoints - bobPoints);
        }
        if(maxDiff<=0){
            return -1;
        }
        for(int i=1;i<=possible.length;i++){
            if(danielPoints - i> bobPoints){
                return  i;
            }
        }
        return  -1;
    }
    public static int shortestSpecialSubarray(int[] nums, int k) {
        int n = nums.length;
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int or = 0;
                for (int p = i; p <= j; p++) {
                    or = or | nums[p];
                }
                if (or >= k) {
                    minLen = Math.min(minLen, j - i + 1);
                }
            }
        }
        if(minLen == Integer.MAX_VALUE) return -1;
        return minLen;
    }
}

