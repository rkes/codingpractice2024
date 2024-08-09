package coding.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringCode {
    public static void main(String[] args) {
        /*System.out.println(removeDigit("123",'3'));
        System.out.println(removeDigit("1231",'1'));
        System.out.println(removeDigit("551",'5'));
        System.out.println(removeDigit("13333",'3'));
        System.out.println(removeDigit("133235",'3'));
        System.out.println(removeDigit("299858953917872714814599237991174513476623756395992135212546127959342974628712329595771672911914471",'3'));
        */
        //System.out.println(maximumLengthSubstring("aabcbdd"));
      //  System.out.println(gcdOfStrings("LEET","CODE"));
        //System.out.println(mergeAlternately("abcd","pq"));
        int []ar={1,2,9899909,5,6,8,12};
        reverseWords("a good   example");
        //System.out.println(Arrays.stream(ar).max().getAsInt());
    }
    public static String reverseWords(String s) {
        s  = s.trim();
        String finalStr = "";
        String sep = null;
        StringBuilder str = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            String c = String.valueOf(s.charAt(i)).trim();
            if(!c.isEmpty()){
                if(sep != null){
                    finalStr +=  str + " ";
                    sep = null;
                    str = new StringBuilder();
                }
                str.insert(0, c);
            }else {
                sep = "";
            }
        }
        if(str.length() > 0 ){
            finalStr += str;
        }
        finalStr = finalStr.trim();
        System.out.println(finalStr);
        return finalStr;
    }
    public static String reverseWordRecur(List<String> strs,String tempSTr,int indx){
        for(int i=indx;i<strs.size();i++){
            reverseWordRecur(strs,strs.get(i),indx+1);
        }
        System.out.println(tempSTr);
        return "";
    }
    public static String gcdOfStrings(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int i = Math.min(m,n);
        while(i>=1){
            if(isValid(str1,str2,i)){
                return str1.substring(0,i);
            }
            i--;
        }
        return "";
    }
    public static boolean isValid(String str1 , String str2 , int len){
        String subStr = str1.substring(0,len);
        return(str1.replace(subStr,"").isEmpty() && str2.replace(subStr,"").isEmpty() );
    }
    public static String gcdOfStrings2(String str1, String str2) {
        if (str2.length() > str1.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        String maxStr = "";
        for(int i=0;i<str2.length();i++){
            char c = str2.charAt(i);
            int indx = str1.indexOf(c);
            StringBuilder tempStr = new StringBuilder();
            StringBuilder divStr = new StringBuilder();
            while(indx < str2.length() && str1.charAt(indx) == str2.charAt(indx)){
                tempStr.append(str1.charAt(indx));
                indx++;
                boolean ableToDivide = false;

            }
            boolean ableToDivide = false;
            tempStr = new StringBuilder();
            for(int j=0;j<str2.length();j++){
                tempStr.append(maxStr);
                if(tempStr.equals(maxStr)) ableToDivide = true;
            }
            if(ableToDivide && tempStr.length()> maxStr.length()){
                maxStr = tempStr.toString();
            }
        }
        return maxStr;
    }
    public static String mergeAlternately(String word1, String word2) {
        int i=0,j=0;
        StringBuilder s = new StringBuilder();
        while( i < word1.length() ){
            s.append(word1.charAt(i));
            if( i < word2.length()){
                s.append(word2.charAt(i));
            }
            i++;
        }
        while (i< word2.length()) s.append(word2.charAt(i++));
        return s.toString();
    }
    public static String removeDigit(String number, char digit) {
        String num = "";
        for(int i=0;i<number.length();i++){
            if(number.charAt(i) == digit){
                int indx = i;
                String n = "";
                if(indx == 0 ){
                    n =  number.substring(1);
                }
                else if(indx == number.length()-1){
                    n = number.substring(0,number.length()-1);
                }else {
                    n = number.substring(0, indx) + number.substring(indx + 1);
                }
                if( n .compareTo(num) > 0){
                    num = n;
                }
            }
        }
        return num;
    }
    public static int maximumLengthSubstringBF(String s) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substr = s.substring(i, j);
                if (isValidSubstring(substr)) {
                    maxLength = Math.max(maxLength, j - i);
                }
            }
        }
        return maxLength;
    }

    private static boolean isValidSubstring(String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            if (charCount.get(c) > 2) {
                return false;
            }
        }
        return true;
    }

    static int maximumLengthSubstring(String s){
        int []freq = new int[256];
        Arrays.fill(freq,0);
        int ans = 0;
        for(int i=0,j=0;i<s.length();i++){
            freq[s.charAt(i)]++;
            while(i>j && freq[s.charAt(i)]>2) freq[s.charAt(j++)]--;
            ans = Math.max(ans,i-j+1);
        }
        return ans;
    }
    public static int maximumLengthSubstringSW(String s) {
        int start = 0, end = 0; // Initialize pointers start and end
        int maxLength = 0; // Initialize maximum length of valid substring
        Map<Character, Integer> charCount = new HashMap<>();

        while (end < s.length()) {
            char currentChar = s.charAt(end);
            charCount.put(currentChar, charCount.getOrDefault(currentChar, 0) + 1);
            end++;

            // Shrink the window if the substring is invalid
           /* while (!isValid(charCount)) {
                char startChar = s.charAt(start);
                charCount.put(startChar, charCount.get(startChar) - 1);
                if (charCount.get(startChar) == 0) {
                    charCount.remove(startChar);
                }
                start++;
            }*/

            // Update maximum length if a valid substring is found
            maxLength = Math.max(maxLength, end - start);
        }

        return maxLength;
    }

    /*public static boolean isValid(Map<Character, Integer> charCount) {
        for (int count : charCount.values()) {
            if (count > 2) {
                return false;
            }
        }
        return true;
    }*/
    public static boolean isInvalidSubstring(Map<Character,Integer> mp) {
        for (int count : mp.values()) {
            if (count > 2) {
                return true;
            }
        }
        return false;

    }
    public static Map<Character,Long> getCountMap(String s){
        return s.chars().mapToObj(x->(char)x).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
    }
}
