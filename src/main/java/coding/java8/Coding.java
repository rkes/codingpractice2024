package coding.java8;

import java.util.Stack;

public class Coding {
    public static class T1{
        private void test(){

        }
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stck = new Stack<>();
        for(String t:tokens){
            if(t.equals("+")||t.equals("-")||t.equals("*")||t.equals("/")){
                if(!stck.isEmpty()){
                    int a = stck.pop();
                    if(!stck.isEmpty()){
                        int b = stck.pop();
                        switch(t){
                            case "+":
                                stck.push(a+b);
                                break;
                            case "-":
                                stck.push(b-a);
                                break;
                            case "*":
                                stck.push(b*a);
                                break;
                            case "/":
                                stck.push(b/a);
                                break;
                        }
                    }
                }
            }else{
                stck.push(Integer.parseInt(t));
            }
        }
        return stck.peek();
    }
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"4","13","5","/","+"}));
    }

}
