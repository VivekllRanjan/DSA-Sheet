package StacksAndQueues;

import java.util.Stack;

public class ReversePolishNotations {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        int res = 0;
        for(String token : tokens) {

            if(token.equals("+")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b + a);
            }
            else if(token.equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            }
            else if(token.equals("*")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b * a);
            }
            else if(token.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            }
            else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
