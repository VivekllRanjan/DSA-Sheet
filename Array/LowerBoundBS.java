package Array;

public class LowerBoundBS {
    public int[] getFloorAndCeil(int x, int[] arr) {
        int[] ans = {-1, -1}; // Default values for floor and ceil

        // Finding the floor using binary search
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                ans[0] = arr[mid];  // x is the floor and ceil both
                ans[1] = arr[mid];
                return ans;
            } else if (arr[mid] < x) {
                ans[0] = arr[mid];  // arr[mid] is a potential floor
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // Finding the ceil using binary search
        low = 0; high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                ans[1] = arr[mid];  // x is the ceil and floor both
                return ans;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                ans[1] = arr[mid];  // arr[mid] is a potential ceil
                high = mid - 1;
            }
        }

        return ans;
    }
    public static int lowerBound(int []arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] >= x) {
                ans = mid;
                //look to the left for smallest number greater than target
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right as x is greater than mid
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {9,9,9,9,9,9};
        int x = 10;
        int ind = lowerBound(arr, arr.length, x);
        System.out.println("The lower bound is the index: " + ind);
    }
}
