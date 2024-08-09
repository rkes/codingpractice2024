package coding.array;

import coding.LinkedList;
import coding.LinkedList.ListNode;

import java.util.Arrays;

public class Revision {

    public static void main(String[] args) {
        int []ar={1,2,3,4};
        //printAllPermutation(ar,0,ar.length);
        ListNode listNode = new ListNode(0);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next = new ListNode(5);
        LinkedList.printAllNodes(listNode);
        System.out.println("\nAfter Reverse");
        LinkedList.printAllNodes(revLinkedList(listNode));

    }
    public static ListNode revLinkedList(ListNode lst){
        ListNode temp=lst;
        ListNode p,q=null;
        while(temp!=null){
            p=temp.next;
            temp.next = q;
            q=temp;
            temp=p;
        }
        return q;
    }
    public static void printAllPermutation(int []ar,int start,int end){
        if(start==end){
           Arrays.stream(ar).forEach(a-> System.out.printf("%d,",a));
           System.out.println();
        }
        else{
            for(int i=start;i<end;i++){
                swap(ar,i,start);
                printAllPermutation(ar,start+1,end);
                swap(ar,i,start);
            }
        }
    }
    public static void swap(int []ar,int a,int b){
        int t = ar[a];
        ar[a] = ar[b];
        ar[b] = t;
    }

}
