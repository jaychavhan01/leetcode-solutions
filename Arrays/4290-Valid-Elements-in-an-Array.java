import java.util.*;

class Solution {
    public List<Integer> findValidElements(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();

        // Step 1: Build rightMax array
        int[] rightMax = new int[n];
        rightMax[n - 1] = Integer.MIN_VALUE;

        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i + 1]);
        }

        // Step 2: Traverse and check conditions
        int maxLeft = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (
                i == 0 || 
                i == n - 1 || 
                nums[i] > maxLeft || 
                nums[i] > rightMax[i]
            ) {
                result.add(nums[i]);
            }

            maxLeft = Math.max(maxLeft, nums[i]);
        }

        return result;
    }
}