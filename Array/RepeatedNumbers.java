package Array;

import java.util.Arrays;

public class RepeatedNumbers {

    public static void main(String[] args) {
        int arr[] = {3, 1, 2, 5, 3};
        System.out.println(Arrays.toString(repeatedNumber(arr)));
    }

    public static int[] repeatedNumber(final int[] arr) {
        int n = arr.length;
        int i;
        int XOR =0;
        for(i=0; i<n; i++){
            XOR^=arr[i];
        }
        for (i=1; i<=n; i++){
            XOR^=i;
        }

        int x=0,y=0;

        int RSB = XOR & (~(XOR-1)); //Right most set bit

        //XOR bucket 1 in x
        //XOR bucket 2 in y

        //Array
        for(i=0;i<n;i++){
            if((arr[i] & RSB)!=0){
                x = x^arr[i]; //Bucket 1 XOR
            }
            else
                y = y^arr[i]; //Bucket 2 XOR
        }

        //Array 1 to N
        for(i =1; i<=n; i++){
            if((i & RSB)!=0){
                x = x^i; //Bucket 1 XOR
            }
            else
                y = y^i; //Bucket 2 XOR
        }

        int res[] = {0,0};
        boolean flagx = false;
        for(i=0; i<n; i++){
            if(arr[i]==x){
                flagx = true;
                break;
            }
        }

        if(flagx){
            res[0] = x;
            res[1] = y;
        }
        else {
            res[0] = y;
            res[1] = x;
        }

        return res;
    }
}
