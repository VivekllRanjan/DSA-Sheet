package Strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Isomorphic {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mp = new HashMap<>();
        Set<Character> mapped = new HashSet<>();

        if(s.length() != t.length()) return false;

        int idx = 0;
        while(idx < s.length()) {
            if(mp.containsKey(s.charAt(idx))) {
                if(mp.get(s.charAt(idx)) != t.charAt(idx)) return false;
                else idx++;
            }
            else {
                if (mapped.contains(t.charAt(idx))) return false;
                mp.put(s.charAt(idx), t.charAt(idx));
                mapped.add(t.charAt(idx));
                idx++;
            }
        }

        return true;
    }
}
