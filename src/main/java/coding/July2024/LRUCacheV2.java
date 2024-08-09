package coding.July2024;
import java.util.*;
public class LRUCacheV2 {
    public static void main(String[] args) {
        //System.out.println(dd.deleteFirst().val);
        //System.out.println(dd.deleteFirst().val);
        LRUCache lruCache = new LRUCache(10);
        /*   LRUCache lruCache = new LRUCache(2);
        LRUCache cache = new LRUCache(2); // Capacity of 3

        // Add three items
        cache.put(1, 1); // Cache: {1=1}
        cache.put(2, 2); // Cache: {2=2, 1=1}
        cache.put(1, 10); // Update key 1, Cache: {2=2, 1=10}
        cache.put(2, 20); // Update key 2, Cache: {1=10, 2=20}
        System.out.println(cache.get(1)); // Returns 10
        System.out.println(cache.get(2)); // Returns 20
     //   cache.put(1, 1); // Cache is {1=1, 2=2, 3=3}
      //  System.out.println(cache.get(1));

        // cache.put(3,3);
        //cache.put(4,4);
        //System.out.println(cache.get(2));
        System.out.println("-------------------------------");
        // At this point, adding another item should evict the least recently used item
        cache.put(4, 4); // Cache should be {2=2, 3=3, 4=4} (1 is evicted)
        cache = new LRUCache(0);
        cache.put(1, 1); // Cache: {1=1}
        System.out.println(cache.get(1)); // Returns 1, Cache: {1=1}
        cache.put(2, 2); // Evicts key 1, Cache: {2=2}
        System.out.println(cache.get(1)); // Returns -1 (not found)
        System.out.println(cache.get(2)); // Returns 2, Cache: {2=2}

        //System.out.println(lruCache.get(2)+"\n"+lruCache.get(2));
       /* System.out.println("****************3**********************");
        lruCache.put(2,1);lruCache.put(2,2); System.out.println(lruCache.get(2));
        lruCache.put(1,1);lruCache.put(4,1);System.out.println(lruCache.get(2));
        System.out.println("***************2***********************");

        lruCache = new LRUCache(1);

       // System.out.println(lruCache.get(1));


        lruCache.put(2,1);System.out.println(lruCache.get(2));
        lruCache.put(3,2);System.out.println(lruCache.get(2));System.out.println(lruCache.get(3));
        System.out.println("***************1***********************");
        lruCache = new LRUCache(2);
        lruCache.put(1,1);lruCache.put(2,2);System.out.println(lruCache.get(1));
        lruCache.put(3,3);System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1)+" "+lruCache.get(3)+"  "+lruCache.get(4));
        System.out.println(lruCache);
*/
        lruCache = new LRUCache(10);
        lruCache.put(10,13);lruCache.put(3,17);lruCache.put(6,11);lruCache.put(10,5);lruCache.put(9,10);
        System.out.println(lruCache.get(13));
        lruCache.put(2,19);
        System.out.println(lruCache.get(2)+"  "+lruCache.get(3));
        lruCache.put(5,25);
        System.out.println(lruCache.get(8));
        lruCache.put(9,22);lruCache.put(5,5);lruCache.put(1,30);
        System.out.println(lruCache.get(11));
        lruCache.put(9,12);
        System.out.println(lruCache.get(7)+"  "+lruCache.get(5)+"  "+lruCache.get(8)+"  "+lruCache.get(9));
        lruCache.put(4,30);lruCache.put(9,13);
        System.out.println(lruCache.get(9)+"  "+lruCache.get(10)+"  "+lruCache.get(10));
        lruCache.put(6,14);lruCache.put(3,1);
        System.out.println(lruCache.get(3));
        lruCache.put(10,11);
        System.out.println(lruCache.get(8));
        lruCache.put(2,14);
        System.out.println(lruCache.get(1)+"  "+lruCache.get(5)+"  "+lruCache.get(4));
        lruCache.put(11,14);lruCache.put(12,24);lruCache.put(5,18);
        System.out.println(lruCache.get(13));
        lruCache.put(7,23);
        System.out.println(lruCache.get(8)+"  "+lruCache.get(12));
        lruCache.put(3,27);lruCache.put(2,12);
        System.out.println(lruCache.get(5));
        lruCache.put(2,9);lruCache.put(13,4);lruCache.put(8,18);lruCache.put(1,7);
        System.out.println(lruCache.get(6));
        lruCache.put(9,29);lruCache.put(8,21);
        System.out.println(lruCache.get(5));
        lruCache.put(6,30);lruCache.put(1,12);
        System.out.println(lruCache.get(10));
        lruCache.put(4,15);lruCache.put(7,22);lruCache.put(11,26);lruCache.put(8,17);lruCache.put(9,29);
        System.out.println(lruCache.get(5));
    }
    static class LRUCache {
        DoublyLinkedList2 doublyLinkedList2 ;
        private final int capacity;
        Map<Integer,DoublyLinkedList2> map = new HashMap<>();
        public LRUCache(int capacity) {
            this.capacity = capacity;
            doublyLinkedList2 = new DoublyLinkedList2();
        }

        public int get(int key) {
            if(map.containsKey(key)){
                DoublyLinkedList2 node = map.get(key);
                doublyLinkedList2.delete(node);
                DoublyLinkedList2 newNode =doublyLinkedList2.append(node.key,node.val);
                map.put(key,newNode);
                return node.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            if(!map.containsKey(key)) {
                if(map.size()>=capacity){
                   DoublyLinkedList2 node =  doublyLinkedList2.deleteFirst();
                   if(node!=null)
                    map.remove(node.key);
                }
            }
            else{
                DoublyLinkedList2 node =  map.get(key);
                map.remove(key);
                doublyLinkedList2.delete(node);
            }
            DoublyLinkedList2 newNode = doublyLinkedList2.append(key, value);
            map.put(key, newNode);
        }
    }
    static class DoublyLinkedList2{
        DoublyLinkedList2 next;
        DoublyLinkedList2 prev;
        DoublyLinkedList2 head;
        DoublyLinkedList2 tail;
        int key;
        int val;
        public DoublyLinkedList2(){

        }
        public void print(){
            DoublyLinkedList2 temp = head;
            System.out.println("\n*****************************************");
            while (temp!=null){
                System.out.printf("%d ",temp.val);
                temp = temp.next;
            }
        }
        DoublyLinkedList2(int key,int val){
            this.key = key;
            this.val = val;
        }
        public DoublyLinkedList2 append(int key,int val){
            DoublyLinkedList2 node = new DoublyLinkedList2(key,val);
            if(head == null){
                head = tail = node;
                return node;
            }
            node.prev = tail;
            tail.next = node;
            tail = node;
            return node;
        }
        public DoublyLinkedList2 deleteFirst(){
            if(head == null){
                return null;
            }
            DoublyLinkedList2 temp = new DoublyLinkedList2(head.key,head.val);
            if(head == tail){
                head = tail =null;
                temp.next = null;
                return temp;
            }
            DoublyLinkedList2 next = head.next;
            next.prev = null;
            head = next;
            return temp;
        }
        public DoublyLinkedList2 delete(DoublyLinkedList2 node){
            if(head == null){
                return null;
            }
            if(head == node){
                return deleteFirst();
            }
            DoublyLinkedList2 temp = new DoublyLinkedList2(node.key, node.val);
            if(node == tail){
               tail = node.prev;
               if(tail!=null)
                tail.next = null;
               return temp;
            }
            DoublyLinkedList2 next = node.next;
            DoublyLinkedList2 prev = node.prev;
            if(next!=null){
                next.prev = prev;
            }
            if(prev!=null){
                prev.next = next;
            }
            return temp;
        }
    }
}
