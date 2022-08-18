package Strings;

public class Anagram {
    public static void main(String[] args) {
        String s="mango";
        String t="goman";
        System.out.println(isAnagram(s,t));
    }

    public static boolean isAnagram(String s, String t) {
        int alpha[] = new int[26];

        if(s.length() != t.length()){
            return false;
        }
        for(int i=0; i<s.length(); i++){
            alpha[s.charAt(i) - 'a']++;
            alpha[t.charAt(i) - 'a']--;
        }
        for(int i:alpha){
            if(i!=0)
                return false;
        }
        return true;
    }
}
