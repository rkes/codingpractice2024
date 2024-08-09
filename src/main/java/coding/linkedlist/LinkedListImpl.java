package coding.linkedlist;

public class LinkedListImpl {
    static class Node{
        int data;
        Node next;
        public Node(int  data){
            this.data = data;
        }
        public Node(){}
    }
    static Node revNodes(Node node){
        Node temp = node;
        Node next = null;
        Node rev = null;
        while (temp!=null){
            next = temp.next;
            temp.next = rev;
            rev = temp;
            temp = next;
        }
        return rev;
    }
    static Node revNodesRecur(Node node){
        if(node==null || node.next == null){
            return node;
        }
        Node rev = revNodesRecur(node.next);
        rev.next = node;
        return rev;
    }
    static void printList(Node node){
        Node temp = node;
        System.out.println("**************\n");
        while (temp!=null){
            System.out.printf("%d ",temp.data);
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        Node prev = null;
        Node revNodes = revNodesRecur(node);
        printList(revNodes);
    }
}

