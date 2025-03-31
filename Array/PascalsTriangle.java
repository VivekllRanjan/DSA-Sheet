package Array;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1; i<=numRows; i++){
            ans.add(row(i));
        }
        return ans;
    }
    public static List<Integer> row(int row){

        List<Integer> res = new ArrayList<>();
        res.add(1);
        int x =1;
        for(int i=1; i<row; i++){
            x=x*(row - i);
            x=x/i;
            res.add(x);
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 10;
        List<List<Integer>> ans = generate(n);
        for (List<Integer> it : ans) {
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
