package coding.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrintPermutation {

    public static void main(String[] args) {
        Integer []ar={1,2,3,4};
        List<List<Integer>> lst = printPermutation(ar,0,ar.length-1);
        for(List<Integer> list:lst){
            System.out.println(list.stream().map(Object::toString)
                    .collect(Collectors.joining(", "))
            );
        }
    }


    static List<List<Integer>> printPermutation(Integer []ar, int start, int end){
        List<List<Integer>> lst = new ArrayList<>();
        if(start==end){
            lst.add(Arrays.asList(ar));
            return lst;
        }else{
            for(int i=start;i<=end;i++){
                swap(i,start,ar);
                List<List<Integer>> op=printPermutation(ar,start+1,end);
                swap(i,start,ar);
                lst.addAll(op);
            }
        }
        return lst;
    }
    static void swap(int a,int b,Integer []ar){
        int temp = ar[a];
        ar[a] = ar[b];
        ar[b] = temp;
    }

}
