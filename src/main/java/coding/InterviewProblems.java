package coding;
import java.util.*;

public class InterviewProblems {
    public static void main(String[] args) {
        int []ar={10,15,25};
        int []br = {1,5,20,30};
        ArrayList<Integer> res = new ArrayList<>();
        mergeZigZagSorted(ar,br,0,0,res,true);
        System.out.println("*".repeat(20));
        ArrayList<Integer> res2 = new ArrayList<>();
        mergeSortedArrayInZigZagFaishon(ar,br,res2,0,0,true);
    }
    public static void mergeSortedArrayInZigZagFaishon(int []ar,int []br,ArrayList<Integer> lst,int aStart,int bStart,boolean direction){
        if(direction){
            if(!lst.isEmpty()){
                System.out.println(lst);
            }
            for(int i=aStart;i<ar.length;i++){
                if(lst.isEmpty() || ar[i]>lst.get(lst.size()-1)) {
                    ArrayList<Integer> newAr = new ArrayList<>(lst);
                    newAr.add(ar[i]);
                    mergeSortedArrayInZigZagFaishon(ar, br, newAr, i + 1, bStart, false);
                }
            }
        }else{
            for(int i=bStart;i< br.length;i++){
                if(br[i]>lst.get(lst.size()-1)){
                    ArrayList<Integer> newAr = new ArrayList<>(lst);
                    newAr.add(br[i]);
                    mergeSortedArrayInZigZagFaishon(ar,br,newAr,aStart,i+1,true);
                }
            }
        }
    }
   public static void mergeZigZagSorted(int []ar,int []br,int iStart,int jStart,List<Integer> lst,boolean direction){
        if(direction){
            if(!lst.isEmpty()){
                System.out.println(lst);
            }
            for(int k=iStart;k<ar.length;k++){
                if(lst.isEmpty()){
                    ArrayList<Integer> newAr = new ArrayList<>(lst);
                    newAr.add(ar[k]);
                    mergeZigZagSorted(ar,br,k+1,jStart,newAr,false);
                }else{
                    if(ar[k]>lst.get(lst.size()-1)){
                        ArrayList<Integer> newAr = new ArrayList<>(lst);
                        newAr.add(ar[k]);
                        mergeZigZagSorted(ar,br,k+1,jStart,newAr,false);
                    }
                }
            }
        }else{
            for(int i=jStart;i<br.length;i++){
                if(br[i]>lst.get(lst.size()-1)){
                    int c= br[i];
                    ArrayList<Integer> brAr = new ArrayList<>(lst);
                    brAr.add(c);
                    mergeZigZagSorted(ar,br,iStart,i+1,brAr,true);
                }
            }
        }
    }
}
