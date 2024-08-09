package coding.array;

public class TowerOfHanoi {

    public static void main(String[] args) {
        int n = 2;
        solve(n,"A","C","B");
    }
    public static void solve(int n,String start,String end,String aux){
        if(n==1){
            return;
        }
        solve(n-1,start,aux,end);
        System.out.printf("Moved from %s to %s",start,end);
        System.out.println();
        solve(n-1,aux,end,start);
    }

}
