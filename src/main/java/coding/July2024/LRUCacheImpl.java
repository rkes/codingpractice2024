package coding.July2024;
import java.util.*;
public class LRUCacheImpl {
    public static void main(String[] args) {

       LRUCache lruCache = new LRUCache(10);
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
    static class DoublyLinkedList{
        int val;
        int key;
        DoublyLinkedList next;
        DoublyLinkedList prev;
        DoublyLinkedList tail;
        DoublyLinkedList head;
        DoublyLinkedList(){

        }
        private DoublyLinkedList(int key, int val){this.key = key;this.val = val;}
        public DoublyLinkedList append(int key ,int val){
            DoublyLinkedList node = new DoublyLinkedList(key,val);
            if(tail == null){
                tail = node;
                head = node;
            }else{
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
            return node;
        }
        public DoublyLinkedList deleteFirst(){
            if(head == null){
                return null;
            }
            if(head == tail){
                DoublyLinkedList clone = new DoublyLinkedList(head.key, head.val);
                tail = head = null;
                return clone;
            }
            DoublyLinkedList iterClone = new DoublyLinkedList(head.key, head.val);
            DoublyLinkedList temp = head.next;
            temp.prev = null;
            head = temp;
            return iterClone;
        }
        public void delete(DoublyLinkedList node){
            if(node==null) return;
            if(node == head) {
                deleteFirst();
                return;
            }
            if(node == tail){
                tail = node.prev;
                if(tail!=null) tail.next = null;
                return;

            }
            DoublyLinkedList prev = node.prev;
            DoublyLinkedList next = node.next;
            if(prev!=null)
                prev.next = node.next;
            if(next.prev!=null)
                next.prev = node.prev;
        }
        public void printLinkedList(){
            DoublyLinkedList temp = head;
            while (temp!=null){
                System.out.printf("%d  ",temp.val);
                temp = temp.next;
            }
        }
    }
    static class  LRUCache {
        Map<Integer,DoublyLinkedList> map = new HashMap<>();
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        private final int maxLen;
        public LRUCache(int capacity) {
            maxLen = capacity;
        }

        public int get(int key) {
            DoublyLinkedList node = map.getOrDefault(key,null);
            if(node == null){
                return -1;
            }
            doublyLinkedList.delete(node);
            node = doublyLinkedList.append(node.key,node.val);
            map.put(key,node);
            return node.val;
        }

        public void put(int key, int value) {
            if(map.containsKey(key)){
                DoublyLinkedList node = map.get(key);
                doublyLinkedList.delete(node);
                map.put(key,doublyLinkedList.append(key,value));
            }else {
                if (map.size() >= maxLen) {
                    DoublyLinkedList deletedNode = doublyLinkedList.deleteFirst();
                    map.remove(deletedNode.key);
                }
                int val = get(key);
                if (val == -1) {
                    map.put(key, doublyLinkedList.append(key, value));
                }
            }
        }
    }
}
