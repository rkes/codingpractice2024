package coding.array;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class MergeIntervals {

    public static void main(String[] args) {
        int [][]ar = {{1,4},{2,3}};//{{1,3},{2,6},{8,10},{15,18}};
        Arrays.sort(ar,(a,b)->{
            return a[0]-b[0];
        });
        Stack<int[]> stack = new Stack<>();
        stack.push(ar[0]);
        for(int i=1;i<ar.length;i++) {
            int []el = ar[i];
            int []stckElem = stack.peek();
            if(stckElem[1]>=el[0]){
                if(el[1]>=stckElem[1]){
                    stack.pop();
                    stack.push(new int[]{stckElem[0],el[1]});
                }
            }else{
                stack.push(el);
            }
        }
        int [][]res = new int[stack.size()][2];
        int i=0;
        while (!stack.isEmpty()){
            int []r = stack.pop();
            res[i][0] = r[0];
            res[i][1] = r[1];
            i++;
        }
        Arrays.sort(res,(a,b)->b[0]-a[0]);
        System.out.println();
    }

}
