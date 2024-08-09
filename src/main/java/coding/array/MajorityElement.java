package coding.array;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement {

    public static void main(String[] args) {
        int ar[]= {3, 3, 4, 2, 4, 4, 2, 4,4 };

    }

    public static List<Integer> getNby3LargestElement(int []ar){
        int e1=Integer.MIN_VALUE,e2 = Integer.MIN_VALUE;
        int c1 = 0, c2=0;
        List<Integer> lst = new ArrayList<>();
        if(ar.length <= 2){
            lst.add(ar[0]);
            if(ar.length == 1 || (ar[0] == ar[1])) return lst;
            lst.add(ar[1]);
            return  lst;
        }
        for(int j:ar){
            if(c1 == 0 && j!=e2 ){
                c1 = 1;
                e1 = j;
            }else if(c2 == 0 && j!=e1){
                c2 = 1;
                e2 = j;
            }else if(j == e1) c1++;
            else if(j== e2) c2++;
            else {
                c1--;
                c2--;
            }
        }
        int limit=ar.length/3;
        c1=0;
        c2=0;
        for(int j:ar){
            if(j== e1) c1++;
            else if(j== e2) c2++;
        }
        if(c1>limit) lst.add(e1);
        if(c2>limit) lst.add(e2);
        return lst;
    }

    public static void getNby2LargestElement(int []ar){
        int elem = ar[0];
        int count = 1;
        for(int i=1;i<ar.length;i++){
            if(elem == ar[i] ){
                count ++;
            }else{
                count --;
            }
            if(count == 0){
                count = 1;
                elem = ar[i];
            }
        }
        int cntVerify = 0;
        for (int j : ar) {
            if (elem == j) {
                cntVerify++;
            }
        }
        if( ar.length/2 >= cntVerify){
            System.out.println("No Majority element found");
        }
        else
            System.out.println(elem+" size "+ar.length);
    }

}
