package Array;

public class BS2DArray {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int rSt = 0,rEnd = m-1;
        //find mid row and check range in mid row column

        while(rSt <= rEnd){
            int rMid = rSt+(rEnd-rSt)/2;
            if(matrix[rMid][0] <= target && target <= matrix[rMid][n-1]){ //target exists in this row
                //Binary Search in this row
                int cSt = 0,cEnd = n-1;
                while(cSt <= cEnd){
                    int cMid = cSt+(cEnd-cSt)/2;
                    if(matrix[rMid][cMid] == target) return true;
                    else if(target < matrix[rMid][cMid]) cEnd = cMid-1;
                    else cSt = cMid+1;
                }
                return false;
            }
            else if(target > matrix[rMid][n-1]) rSt = rMid + 1;
            else rEnd = rMid - 1;
        }

        return false;
    }

    public static boolean searchMatrixII(int[][] arr, int t) {
        int m = arr.length,n = arr[0].length;
        int r = 0,c = n-1;

        while(c >= 0 && r < m){
            if(t == arr[r][c]) return true;
            else if(t < arr[r][c]) c--;
            else r++;
        }
        return false;
    }

    public static void main(String[] args) {
        int arr1[][] = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(searchMatrix(arr1,100));
    }
}
