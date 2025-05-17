package StacksAndQueues;

import java.util.Stack;

public class DailyTemperature {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temp.length];

        for(int i = 0; i < temp.length; i++) {
            while(!stack.isEmpty() && temp[i] > temp[stack.peek()]){
                int prevIdx = stack.pop();
                ans[prevIdx] = i - prevIdx;
            }
            stack.push(i);
        }

        return ans;
    }
}
