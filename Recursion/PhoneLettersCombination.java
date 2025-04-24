package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PhoneLettersCombination {
    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if(digits == null || digits.length() == 0) return ans;

        String[] mapping = new String[]{
                "", "", //0 & 1
                "abc",  //2
                "def",  //3
                "ghi",  //4
                "jkl",  //5
                "mno",  //6
                "pqrs", //7
                "tuv",  //8
                "wxyz"  //9
        };

        buildString(digits, 0, new StringBuilder(), mapping, ans);
        return ans;
    }

    public static void buildString(String d, int idx, StringBuilder curr, String[] mapping, List<String> ans) {
        //Base case
        if(idx == d.length()) {
            ans.add(curr.toString());
            return;
        }

        String letters = mapping[d.charAt(idx) - '0'];

        for(char ch : letters.toCharArray()) {
            curr.append(ch); //Choose
            buildString(d,idx+1, curr,mapping,ans); //Build
            curr.deleteCharAt(curr.length() -1); //Backtrack
        }
    }

    public static void main(String[] args) {
        // Test case 1
        String digits = "23";
        List<String> result = letterCombinations(digits);
        System.out.println(result); // Expected output: [ad, ae, af, bd, be, bf, cd, ce, cf]

        // Test case 2
        digits = "7";
        result = letterCombinations(digits);
        System.out.println(result); // Expected output: [p, q, r, s]

        // Test case 3
        digits = "";
        result = letterCombinations(digits);
        System.out.println(result); // Expected output: []
    }
}
