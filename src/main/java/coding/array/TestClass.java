package coding.array;

import java.util.*;
import java.util.stream.Collectors;

public class TestClass {
    public static void main(String[] args) {
        Map<String,Integer> mp = new LinkedHashMap<>();
        mp.put("a",10);
        mp.put("b",7);
        List<Map.Entry<String,Integer>> lst2 = new ArrayList<>(mp.entrySet());
        Collections.sort(lst2,(o1,o2)->{
            return o1.getValue()-o2.getValue();
        });
           mp = new LinkedHashMap<>();
        for(Map.Entry<String,Integer> mp3:lst2){
            mp.put(mp3.getKey(),mp3.getValue());
        }
        System.out.println(mp);
        List<String> lst = new ArrayList<>();
        lst.add("Rakesh");
        lst.add("Mahesh");
        lst.add("Suresh");
        Collections.reverse(lst);
        System.out.println(String.join(",",lst));
        System.out.println(lst.stream().collect(Collectors.joining(",")));
    }
}
