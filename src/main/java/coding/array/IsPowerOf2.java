package coding.array;

public class IsPowerOf2 {
    public static void main(String[] args) {

        System.out.println(isPalindrome(1221));
    }
    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int len = s.length();
        for(int i=0;i<len/2;i++){
            if(s.charAt(i) != s.charAt(len-1-i)){
                return false;
            }
        }
        return true;
    }
    public static boolean isPowerOfTwo(int n) {
        //double res = ;
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Math.getExponent(-2147483648));
        return (n!=0 && (n & (n-1)) ==0);
    }
}
