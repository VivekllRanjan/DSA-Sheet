package Array;

public class MaxConsecutiveOnes {
    public static int findmax(int[] a){
        int c=0;
        int max=0;
        for(int i:a){
            if(i==1){
                c++;
                max = Math.max(max,c);
            }
            else{
                c=0;
            }
        }
        return max;
    }
    public static void main(String[] args) {

    }
}
