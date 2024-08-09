package coding.array;

public class IncreasingTriplet {
    public static void main(String[] args) {
        int[]nums = {5,4,3,2,1};
        int one = Integer.MAX_VALUE;
        int two  = Integer.MAX_VALUE;
        boolean foundNum = false;
        for(int x:nums){
            if(x>two) {
                foundNum = true;
                System.out.println("True");
                break;
            }
            if(one>=x) one = x;
            else
                two = x;
        }
        if(!foundNum)
            System.out.println("False");
    }
}
