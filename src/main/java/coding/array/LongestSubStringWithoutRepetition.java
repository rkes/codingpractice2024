package coding.array;

import java.util.*;

public class LongestSubStringWithoutRepetition {

    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
        int []ar={1,3,2,6,-1,4,1,8,2};
        int []br = {1,1,2,2,2,2,3};
        br  = new int[]{12,12,12,12};
        System.out.println(count(br,br.length,12));
        System.out.println("*****************");
        longestNiceSubarray(new int[]{1,3,8,48,10});
        HashMap<Integer,Integer> mp = new HashMap<Integer,Integer>();
        int left=0;
        int right=0;
        int k =5;
        while(right<ar.length){
            int winSize =0;
            int end= right+k;
            for(int i=left;end<ar.length && i<end;i++){
                mp.compute(ar[i],(key,val)-> val==null?1:val+1);
                if(mp.get(ar[i])==1){
                    winSize++;
                }else{
                    left++;
                    right++;
                    break;
                }
                if(winSize>=k) break;
            }
            if(winSize>=k) break;
        }
        System.out.println(mp);
    }
    public static int longestNiceSubarray(int[] nums) {
        int lft=0;
        int rght = 1;
        Map<Integer,Set<Integer>> mp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                final int jInner = j;
                if(j!=i){
                    if((nums[i] & nums[j])==0){
                        mp.compute(i,(k,v)->{
                            if(v==null){
                                v = new HashSet<>();
                            }
                            v.add(jInner);
                            return v;
                        });
                    }
                }
            }
        }
        int maxCnt=0;
        Map<Integer,Integer> effectiveCntMap = new HashMap<>();
        for(Map.Entry<Integer,Set<Integer>> mpEntry:mp.entrySet()){
            int key = mpEntry.getKey();
            int effectiveCnt =0;
            for(Integer setVal:mpEntry.getValue()){
                if(mp.get(setVal).contains(key)){
                    effectiveCnt++;
                }
            }
            effectiveCntMap.put(key,effectiveCnt);
        }
        System.out.println(effectiveCntMap);
        return  0;
    }
    static int count(int[] ar, int n, int x) {
        // code here
        int low=0;
        int high = ar.length-1;
        int mid = (low+high)/2;
        int lowIdx = 0;
        int highIdx =0;
        while(low<=high){
            if(mid-1>=0&&ar[mid]==x&&ar[mid]>ar[mid-1]){
                lowIdx = mid;
                break;
            }
            else if(x>ar[mid]){
                low = mid+1;
            }else{
                high = mid-1;
            }
            mid = (low+high)/2;
        }

        low =lowIdx;
        high=ar.length-1;
        mid=(low+high)/2;

        while(low<=high){
            if(ar[mid]==x && ((ar.length>mid+1 && ar[mid+1]>ar[mid])||mid==ar.length-1) ){
                highIdx = mid;
                break;
            }
            else if(ar[mid]>x){
                high = mid-1;
            }else{
                low = mid+1;
            }
            mid = (low+high)/2;
        }
        System.out.println(lowIdx+" "+highIdx);
        return highIdx-lowIdx+1;
    }
    public static int lengthOfLongestSubstring(String s) {
        char []chAr = s.toCharArray();
        Map<Character,Integer> characterIntegerMap = new HashMap<>();
        int maxWinSize =0;
        int lft = 0;
        int right = 0;
        while(lft<chAr.length && right<chAr.length){
            if(characterIntegerMap.get(s.charAt(right))==null){
                characterIntegerMap.put(s.charAt(right),1);
                right++;
                maxWinSize = Math.max(maxWinSize,right-lft);
            }else{
                characterIntegerMap.remove(s.charAt(lft));
                lft++;

            }
        }
       return maxWinSize;

    }

}
