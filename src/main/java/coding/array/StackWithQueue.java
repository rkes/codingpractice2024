package coding.array;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithQueue {
    static class Stack{
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        public void push(Integer integer){
            queue1.offer(integer);
        }
        public boolean isEmpty(){
            return queue1.isEmpty();
        }
        public Integer pop(){
            Integer lastElem = -1;
            if(queue1.isEmpty()){
                return lastElem;
            }
            while (!queue1.isEmpty()){
                lastElem= queue1.poll();
                if(queue1.isEmpty()){
                    queue1 = queue2;
                    queue2 = new LinkedList<>();
                    return lastElem;
                }
                queue2.offer(lastElem);
            }
            return lastElem;
        }
    }
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(10);
        stack.push(11);
        stack.push(3);
        while (!stack.isEmpty())
            System.out.println(stack.pop());
        //System.out.println(stack.pop());
        //System.out.println(stack.pop());
    }

}
