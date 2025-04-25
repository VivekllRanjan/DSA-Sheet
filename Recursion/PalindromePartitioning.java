package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        backtrack(s, 0, curr, ans);
        return ans;
    }

    public static void backtrack(String s, int start, List<String> curr, List<List<String>> ans) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                curr.add(s.substring(start, i + 1));
                backtrack(s, i + 1, curr, ans);
                curr.remove(curr.size() - 1); // backtrack
            }
        }
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> result = partition(s);
        System.out.println("Palindrome Partitions of \"" + s + "\":");
        for (List<String> partition : result) {
            System.out.println(partition);
        }
    }
}