package coding.array;

import java.util.HashMap;
import java.util.Map;

public class LeetCodeContest {
    public static void main(String[] args) {
       // System.out.println(isSubstringPresent("e"));
        //goxo
        //leetcode
        System.out.println(countSubstr("ocu",'o'));
    }
    public static int minimumDeletions(String word, int k) {
        if (k == 0) {
            Map<Character, Integer> freq = new HashMap<>();
            for (char c : word.toCharArray()) {
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }
            int maxFreq = 0;
            for (int count : freq.values()) {
                maxFreq = Math.max(maxFreq, count);
            }
            return word.length() - maxFreq;
        }

        Map<Character, Integer> freq = new HashMap<>();
        int n = word.length();
        int deletions = 0;

        for (char c : word.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            int minFreq = Integer.MAX_VALUE;
            int maxFreq = Integer.MIN_VALUE;
            for (int j = Math.max(0, i - k); j < Math.min(n, i + k + 1); j++) {
                char ch = word.charAt(j);
                minFreq = Math.min(minFreq, freq.get(ch));
                maxFreq = Math.max(maxFreq, freq.get(ch));
            }
            if (maxFreq - minFreq > k) {
                deletions++;
            }
        }

        return deletions;
    }
    static long countSubstr(String str,char c)
    {
        long count = 0;
        long countStart = 0;
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) == c)
            {
                countStart+=1;
                count += countStart;
            }
        }
        return count;
    }

    static public long countSubstrings(String s, char c) {
         long count = 0;
         for(int i=0;i<s.length();i++){
             for(int j=i;j<s.length();j++){
                 String subStr = s.substring(i,j+1);
                 if(subStr.charAt(0) == c && subStr.charAt(subStr.length()-1) == c){
                     count ++;
                 }
             }
         }
         return count;
    }
    public static boolean isSubstringPresent(String s) {
        if(s.length() == 1){
            return false;
        }
        if(isPalindrome(s)){
            return  true;
        }
        for(int i=0;i<=s.length()-2;i++){
            String subStr =  s.substring(i,i+2);
            if(isPalindrome(subStr)){
                return true;
            }
        }
        for(int i=0;i<=s.length()-3;i++){
            String subStr =  s.substring(i,i+3);
            if(isPalindrome(subStr)){
                return true;
            }
        }
        return false;
    }
    public static  boolean isPalindrome(String s){
        //int end = s.length();
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length() -i -1)){
                return  false;
            }
        }
        return  true;
    }
}
