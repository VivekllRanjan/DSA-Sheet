package Strings;

public class IntegerToString {
    public String intToRoman(int num) {
        int[] values = {
                1000, 900, 500, 400,
                100, 90, 50, 40,
                10, 9, 5, 4, 1
        };

        String[] symbols = {
                "M", "CM", "D", "CD",
                "C", "XC", "L", "XL",
                "X", "IX", "V", "IV", "I"
        };

        StringBuilder res = new StringBuilder();

        for(int i = 0; i < values.length; i++) {
            while(num >= values[i]){
                num = num - values[i]; //3999 - 1000, 2999 - 1000, 1999 - 1000 = 999 (break); 999-900 = 99(break); 99-90 = 9(break);
                res.append(symbols[i]); // M M M; CM; XC; IX; => MMMCMXCIX
            }
        }
        return res.toString();
    }
}
