package coding.array;

public class CommonString {

    public static void main(String[] args) {
        String s1="qdef";
        String s2="defq";
        System.out.println(maxLengthOfCommonSubString(s1.toCharArray(),s2.toCharArray(),0,0));

    }
    public static int maxLengthOfCommonSubString(char[] s1,char[] s2,int i,int j){
        if(s1.length==i || s2.length==j){
            return 0;
        }
        if(s1[i]==s2[j]){
            return maxLengthOfCommonSubString(s1,s2,i+1,j+1)+1;
        }
        return Math.max(maxLengthOfCommonSubString(s1,s2,i+1,j),maxLengthOfCommonSubString(s1,s2,i,j+1));
    }

}
