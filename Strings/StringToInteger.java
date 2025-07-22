package Strings;

public class StringToInteger {
    public int myAtoi(String s) {
        int idx = 0;
        int ans = 0;
        boolean neg = false;
        while(idx < s.length() && s.charAt(idx) == ' '){
            idx++;
        }
        if(idx < s.length()) {
            if(s.charAt(idx) == '-') {
                neg = true;
                idx++;
            }
            else if(s.charAt(idx) == '+') {
                idx++;
            }
        }

        while(idx < s.length() && Character.isDigit(s.charAt(idx))) {
            int curr = s.charAt(idx) - '0';
            if (ans > (Integer.MAX_VALUE - curr) / 10) {
                return !neg ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            idx++;
            ans = ans * 10 + curr;
        }
        if(neg) ans = ans * -1;
        return ans;

    }
}
