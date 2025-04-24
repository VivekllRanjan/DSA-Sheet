package Recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        build(ans, "",0,0,n);
        return ans;
    }

    public static void build(List<String> ans, String curr,int open, int close, int n) {
        //Base case
        if(curr.length() == 2*n){
            ans.add(curr);
            return;
        }

        if(open < n) build(ans, curr + "(", open + 1, close, n);

        if(close<open) build(ans, curr + ")", open, close + 1, n);
    }
    public static void main(String[] args) {
        int n = 3;
        List<String> result = generateParenthesis(n);
        System.out.println(result); // Expected output: ["((()))", "(()())", "(())()", "()(())", "()()()"]
    }

}
