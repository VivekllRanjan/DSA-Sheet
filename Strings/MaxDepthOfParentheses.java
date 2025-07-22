package Strings;

public class MaxDepthOfParentheses {
    public int maxDepth(String s) {
        int max = 0, count = 0;

        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                count++;
                max = Math.max(max, count);
            }
            else if(ch ==')') {
                count--;
            }
            else continue;
        }

        return max;
    }
}
