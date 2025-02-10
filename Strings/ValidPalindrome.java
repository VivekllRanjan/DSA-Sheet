
public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        if(isPlaindrome(s))
            System.out.println("Yes");
        else System.out.println("No");
    }

    private static boolean isPlaindrome(String s){
        int l=0;
        int r=s.length()-1;

        while (l<r){
            while(l<r && !Character.isLetterOrDigit(s.charAt(l)))
                l++;
            while(l<r && !Character.isLetterOrDigit(s.charAt(r)))
                r--;
            if(Character.toUpperCase(s.charAt(l)) != Character.toUpperCase(s.charAt(r)))
                return false;

            l++;
            r--;
        }
        return true;
    }
}
