package Array;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        Map<Character, Integer> count1 = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            count1.put(ch, count1.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> windowMap = new HashMap<>();
        int winLen = s1.length();

        for(int i = 0; i < s2.length(); i++) {
            char chIn = s2.charAt(i);
            windowMap.put(chIn, windowMap.getOrDefault(chIn, 0) + 1);

            if(i >= winLen){
                char chOut = s2.charAt(i - winLen);
                windowMap.put(chOut, windowMap.get(chOut) - 1);
                if (windowMap.get(chOut) == 0) {
                    windowMap.remove(chOut);
                }
            }

            if (windowMap.equals(count1)) {
                return true;
            }
        }

        return false;
    }
}
