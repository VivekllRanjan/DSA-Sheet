package Array;

public class BSMedianOf2SortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length > nums2.length){ //Ensures nums1 is smallerst array
            return findMedianSortedArrays(nums2, nums1);
        }

        int n = nums1.length;
        int m = nums2.length;
        int totalcut = (n + m + 1) / 2; //Left half gets 1 extra, includes the median

        int st = 0, end = n; //0 to n elements from shorter array is taken

        while(st <= end){
            int cut1 = st + (end - st) / 2; //take cut1 number of elements from nums1
            int cut2 = totalcut - cut1; //take cut2 number of elements from nums 2

            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1-1]; //Left end element in nums1
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2-1]; //Left end elemets in nums2

            int r1 = (cut1 == n) ? Integer.MAX_VALUE : nums1[cut1]; //Right start element in nums1
            int r2 = (cut2 == m) ? Integer.MAX_VALUE : nums2[cut2]; //Right start element in nums2

            //Check if left half selected is correct
            if(l1 <= r2 && l2 <= r1){ //Correct left half selected
                if((n+m) % 2 == 0){
                    return (Math.max(l1,l2) + Math.min(r1,r2)) / 2.0; //(Left last element + Right first element) / 2
                }
                else return Math.max(l1,l2); //Last element in the left half
            }
            else if(l1 > r2) end = cut1 - 1; //The nums1 last element is greater => Reduce it
            else st = cut1 + 1; //Can take more elemets
        }

        return 0.0;
    }

    public static void main(String[] args) {

    }
}
