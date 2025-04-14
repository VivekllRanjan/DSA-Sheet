package Array;

public class BS2DArrayPeak {
    public static int findMax(int[] arr){
        int max = Integer.MIN_VALUE;
        int ans = -1;
        for(int i=0;i<arr.length;i++){
            if(arr[i] > max){
                max = arr[i];
                ans = i;
            }
        }
        return ans;
    }

    public static int[] findPeakGrid(int[][] mat) {
        int ans[] = {-1,-1};
        int m = mat.length,n = mat[0].length;

        int st = 0, end = m-1;
        while(st<=end){
            int mid = st+(end-st)/2;
            int maxi = findMax(mat[mid]);

            // Check if max element in that row can be the peak element
            int up = (mid-1 >= 0) ? mat[mid-1][maxi] : -1;
            int down = (mid+1 < m) ? mat[mid+1][maxi] : -1;
            if(mat[mid][maxi] > up && mat[mid][maxi] > down){
                ans[0] = mid; ans[1] = maxi;
                return ans;
            }
            else if(mat[mid][maxi] < up) end = mid-1;
            else st = mid+1;
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
