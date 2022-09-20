package Array;

public class PairInSortedRotated {
    public static void main(String[] args) {
        int[] arr={11, 15, 6, 8, 9, 10};
        System.out.println(solution(arr,6,16));
    }

    public static boolean solution(int arr[], int n, int x){
        int p;
        for(p=0; p<n; p++)
            if(arr[p]>arr[p+1])
                break;
        //Modulus is done so that l does not go out of bound and start from 0th index after it reaches last element
        int l = (p+1)%n;
        int s = p;

        while(l!=s){
            if(arr[l]+arr[s] == x)
                return true;
            else if(arr[l]+arr[s] < x)
                l=(l+1)%n; //returns l+1
            else s = (n+s-1)%n; //return s-1
        }
        return false;
    }
}
