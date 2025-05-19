package Misc;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();

        while(!visited.contains(n)) {
            visited.add(n);
            if(n == 1){
                return true;
            }
            n = sumOfSquare(n);
        }
        return false;
    }

    private int sumOfSquare(int num) {
        int ans = 0;
        while(num > 0) {
            int x = num % 10;
            ans = ans + (x * x);
            num = num/10;
        }

        return ans;
    }
}
