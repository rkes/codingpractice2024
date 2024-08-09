package coding.array;

import java.util.ArrayList;

public class FindRepeatedNums {
    public static void main(String[] args) {
        long []ar = {1, 3, 5, 5, 5, 5, 7, 123, 125 };
        ArrayList<Long> res = find(ar,ar.length,5);
        System.out.println(res);
    }
    static ArrayList<Long> find(long ar[], int n, int x)
    {
        // code here
        int low = 0;
        int mid = n-n/2;
        int high = n;
        int startIdx =-1;
        while(low<high){
            if(x>ar[mid]){
                high = mid-1;
            }else{
                if(x==ar[mid]){
                    if(mid-1>=0){
                        if(x>ar[mid-1]){
                            startIdx=mid;
                        }
                    }
                }
                low = mid+1;
            }
            mid = (low+high)/2;
        }
        ArrayList<Long> lst = new ArrayList<>();
        if(startIdx==-1){
            lst.add(-1L);
            return lst;
        }
        low = mid;
        high = n;
        mid = (low+high)/2;
        int endIdx = startIdx;
        while(low<high){

            if(ar[mid]>x){
                low = mid+1;
            }
            else{
                if(ar[mid]==x){
                    if(mid+1<n && ar[mid+1]>x){
                        endIdx= mid; break;
                    }
                }
                high--;
            }

            mid = (low+high)/2;
        }
        lst.add(Long.valueOf(startIdx));
        lst.add(Long.valueOf(endIdx));
        return lst;

    }

}
