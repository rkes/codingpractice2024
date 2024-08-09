package coding.array;

public class LinkedList {
 public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public static void main(String[] args) {
        ListNode node = createLinkedList(new int[]{1,2,3,4,5,6,7});
        printLinkedList(node);
    }

    public static void printLinkedList(ListNode lstNode){
        ListNode temp= lstNode;
        while (temp!=null){
            System.out.printf("%d  ",temp.val);
            temp = temp.next;
        }
        System.out.println();
    }
    public static ListNode createLinkedList(int []ar){
        ListNode temp = null;
        ListNode head = temp;
        for(int j:ar){
            if(temp == null){
                temp = new ListNode(j);
                head = temp;
            }else{
                temp.next = new ListNode(j);
                temp = temp.next;
            }

        }
        return head;
    }
}
