package coding.array;

import java.util.*;
import java.util.stream.Collectors;

public class SlidingWindow {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aab"));
    }
    public static int lengthOfLongestSubstring(String s){
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        int i=0,j=0;
        int maxLen = 0;
        if(s.length()==1){
            return 1;
        }
        HashSet<Character> set2 = (s.chars().mapToObj(x->(char) x).collect(Collectors.toCollection(HashSet::new)));
        if(s.length()==set2.size()){
            return set2.size();
        }
        while(j<s.length()){
            char c = s.charAt(j);
            if(set.contains(c)){
                maxLen = Math.max(maxLen,set.size());
                Iterator<Character> itr = set.iterator();
                while (itr.hasNext()){
                   Character ct = itr.next();
                   itr.remove();
                   if(ct==c){
                       break;
                   }
                }
               i++;
               set.add(c);
            }else{
                set.add(c);
            }
            j++;
        }
        return maxLen;
    }
}
