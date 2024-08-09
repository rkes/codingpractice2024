package coding.slidingwindow;

import java.util.*;
import java.util.stream.Collectors;

public class LongestSubStringWithoutRepetiton {

    public static void main(String[] args) {
        String str = "asdfasdfasdfasdf";
        int low = 0;
        int high=str.length();
        int idx=0;
        int []br = {1,2,3,4,3,6,7,8,9,10,2,1};
        String s = "geeksforgeeks";
      //  longestSubstrDistinctChars(s);
        int []elem={5,4,3,2,1};
        StockSpanner stockSpanner = new StockSpanner();
        List<Integer> ar = new ArrayList<>();
        ar.add(stockSpanner.next(100));ar.add(stockSpanner.next(80));ar.add(stockSpanner.next(60));
        ar.add(stockSpanner.next(70));ar.add(stockSpanner.next(60));ar.add(stockSpanner.next(75));
        ar.add(stockSpanner.next(85));
        str = "PAYPALISHIRING";
        //System.out.println(getZigZagString("A",1));
        //System.out.println(lengthOfLongestSubString("abba"));
       // List<String> result = letterCombinations("22");
        //System.out.println(String.join(",", result));
        //    System.out.println(ar.stream().map(String::valueOf).collect(Collectors.joining(",")));

        // int []res = nextGreaterElements(elem);
       // System.out.println(Arrays.toString(res));
        //slidingWindow(br);
        //Set<Character> window = new LinkedHashSet<>();
        /*Map<Character,Integer> window = new HashMap<>();
        int []ar = new int[high];
        Arrays.fill(ar,-1);
        int maxLow = 0;int size =0,currLow=0,currSz=0;
        int maxSz=0;
        while (low<high){
            char cur = str.charAt(low);
            ar[low] = low;
            if(window.get(cur)!=null) {
                idx=0;
                currSz = 0;
                int cLow = -1;
                while(idx<ar.length){
                    if(ar[idx]<0 && cLow!=-1) break;
                    if(ar[idx]<0){idx++; continue;}
                    if(cLow==-1) cLow = idx;
                    idx++;
                    currSz++;
                }
                if(currSz>maxSz){
                    maxSz = currSz;
                    maxLow = cLow;
                }
                size=0;
                idx=window.get(cur);
                while(idx>=0){
                    ar[idx]=-1;
                    idx--;
                }
                window.remove(cur);
            }
            window.put(cur,low);
            low++;
            size++;
        }
        currSz = 0;
        int cLow = -1;
        while(idx<ar.length){
            if(ar[idx]<0 && cLow!=-1) break;
            if(ar[idx]<0){idx++; continue;}
            if(cLow==-1) cLow = idx;
            idx++;
            currSz++;
        }
        if(currSz>maxSz){
            maxSz = currSz;
            maxLow = cLow;
        }
        System.out.println(maxLow==0 ? maxSz:str.substring(maxLow,maxLow+maxSz-1));
*/
        //System.out.println(str.substring(maxLow,size+1));
        List<String> result = letterCombinations("22");
        System.out.println(result.toString());
    }
    public static void slidingWindow(int []ar){
        int l=0,r=0,maxLow=0,maxHigh=0;
        boolean[] window = new boolean[ar.length];
        while (r<ar.length){
            int elem = ar[r];
            if(window[elem]){
              while (ar[l]!=ar[r]) {
                  window[elem] = false;
                  l++;
              }

            }
            else{
                window[elem]= true;
                if(r-l>maxHigh-maxLow){
                    maxLow = l;
                    maxHigh = r;
                }
            }
            r++;
        }
        System.out.println("Max High "+maxHigh+"  Max Low  "+maxLow);
    }

    static int longestSubstrDistinctChars(String str){
        // code here
        boolean []window = new boolean[128];
        int l=0,r=0,maxL=0,maxR=0;
        for(r=0;r<str.length();r++){
            char c=str.charAt(r);
            if(window[c]){
                while(str.charAt(l)!=str.charAt(r)){
                    window[str.charAt(l++)] = false;
                }
                l++;
            }else{
                window[c] = true;
                if(r-l>maxR-maxL){
                    maxR = r;
                    maxL = l;
                }
            }
        }
        System.out.println(maxR-maxL+1);
        return maxR-maxL+1;
    }
    public static int[]nextGreaterElements(int[] ar) {
        int []res = new int[ar.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int n = ar.length;
        Arrays.fill(res,-1);
        for(int i=1;i<n*2;i++){
            int elem = ar[i%n];
            while(!stack.isEmpty() && elem > ar[stack.peek()%n]){
                res[stack.pop()%n] = elem;
            }
            stack.push(i%n);
        }
        return res;
    }

    static class StockSpanner{
        Stack<Integer[]> stack ;
        public StockSpanner(){
            stack = new Stack<>();
        }

        public int next(int price) {
            int count=1;
            while(!stack.isEmpty() && price >= stack.peek()[0]){
                count++;
                count+= stack.pop()[1];
            }
            stack.push(new Integer[]{price,count});
            return count;
        }
    }

    public static String getZigZagString(String str,int rows){
        if(rows<=1 || rows >= str.length()) return str;
        List<ArrayList<String>> arrayLists = new ArrayList<>();
        for(int i=0;i<rows;i++){
            arrayLists.add(new ArrayList<>());
        }
        int dir = -1;
        int row = 0;
        for(int i=0;i<str.length();i++){
            arrayLists.get(row).add(String.valueOf(str.charAt(i)));
            if(row==0 || row==rows-1){
                dir = dir*-1;
            }
            row = row + dir;
        }
        String result = arrayLists.stream().flatMap(lst->lst.stream()).collect(Collectors.joining(""));
        return  result;
    }

    public static int lengthOfLongestSubString(String s){
        int l=0;
        int maxL=0,maxR = 0;
        Map<Character,Integer> map = new HashMap<>();
        map.put(s.charAt(0),0);
        for(int i=1;i<s.length();i++){
            char c = s.charAt(i);
            Integer pos = map.get(c);
            if(pos!=null){
                l= pos+1;
                List<Character> characters = map.entrySet().stream().filter(x->x.getValue()<pos).map(Map.Entry::getKey).collect(Collectors.toList());
                characters.forEach(map::remove);
            }
            if(i-l>maxR-maxL){
                maxR = i;
                maxL = l;
            }
            map.put(c,i);
        }
        return maxR-maxL+1;
    }

    public static  List<ArrayList<Integer>> getFixedLengthPermutation(String str){
        List<ArrayList<Integer>> lst = new ArrayList<>();
        int len = str.length();
        for(int i=0;i<Math.pow(len,2);i++){
            int k = i;
            for(int j=0;j<2;j++){
                System.out.println(str.charAt(k%j));
                k = k/j;
            }
        }
        return lst;
    }
    static Map<Character,List<String>> map = new HashMap<>();
    static List<String> result = new ArrayList<>();
    public static List<String> letterCombinations(String digits) {
        if(digits.length()<=0){
            return Collections.emptyList();
        }
        map.put('2',Arrays.asList(new String[]{"a","b","c"}));
        map.put('3',Arrays.asList(new String[]{"d","e","f"}));
        map.put('4',Arrays.asList(new String[]{"g","h","i"}));
        map.put('5',Arrays.asList(new String[]{"j","k","l"}));
        map.put('6',Arrays.asList(new String[]{"m","n","o"}));
        map.put('7',Arrays.asList(new String[]{"p","q","r","s"}));
        map.put('8',Arrays.asList(new String[]{"t","u","v"}));
        map.put('9',Arrays.asList(new String[]{"w","x","y","z"}));
        if(digits.length()==1){
            return map.getOrDefault(digits.charAt(0),Collections.emptyList());
        }
        backTrack(digits,0,new StringBuilder());
        return result;
    }
    public static void backTrack(String digit,int idx,StringBuilder path){
        if(path.length() == digit.length()){
            result.add(path.toString());

        }else{
            List<String> chars = map.get(digit.charAt(idx));
            for(String chr : chars){
                path.append(chr);
                backTrack(digit,idx+1,path);
                path.deleteCharAt(path.length()-1);
            }
        }
    }

}
