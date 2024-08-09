package coding.July2024;

import java.util.*;
import java.util.stream.Collectors;

public class SortJumbledNumber {
    public static void main(String[] args) throws Exception{
        int []mapping = {0,1,2,3,4,5,6,7,8,9};
        int []nums=  {418,4191,916,948,629641556,574,111171937,28250,42775632,6086,85796326,696292542,186,67559,2167,366,854,2441,78176,621,4257,2250097,509847,7506,77,50,4135258,4036,59934,59474,3646243,9049356,85852,90298188,2448206,30401413,33190382,968234660,7973,668786,992777977,77,355766,221,246409664,216290476,45,87,836414,40952};
        //int []res = sortJumbled(mapping,nums);
        System.out.println();
        int []ar = {1,9,12,3,4,99,10001,4};
        //mergeSort(ar,0,ar.length-1);
        VersionedStack versionedStack = new VersionedStack();
        for(int x:ar){
            versionedStack.push(x);
        }
       // System.out.println(versionedStack.getVersionedStackDetails(4));
        versionedStack.pop();
        versionedStack.pop();
        versionedStack.pop();
        versionedStack.pop();
        versionedStack.pop();
        versionedStack.pop();
        versionedStack.pop();
        versionedStack.pop();
        //System.out.println(versionedStack.getVersionedStackDetails(6));
        String s = "aabbcccaa";
        //System.out.println(compressString(s));
        String []ch = {"a","b","b","b","b","b","b","b","b","b","b","b","b"};
        char []chAr = Arrays.stream(ch).collect(Collectors.joining()).toCharArray();
       // System.out.println(compress(chAr));
       // System.out.println(String.valueOf(chAr));
        System.out.println(countAndSay(4));
    }
    public static String countAndSay(int n) {
        return countAndSayRecur(n,1,"1");
    }
    public static String countAndSayRecur(int n,int i, String current){
        if(i==n) return current;
        else{
            return countAndSayRecur(n,i+1,getEncodedString(current));
        }
    }
    public static  String getEncodedString(String str){
        Character last = str.charAt(0);
        StringBuilder stringBuilder = new StringBuilder();
        int count =1;
        for(int i=1;i<str.length();i++){
            char c= str.charAt(i);
            if(c==last){
                count++;
            }else{
                stringBuilder.append(count);
                stringBuilder.append(last);
                count=1;
            }
            last = c;
        }
        stringBuilder.append(count);
        stringBuilder.append(last);
        return stringBuilder.toString();
    }

    public static int compress(char[] chars){
        StringBuilder str = new StringBuilder();
        int count =0;
        char last = chars[0];
        for(char c: chars){
            if(last == c){
                count ++;
            }else{
                str.append(last);
                if(count > 1)
                    str.append(count);
                count = 1;
            }
            last = c;
        }
        str.append(last);
        if(count > 1)
            str.append(count);
        int i=0;
        for(i=0;i<str.length();i++){
            chars[i] = str.charAt(i);
        }
        while(i<chars.length){
            chars[i++] = Character.MIN_VALUE;
        }
        return str.length();
    }
    public static String compressString(String str){
        StringBuilder stringBuilder = new StringBuilder();
        Character last = str.charAt(0);
        int count = 0;
        for(char c:str.toCharArray()){
            if(c==last){
                count++;
            }else{
                stringBuilder.append(last);
                stringBuilder.append(count);
                count = 1;
            }
            last = c;
        }
        stringBuilder.append(last);stringBuilder.append(count);
        return stringBuilder.toString();
    }
    public static String largestNonRepeatingSubString(String str){
        int l=0,r=0;
        int maxLen = 0;
        HashSet<Character> chrs = new HashSet<>();
        int start=0;
        while(r<str.length()){
            char c= str.charAt(r);
            if(!chrs.contains(c)){
                chrs.add(c);
                r++;
                if(r-l>maxLen){
                    maxLen = r-l;
                    start = l;
                }
            }else{
                chrs.remove(str.charAt(l));//reduce window
                l++;
            }
        }
        return str.substring(start,maxLen+start);
    }
    public static int[] sortJumbled(int[] mapping, int[] nums) {
        TreeMap<Integer,List<Integer>> map = new TreeMap<>();
        for(Integer n:nums){
            String enNum = String.valueOf(n);
            StringBuilder strBuild = new StringBuilder();
            for(char c:enNum.toCharArray()){
                strBuild.append(mapping[c-'0']);
            }
            Integer num = Integer.parseInt(strBuild.toString());
            List<Integer> lst = map.getOrDefault(num,new ArrayList<>());
            lst.add(n);
            map.put(num,lst);
        }
        return map.values().stream().flatMap(List::stream).mapToInt(Integer::intValue).toArray();
    }
   /* public static int[] sortArray(int []nums){

    }*/
    public static void mergeSort(int []ar,int left,int right){
        if(left<right){
            int m = left+(right-left)/2;
            mergeSort(ar,left,m);
            mergeSort(ar,m+1,right);
            merge2(ar,left,m,right);
        }
    }
    static class VersionedStack{
        private Stack<Integer> stack ;
        private List<Stack<Integer>> versionedStack;
        public VersionedStack(){
            stack = new Stack<>();
            versionedStack = new ArrayList<>();
        }
        public void push(Integer val){
            stack.push(val);
            versionStack();
        }

        private void versionStack(){
            versionedStack.add((Stack<Integer>) this.stack.clone());
        }
        public Integer pop() throws Exception{
            if(stack.isEmpty()){
                throw new IllegalAccessException("Stack is Empty");
            }
            Integer val = stack.pop();
            versionStack();
            return val;
        }
        public String getVersionedStackDetails(int version) throws Exception{
            if(version<0 || version>=versionedStack.size()){
                throw new IllegalAccessException("Invalid version passed");
            }
            return versionedStack.get(version).toString();
        }
    }
    public static void merge2(int []ar,int l,int m,int r){
        int n1 = m-l+1;
        int n2 = r-m;
        int[] L = new int[n1];
        int[] M = new int[n2];
        for(int i=0;i<n1;i++){
            L[i] = ar[i+l];
        }
        for(int i=0;i<n2;i++){
            M[i] = ar[m+i+1];
        }
        int k=l;
        int i=0,j=0;
        while(i<n1&&j<n2){
            if(L[i]>M[j]){
                ar[k] = M[j];
                j++;
            }else{
                ar[k] = L[i];
                i++;
            }
            k++;
        }
        while(i<n1){
            ar[k++] = L[i++];
        }
        while(j<n2){
            ar[k++] = M[j++];
        }

    }
    public static void bubbleSort(int []ar){
        for(int i=0;i<ar.length-1;i++){
            for(int j=0;j<ar.length-i-1;j++){
                if(ar[j]>ar[j+1]){
                    int temp = ar[j];
                    ar[j] = ar[j+1];
                    ar[j+1] = temp;
                }
            }
        }
    }
}
