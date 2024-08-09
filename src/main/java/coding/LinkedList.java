package coding;

import javax.swing.*;

public class LinkedList {
    public static class ListNode {
      public int val;
      public ListNode next;
      ListNode() {}
     public ListNode(int val) { this.val = val; }
      public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
       // listNode.next = new ListNode(2);
       // listNode.next.next = new ListNode(3);
      //  listNode.next.next.next = new ListNode(4);
      //  listNode.next.next.next.next= new ListNode(5);
      //  listNode.next.next.next.next.next= new ListNode(6);
        printAllNodes(listNode);
        ListNode temp = removeNthFromEnd(listNode,1);
        System.out.println();
        printAllNodes(temp);
    }
    public static void printAllNodes(ListNode temp){
        while (temp!=null){
            System.out.printf("%d ",temp.val);
            temp=temp.next;
        }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        StringBuilder stringBuilder = new StringBuilder();
        ListNode second = head;
        for(int i=0;i<n;i++){
            if(second.next == null){
                if(i == n-1){
                    head = head.next;
                }
                return head;
            }
            second = second.next;
        }
        while(second.next!=null){
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        return head;
    }
}
