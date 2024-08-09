package coding.array;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Seggregate01and2 {

    public static void main(String[] args) {
        int []ar={0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        int low = 0;
        int mid =0;
        int high = ar.length-1;
        while(mid<=high){
            if(ar[mid]==0){
               int temp = ar[low];
               ar[low] = ar[mid];
               ar[mid] = temp;
               mid++;
               low++;
            }
            else if(ar[mid]==2){
                int temp = ar[high];
                ar[high] = ar[mid];
                ar[mid] = temp;
                high--;
            }else{
                mid++;
            }
        }
       for(int i=0;i<ar.length;i++){
           System.out.printf("%d ",ar[i]);
       }
    }


}
