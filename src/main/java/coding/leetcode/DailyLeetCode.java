package coding.leetcode;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DailyLeetCode {
    public static void main(String[] args) {
        //System.out.println(maxDepth("1"));
        //System.out.println(24^2);
        int []ar = {-1,1,0,-3,3};
       // System.out.println(Arrays.toString(productExceptSelf(ar)));
        char []chAr = "abbbbbbbbbbbb".toCharArray();
        //System.out.println(compress(chAr));
        //System.out.println(chAr);
        ar = new int[]{0,1,0,3,12};
        moveZeros(ar);
        //System.out.println(Arrays.toString(ar));
       // System.out.println(makeGoodStack("leEeetcode"));
        //System.out.println(minRemoveToMakeValid("())()((("));
       // System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        /*System.out.println(checkValidString("()"));
        System.out.println(checkValidString("(*)"));
        System.out.println(checkValidString("(*))"));

        System.out.println(checkValidString("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()"));
        System.out.println(checkValidString("(((((()*)(*)*))())())(()())())))((**)))))(()())()"));
        System.out.println(checkValidString("*))(("));
        System.out.println(checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));*/
        int []students = new int[]{1,1,1,0,0,1};
        int []sandwitch = new int[]{1,0,0,0,1,1};

      //  System.out.println(timeRequiredToBuy(new int[]{2,3,2},2));
      //  System.out.println(timeRequiredToBuy(new int[]{5,1,1,1},0));
      //  System.out.println(timeRequiredToBuy(new int[]{2,3,2},1));
      //  System.out.println(timeRequiredToBuy(new int[]{5,1,1,1},0));
       // System.out.println(Arrays.toString(deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7})));
       /* System.out.println(removeKdigits("10200",1));
        System.out.println(removeKdigits("1432219",3));
        System.out.println(removeKdigits("10",2));
        System.out.println(removeKdigits("1234567890",9));
        System.out.println("***********************************");
        System.out.println(removeKdigits2("10200",1));
        System.out.println(removeKdigits2("1432219",3));
        System.out.println(removeKdigits2("10",2));*/
      //  System.out.println(removeKdigits("1234567890",9));
        //System.out.println(reverseVowels("leetcode"));
    //    printPermutation("1234".toCharArray(),0);
        ar=new int[]{8, 9 ,10 ,12 ,12 ,12};
        //System.out.println(getFrequency(ar,12));
        //System.out.println(isSubsequence("axc","ahbgdc"));
        ar = new int[]{1,8,6,2,5,4,8,3,7};
        //System.out.println(maxArea2(ar));
        String s = "madam";
        //System.out.println(isPalinDrome(s,0,s.length()-1));
        System.out.println(getFirstUniqueCharInString("aabcbbdc"));
    }

    public static int getIndexOfFirstUniqueCharacterInString(String str){
        Map<Character,Integer> map = new HashMap<>();
        Set<Character> dup = new HashSet<>();
        for(int i=0;i<str.length();i++){
            Character ch = str.charAt(i);
            if(dup.contains(ch)) continue;
            if(map.get(ch)!=null){
                map.remove(ch);
                dup.add(ch);
            }else{
                map.put(ch,i);
            }
        }
        int minIdx = Integer.MAX_VALUE;
        for(Map.Entry<Character,Integer> mpEntry:map.entrySet()){
            minIdx = Math.min(minIdx,mpEntry.getValue());
        }
        return minIdx == Integer.MAX_VALUE ? 0: minIdx;
    }
    public static int getLongestConsequtiveSequenceInUnSortedIntegerArray(int []ar){
        Set<Integer> set = new HashSet<>();
        for(int x:ar){
            set.add(x);
        }
        int maxSz = 0;
        for(int x:ar){
            if(!set.contains(x-1)) {
                int y = x + 1;
                while (set.contains(y)) {
                    y++;
                }
                maxSz = Math.max(maxSz, y - x);
            }
        }
        return maxSz;
    }
    public static int getFirstUniqueCharInString(String str){
        int []ch = new int[str.length()];
        Arrays.fill(ch,0);
        for(char c:str.toCharArray()){
            ch[c-'a']++;
        }
        int i=0;
        for(char c:str.toCharArray()){
            if(ch[c-'a']==1)
                return i;
            i++;
        }
        return -1;
    }
    public static boolean isPalinDrome(String s, int start,int end){
        if(start>=end){
            return true;
        }
        for(int i=start;i<s.length()/2;i++){
            isPalinDrome(s,i,end-1);
        }
        return s.charAt(start) == s.charAt(end);
    }
    public static int maxArea2(int[] ar) {
        int l = 0;
        int r = ar.length-1;
        int maxAr = Integer.MIN_VALUE;
        while (r>=l){
            int h = Math.min(ar[l],ar[r]);
            int are = h*(r-l);
            maxAr = Math.max(are,maxAr);
            if(ar[r]>ar[l]){
                l++;
            }else{
                r--;
            }
        }
        return maxAr;
    }
    public static boolean isSubsequence(String s, String t) {
        int idx = 0;
        for(int i=0;i<t.length();i++){
            if(idx < s.length() && t.charAt(i) == s.charAt(idx))
                idx++;
        }
        return idx>=s.length();
    }
    public static int getFrequency(int []ar,int num){
        int l = (lowerCount(ar,num));
        if(l<0) return 0;
       // System.out.println(l);
        int h = higherCnt(ar,num);
        return h-l+1;
    }
    public static int lowerCount(int []ar,int num){
        int l = 0;
        int h=ar.length-1;
        int m = (h+l)/2;
        while(h>=l){
            if(m-1>=0 && ar[m]==num && ar[m]>ar[m-1]){
                return m;
            }else{
                if(num>ar[m]){
                    l = m+1;
                }else{
                    h = m-1;
                }
                m = (h+l)/2;
            }
        }
        return -1;
    }
    public static int higherCnt(int []ar,int num){
        int l = 0;
        int h=ar.length-1;
        int m = (h+l)/2;
        while(h>=l){
            if(m+1< ar.length && ar[m]==num && ar[m+1]>ar[m]){
                return m;
            }else{
                if(ar[m]>num){
                    h = m-1;
                    //l = m+1;
                }else{
                    l = m+1;
                }
                m = (h+l)/2;
            }
        }
        return -1;
    }
    public  static String reverseVowels(String s) {
        char []chrs = s.toCharArray();
        int n = s.length();
        boolean []pos = new boolean[n];
        for(int i=0;i<n;i++){
            char c=chrs[i];
            if(isVowel(c) && !pos[i]) {
                for (int j = n - 1; j >= i; j--) {
                    char d = chrs[j];
                    if(isVowel(d) && !pos[j]) {
                        pos[i] = true;
                        pos[j] = true;
                        char temp = chrs[i];
                        chrs[i] = chrs[j];
                        chrs[j] = temp;
                        break;
                    }
                }
            }
        }
        return new String(chrs);
    }
    public static boolean isVowel(char c){
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ||
                (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int cnt = 0;
        for(int i=0;i<flowerbed.length-2;i++){
            if(flowerbed[i]==1 && flowerbed[i+1]==0){
                flowerbed[i+2] = 1;
                cnt++;
            }
        }
        int l = flowerbed.length;

            if(flowerbed[l-1] == 1){
            if(flowerbed[l-2] == 0){

            }
        }
        return cnt >= n;
    }
  //  List<String>
  public static String removeKdigits2(String num, int k) {
      Stack<Character> stack = new Stack<>();
      for (char digit : num.toCharArray()) {
          if(!stack.isEmpty() && k > 0 && digit < stack.peek()){
              stack.pop();
              k--;
          }
          stack.push(digit);
      }
      while(k>0){
          stack.pop();
          k--;
      }
      StringBuilder stringBuilder = new StringBuilder();
      while(!stack.isEmpty()){
          stringBuilder.insert(0,stack.pop());
      }
      while(stringBuilder.length()>1 && stringBuilder.charAt(0)=='0'){
          stringBuilder.deleteCharAt(0);
      }
      //if(stringBuilder.length() == 0) return  "0";
      return stringBuilder.toString();
  }
    public static String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && digit < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        while (result.length() > 0 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.toString();
    }
    public static int getMinPermutation(char[] num){
        return -1;
    }
    public static void printPermutation(char[] s,int indx ){
        if(s.length == indx){
            System.out.println(s);
        }
        for(int i=indx;i<s.length;i++){
            swap(s,i,indx);
            printPermutation(s,indx+1);
            swap(s,i,indx);
        }
    }
    public static void swap(char[] ar,int p,int q){
        char temp = ar[p];
        ar[p] = ar[q];
        ar[q] = temp;
    }
    public static int[] deckRevealedIncreasing(int[] deck) {
        int N=deck.length;
        int []result = new int[N];
        boolean skip = false;
        int p =0,q=0;
        Arrays.sort(deck);
        while(p<N){
            if(result[q] == 0 ){
                if(!skip){
                    result[q] = deck[p];
                    p++;
                }
                skip = !skip;
            }
            q = (q+1) % N;
        }
        return result;
    }
    public static int timeRequiredToBuy(int[] ar, int k) {
        Queue<Integer> que = new LinkedList<>();
        for(int i=0;i<ar.length;i++){
            que.add(i);
        }
        int cnt=1;
        while(!que.isEmpty()){
            int index = que.poll();
            if(ar[index]>0){
                ar[index]--;
                if(ar[index]>0) {
                    que.offer(index);
                }
            }
            if(index==k && ar[index]==0){
                return cnt;
            }
            cnt++;

        }
        return cnt;
    }
    public static int countStudents(int[] students, int[] sandwiches) {
        int n = sandwiches.length;
        Stack<Integer> stack =   new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<students.length;i++){
            stack.push(sandwiches[sandwiches.length-i-1]);
            queue.offer(students[i]);
        }
        int queuePos = 0;
        while (!stack.isEmpty()&&queuePos<queue.size()) {
            if(stack.peek().equals(queue.peek())){
                stack.pop();
                queue.poll();
                queuePos=0;
            }else{
                queue.offer(queue.poll());
                queuePos++;
            }
        }
        return queue.size();
    }
    public static int countStudents2(int[] students, int[] sandwiches) {
        int n = sandwiches.length;
        int i = 0, j = 0;
        int rotate = 0;
        while (i < n) {
            if (sandwiches[i] == students[j % students.length]) {
                i++;
                j++;
            } else {
                boolean possibility = false;
                for (int k = j; k < n; k++) {
                    if (sandwiches[i] == students[k % students.length]) {
                        possibility = true;
                        break;
                    }
                }
                if (!possibility) {
                    return n - j;
                }
                rotate++;
                j++;
            }
        }
        return 0;
    }

    public static boolean checkValidString(String s) {
        int n = s.length();
        boolean [][]dp = new boolean[n+1][n+1];
        dp[n][0] = true;
        for(int i = n-1;i>=0;i--){
            for(int openBracket = 0;openBracket<n;openBracket++ ){
                boolean isValid = false;
                if(s.charAt(i) == '*'){
                    isValid = isValid ;
                }
            }
        }
        return true;
    }
    public static boolean dfs(String s,int index,int cnt){
        if(cnt < 0) return false;
        if(s.length() == index) return cnt == 0;
        char c= s.charAt(index);
        if(c=='(') return dfs(s,index+1,cnt+1);
        else if(c==')') return dfs(s,index+1,cnt-1);
        else  return
                            dfs(s,index+1,cnt+1) ||
                            dfs(s,index+1,cnt-1) ||
                            dfs(s,index+1,cnt);
    }
    public static boolean checkValidString3(String s) {
        int cMin = 0,cMax = 0;
        for(Character c:s.toCharArray()){
            if(c=='(') {
                cMin++;
                cMax++;
            }else if(c==')'){
                cMax--;
                cMin = Math.max(cMin-1,0); //decrease cMin, also make sure that it is not negative
            }else{
                cMax++;
                cMin = Math.max(cMin-1,0);  //decrease cMin, also make sure that it is not negative
            }
            if(cMax<0) return false;
        }
        return cMin == 0;
    }
        public static boolean checkValidString2(String s) {
        if(isValidStr(s,"(")){
            return true;
        }else
          if(isValidStr(s,")")){
            return true;
          }else{
              return isValidStr(s,"");
          }
    }
    static  boolean isValidStr(String s, String type){
        int cnt = 0;
        int idx = 0;
        for(Character c:s.toCharArray()){
           if(c=='('){
               cnt ++;
           }else if(c==')') {
               if(cnt == 0 ) return false;
               cnt--;
           }else if(c=='*' ){
               if(type.equals("(")){
                   cnt++;
               }else if(type.equals(")")){
                   cnt--;
               }
           }
           idx++;
        }
        return (cnt==0);
    }
    /*
    *  if(ar[l]>ar[r]){
                l++;
            }else{
                r--;
            }*/
    public static int maxArea(int[] ar) {
        int l = 0;
        int r = ar.length - 1;
        int maxArea = 0;
        while (r >= l) {
            maxArea = Math.max(maxArea, Math.min(ar[l] , ar[r]) * (r - l));
            if (ar[l] < ar[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> toRemove = new HashSet<>();
        for(int i=0;i<s.length();i++){
            Character c = s.charAt(i);
            if(c=='('){
                stack.push(i);
            }else if(c==')'){
                if(!stack.isEmpty())
                    stack.pop();
                else
                    toRemove.add(i);
            }
        }
        while(!stack.isEmpty()){
            toRemove.add(stack.pop());
        }
        StringBuilder finalStr = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            if(!toRemove.contains(i)){
                finalStr.append(s.charAt(i));
            }
        }
        return finalStr.toString();

    }

    public static String minRemoveToMakeValid2(String s) {
        StringBuilder strBuild = new StringBuilder();
        int openCnt = 0;
        for(Character c:s.toCharArray()){
            if(c == '('){
                openCnt++;
            }
            else if(c==')'){
                if(openCnt == 0 ) {//This will not add extra closing bracket
                    continue;
                }
                openCnt--;
            }
            strBuild.append(c);
        }
        String s1 = strBuild.toString();
        StringBuilder finalResult = new StringBuilder();
        strBuild = new StringBuilder();
        for(Character c:s1.toCharArray()){
            if(c == '('){
                openCnt++;
            }
            else if(c==')'){
                if(openCnt == 0 ) {//This will not add extra closing bracket
                    continue;
                }
                openCnt--;
            }
            strBuild.append(c);
        }
        for(int i=0;i<strBuild.length();i++){
            char c = strBuild.charAt(i);
            if(c=='(' && openCnt-- >0){ //this will not add extra opening bracket
                continue;
            }
            finalResult.append(c);
        }
        return finalResult.toString();
    }
    public static String makeGoodStack(String s) {
        if(s.length() == 0) return s;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!stack.isEmpty() && Math.abs(stack.peek() - s.charAt(i)) == 32){
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : stack) {
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }
    public static String makeGood(String s) {
        if(s.length() == 0) return s;
        StringBuilder str = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(i+1<s.length() && s.charAt(i) !=s.charAt(i+1) &&
                    (Character.toUpperCase(s.charAt(i)) == Character.toUpperCase(s.charAt(i+1)))){
                i++;
                continue;
            }
            str.append(s.charAt(i));
            String tempStr = str.toString();
            str = new StringBuilder();
            for(int j=0;j<tempStr.length();j++){
                if(j+1<tempStr.length() && tempStr.charAt(j) !=tempStr.charAt(j+1) &&
                        (Character.toUpperCase(tempStr.charAt(j)) == Character.toUpperCase(tempStr.charAt(j+1)))){
                    j++;
                    continue;
                }
                str.append(tempStr.charAt(j));
            }
        }

        return str.toString();
    }
    public static void moveZeros(int []ar){
        if(ar.length == 1) return;

        int zeroIdx = 0;
        for(int i=0;i<ar.length;i++){
           if(ar[i] != 0){
               ar[zeroIdx++] = ar[i];
           }
       }
       for(int j=zeroIdx;j<ar.length;j++){
           ar[j] = 0;
       }

    }
    public static int compress(char[] chars) {
        StringBuilder str = new StringBuilder();
        int cnt = 1,i;
        int len = 0;
        for(i=0;i<chars.length-1;i++){
            if(chars[i] == chars[i+1]) cnt++;
            else {
                len++;
                str.append(chars[i]);
                if(cnt>1) {
                    str.append(cnt);
                }
                cnt = 1;
            }
        }

        str.append(chars[i]);
        if(cnt>1){
            str.append(cnt);
        }
        for( i=0;i<str.length();i++){
            chars[i] = str.charAt(i);
        }
        return str.length();
    }
    public static int[] productExceptSelf(int[] nums) {
        int []sufix = new int[nums.length];
        sufix[nums.length-1] = 1;
        int []prefix = new int[nums.length];
        prefix[0] = 1;
        //calculate prefix
        for(int i = 1;i<nums.length;i++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }
        for(int i = nums.length-2;i>=0;i--){
            sufix[i] = sufix[i+1] * nums[i+1];
        }
        int []result = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int prod = prefix[i] * sufix[i];
            result[i] = prod;
        }
        return result;
    }
    public static int maxDepth(String s) {
        int cnt = 0;
        s = s.replaceAll("\\d","").replaceAll("[*,+,-,/]","");
        if(s.length() == 0) return 0;
        int maxCnt = Integer.MIN_VALUE;
        for(char c:s.toCharArray()){
            if(c=='(') cnt++;
            if(c== ')') cnt--;
            if(cnt > maxCnt ) maxCnt = cnt;
        }
        return maxCnt;
    }
}
