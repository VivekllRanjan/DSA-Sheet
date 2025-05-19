package Misc;

public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1); // Remove the rightmost 1-bit
            count++;
        }
        return count;
    }
    public int hammingWeight2(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) count++;
            n >>>= 1; // Unsigned right shift
        }
        return count;
    }
}
