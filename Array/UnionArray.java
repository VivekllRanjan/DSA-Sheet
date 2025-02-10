package Array;

import java.util.ArrayList;

public class UnionArray {
    public static ArrayList<Integer> findUnion(int[] a, int[] b){
        ArrayList<Integer> ans = new ArrayList<>();
        int n1 = a.length;
        int n2 = b.length;
        int i=0;
        int j=0;
        Integer lastAdded = null;

        while(i<n1 && j<n2){
            if(a[i] < b[j]){
                if(lastAdded == null || !lastAdded.equals(a[i])){
                    ans.add(a[i]);
                    lastAdded = a[i];
                }
                i++;
            }
            else {
                if(lastAdded == null || !lastAdded.equals(b[j])) {
                    ans.add(b[j]);
                    lastAdded = b[j];
                }
                j++;
                if(a[i] == b[j-1]) i++;
            }
        }

        while(i<n1){
            if (lastAdded == null || !lastAdded.equals(a[i])) {
                ans.add(a[i]);
                lastAdded = a[i];
            }
            i++;
        }

        while(j<n2){
            if (lastAdded == null || !lastAdded.equals(b[j])) {
                ans.add(b[j]);
                lastAdded = b[j];
            }
            j++;
        }

        return ans;
    }
    public static void main(String[] args) {

        int[] a = {2,2,3,4,5};
        int[] b = {1,1,2,3,4};

        System.out.println(findUnion(a,b).toString());

    }
}
