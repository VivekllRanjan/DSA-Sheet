package Strings;

public class ConsecutiveChar {
    public static void main(String[] args) {
        System.out.println(removeConsecutiveCharacter("VViivveekk"));
    }

    public static String removeConsecutiveCharacter(String s){

        String ans= "";
        ans += s.charAt(0);
        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1)!=s.charAt(i)){
                ans += s.charAt(i);
            }
        }
        return ans;

    }
}
