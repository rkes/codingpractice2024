package coding.recursion;

import java.util.*;
import java.util.stream.Collectors;

public class BackTracking {
    public static void main(String[] args) {
        int []ar = {1,7,5,3,1,6};
        /*findAllSubset(ar,0,8,new ArrayList<>());
        for(ArrayList<Integer> a: ans){
            System.out.println(a);
        }
         */
       /* Solution solution = new Solution();
        solution.solveNQueens(4);
        List<List<String>> result = solution.solveNQueens(4);
        for(List<String> lst : result){
            System.out.println(lst);
        }
        System.out.println("\n\n");
        result = solveNQueensProblem(4);
        for(List<String> lst : result){
            System.out.println(lst);
        }*/
        char [][]board  = { {'A', 'B', 'C', 'D','E','F', 'X'},
                            {'Y', 'Z', 'A', 'B','C','D','E'},
                            {'F', 'G', 'H', 'I','J','K','R'}};
        String target = "ZABIHGFYABCDECDERKJ";
        //System.out.println(searchWord(board,target));
        List<String> strs = new ArrayList<>(Arrays.asList("a", "b", "c"));
        //System.out.println(String.join("", strs));
        //letterCombinations("23");
        //generateParenthesis(3);
        String s6 = "aabcdef";
        String p6 = "a*";
        //System.out.println("Is " + s6 + " matched with " + p6 + "? " + RegularExpressionMatching.isMatch(s6, p6));
        ar = new int[]{0,0,1,1,1,2,2,3,3,4};
       // nextPermutation(ar);
        // printAllPermutation(ar,0);
        System.out.println(removeDuplicate2(ar));
        System.out.println(Arrays.toString(ar));
    }
    //public static List<List<Integer>> permute(int[] nums) {

//    }
    static List<List<Integer>> lst = new ArrayList<>();
    static int removeDuplicate2(int []nums){
        int j=1;
        for(int i=1;i<nums.length;i++){
                if(nums[i]!=nums[i-1]){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
    static int removeDuplicate(int []nums){
        ArrayList<Integer> indexs = new ArrayList<>();
        int t = nums[0];
        indexs.add(0);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]!=nums[i+1]){
                t = nums[i+1];
                indexs.add(i+1);
            }
        }
        if(t!=nums[nums.length-1]){
            indexs.add(nums.length-1);
        }
        for(int i=0;i<indexs.size();i++){
            nums[i] = nums[indexs.get(i)];
        }
        return indexs.size();
    }
    public static void printAllPermutation(int []nums,int idx){
        if(idx == nums.length) {
            //lst.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            System.out.println(Arrays.toString(nums));
            return ;
        }
        for(int i=idx;i<nums.length;i++){
            swap(nums,i,idx);
            printAllPermutation(nums,idx+1);
            swap(nums,i,idx);
        }
    }

    public static void nextPermutation(int []nums){
        //Find first smallest number position from end in the array the
        int l = -1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i+1]>nums[i]){
                l = i;
                break;
            }
        }
        if( l < 0){
            reverse(nums,0,nums.length-1);
        }
        //Find first greater element from
        else{
            int j;
            for(j=nums.length-1;j>l;j--){
                if(nums[j]>nums[l]){
                    break;
                }
            }
            swap(nums,l,j);
            reverse(nums,l+1,nums.length-1);
        }
    }
    static void reverse(int []ar,int start,int end)
    {
        while(start<end) {
            swap(ar,start,end);
            start++;
            end--;
        }
    }
    static void swap(int []ar,int i,int j){
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }
    public static class RegularExpressionMatching {
        public static boolean isMatch(String s, String p) {
            return isMatchRecursive(s, p, 0, 0);
        }

        private static boolean isMatchRecursive(String s, String p, int sIndex, int pIndex) {
            if (pIndex == p.length()) {
                return sIndex == s.length();
            }

            boolean firstMatch = (sIndex < s.length() && (p.charAt(pIndex) == s.charAt(sIndex) || p.charAt(pIndex) == '.'));

            if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*') {
                return (isMatchRecursive(s, p, sIndex, pIndex + 2)) || (firstMatch && isMatchRecursive(s, p, sIndex + 1, pIndex));
            } else {
                return firstMatch && isMatchRecursive(s, p, sIndex + 1, pIndex + 1);
            }
        }
    }
    static Map<Character,List<String>> map = new HashMap<>();
    static List<String> result = new ArrayList<>();

    public static List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        map.put('2',Arrays.asList(new String[]{"a","b","c"}));
        map.put('3',Arrays.asList(new String[]{"d","e","f"}));
        map.put('4',Arrays.asList(new String[]{"g","h","i"}));
        map.put('5',Arrays.asList(new String[]{"j","k","l"}));
        map.put('6',Arrays.asList(new String[]{"m","n","o"}));
        map.put('7',Arrays.asList(new String[]{"p","q","r","s"}));
        map.put('8',Arrays.asList(new String[]{"t","u","v"}));
        map.put('9',Arrays.asList(new String[]{"w","x","y","z"}));
        if(digits.length()<=0){
            return Collections.emptyList();
        }
        if(digits.length()==1){
            return map.getOrDefault(digits.charAt(0),Collections.emptyList());
        }
        backTrack2(digits,0,new ArrayList<String>());
        return result;
    }
    public static void backTrack2(String digit,int idx,ArrayList<String> path){
        if(path.size() == digit.length() ){
            result.add(String.join("",path));
            return;
        }
        List<String> str = map.get(digit.charAt(idx));
        for(String s:str){
            System.out.println(s);
            path.add(s);
            backTrack2(digit,idx+1,path);
            path.remove(path.size()-1);
        }

    }
    static void generateParenthesis(int n){
        List<String> result = new ArrayList<>();
        backTrack(result,"",0,0,n);
        for(String res: result){
            System.out.println(res);
        }
    }
    static void backTrack(List<String> result,String current,int open,int close, int max){
        if(current.length() == max*2){
            result.add(current);
            return;
        }
        if(open < max){
            backTrack(result,current+"(",open+1,close,max);
        }
        if(open > close ){
            backTrack(result,current+")",open,close+1,max);
        }
    }
    static boolean searchWord(char [][] board, String target){
        int rowLen = board.length;
        int colLen = board[0].length;
        for(int i=0;i<rowLen;i++){
            for(int j=0;j<colLen;j++){
                if(dfs(board,i,j,target,0)){
                    return  true;
                }
            }
        }
        return false;
    }
    static boolean dfs(char [][]board,int row,int col,String target,int cursor){
        if(cursor == target.length()) return true;
        if(row <0 || col<0 || row>= board.length || col >= board[0].length  || board[row][col] != target.charAt(cursor) ){
            return false;
        }
        char temp = board[row][col];
        board[row][col] = '*';
        boolean isValid = dfs(board,row,col-1,target,cursor+1) ||
                      dfs(board,row-1,col,target,cursor+1)||
                      dfs(board,row+1,col,target,cursor+1) ||
                     dfs(board,row,col+1,target,cursor+1);
        board[row][col] = temp;
        return isValid;
    }
    static void backTrack(char [][]ar, String target, int row,int col){
         if(ar.length == row && ar[0].length == col){
            return;
         }
    }

    static List<List<String>> solveNQueensProblem(int n ){
        List<List<String>> result = new ArrayList<>();
        char [][] board = new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        backTrack(board,0,result);
        return result;
    }
    static void backTrack(char [][] board, int row,List<List<String>> result){
        if(row == board.length){//we have placed all queens succesfully
            result.add(constructSolution(board));
            return;
        }
        for(int col=0;col<board.length;col++){
            if(isValidMove(board,row,col)){
                board[row][col] = 'Q';
                backTrack(board,row+1,result);
                board[row][col] = '.';
            }
        }

    }
    static boolean isValidMove(char [][]board, int row,int col){
        //Check for all columns
        for(int i=0;i<board[row].length;i++){
            if(board[i][col] == 'Q') return  false;
        }
        //Check for upper right diagonal
        for(int i= row-1,j=col+1;i>=0 && j<board.length;i--,j++ ){
            if(board[i][j]=='Q') return false;
        }
        //Check for upper left diagonal
        for(int i= row-1,j=col-1;i>=0 && j>=0;i--,j-- ){
            if(board[i][j]=='Q') return false;
        }
        return true;
    }
    static List<String> constructSolution(char [][]board){
        List<String> sol = new ArrayList<>();
        for(char []brd : board){
            sol.add(new String(brd));
        }
        return sol;
    }
    static List<ArrayList<Integer>> ans  = new ArrayList<>();
    public static void findAllSubset(int []ar,int idx,int target,ArrayList<Integer> lst){
        if(lst.size() > 0 && lst.stream().mapToInt(x->x).sum() == target ){
            ans.add(new ArrayList<>(lst));
        }else{
            for(int i=idx;i<ar.length;i++){
                lst.add(ar[i]);
                findAllSubset(ar,i+1,target,lst);
                lst.remove(lst.size()-1);
            }
        }

    }

   static class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> result = new ArrayList<>();
            char [][]board = new char[n][n];
            for(int i=0;i<n;i++){
                Arrays.fill(board[i],'.');
            }
            backTrack(board,0,result);
            return result;
        }
        static void backTrack(char [][] board,int row,List<List<String>> result){
            if(board.length == row ){//reached to solution
                result.add(constructSol(board));
                return;
            }
            for(int i=0;i<board.length;i++){
                if(isValidMove(board,row,i)){
                    board[row][i] = 'Q';
                    backTrack(board,row+1,result);
                    board[row][i] = '.';
                }
            }

        }
        static boolean isValidMove(char [][]chAr, int row,int col){
            //Check if any queen is in column
            for(int i=0;i<chAr.length;i++){
                if(chAr[row][i] == 'Q') return false;
            }
            //Check if upper right diagonal has queen
            for(int i=row-1,j=col+1;i>=0 && j<chAr.length;i--,j++){
                if(chAr[i][j] == 'Q') return false;
            }
            //Check if upper left diagonal has queen
            for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
                if(chAr[i][j] == 'Q') return false;
            }
            return true;
        }
        static List<String> constructSol(char[][] chAr){
            List<String> result = new ArrayList<>();
            for(char []cAr : chAr){
                result.add(new String(cAr));
            }
            return result;
        }
    }

}
