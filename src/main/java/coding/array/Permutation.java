package coding.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Permutation {
    public static void main(String[] args) {
        String s= "ABC";
        List<String> res = new ArrayList<>(findPermutationRecur(s.toCharArray(),0));
        System.out.println(90);
    }
    public static Set<String> findPermutationRecur(char []chAr, int start){
        Set<String> res = new HashSet<>();
        if(start>=chAr.length){
            return res;
        }
        res.add(new String(chAr));
        for(int i=start;i<chAr.length;i++){
            swap(chAr,i,start);
            Set<String> op = findPermutationRecur(chAr,start+1);
            swap(chAr,i,start);
            res.addAll(op);
        }
        return res;

    }
    public static void swap(char []chAr,int a,int b){
        char temp  =chAr[a];
        chAr[a] = chAr[b];
        chAr[b] = temp;
    }

}
