package coding.array;

import java.util.*;
import java.util.stream.Collectors;

public class PivotIndex {

    public static void main(String[] args) {
        int []ar={2,1,-1    };
      //  System.out.println(findPivotIndex(ar));
        String s = "abaaaaabcaaaabbbcccccbbba";
  //      System.out.println(s.chars().distinct().mapToObj(c->String.valueOf((char)(c))).collect(Collectors.toList()));
   //     System.out.println(isIsomorphic("badc","baba"));
        System.out.println(isSubsequence("axc","ahbgdc"));
    }
    public static int findPivotIndex(int []ar){
        int l=0;
        int r=ar.length;
        int rightSum = Arrays.stream(ar).sum();
        int leftSum = 0;
        for(int i=0;i<ar.length;i++){
            rightSum -=ar[i];
            if(leftSum == rightSum){
                return i;
            }
            leftSum +=ar[i];
        }
        return -1;
    }

    public static boolean isIsomorphic(String s, String t) {
       // int n = s.chars().distinct().map(c->c);
        List<String> sUniqueChars = s.chars().distinct().mapToObj(c->String.valueOf((char) c)).collect(Collectors.toList());
        List<String> tUniqueChars = s.chars().distinct().mapToObj(c->String.valueOf((char) c)).collect(Collectors.toList());
        if(s.length()!=t.length()||sUniqueChars.size()!=tUniqueChars.size()) return false;
        int []freq = new int[s.length()];
        int idx=0;
        int count =0;
        freq[0] = 1;
        Map<String,String> sMpRule = new HashMap<>();
        Map<String,String> tMpRule = new HashMap<>();
        Set<String> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(sMpRule.get(String.valueOf(s.charAt(i)))==null && (tMpRule.get(String.valueOf(t.charAt(i)))==null)){
                sMpRule.put(String.valueOf(s.charAt(i)),String.valueOf(t.charAt(i)));
                tMpRule.put(String.valueOf(t.charAt(i)),String.valueOf(s.charAt(i)));
            }
            else{
                if(!Objects.equals(sMpRule.get(String.valueOf(s.charAt(i))), String.valueOf(t.charAt(i)))){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isSubsequence(String s, String t) {
      //  int []ar = new int[256];
        int j=0;
        for(int i=0;i<t.length();i++){
            if(t.charAt(i)==s.charAt(j)){
                j++;
            }
        }
        return j >= s.length();
    }

}
