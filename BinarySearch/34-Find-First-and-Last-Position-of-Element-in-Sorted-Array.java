class Solution {
    public static int[] searchRange(int[] nums, int target) {
        // Initialize the result array with the default not-found value
        int[] result = {-1, -1};

        // Find the starting position of the target
        result[0] = findFirst(nums, target);

        // If the starting position is found, find the ending position
        if (result[0] != -1) {
            result[1] = findLast(nums, target);
        }

        return result;
    }

    /**
     * Helper function to find the first occurrence of the target using binary search.
     * It continues searching in the left half of the array even after a match is found,
     * to find the earliest possible index.
     */
    private static int findFirst(int[] nums, int target) {
        int index = -1;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Avoids potential integer overflow

            if (nums[mid] >= target) {
                // If mid element is >= target, we might be on or past the first occurrence.
                // We need to search in the left half for a potentially earlier index.
                high = mid - 1;
            } else {
                // If mid element is < target, the first occurrence must be in the right half.
                low = mid + 1;
            }

            // If we find the target, store the index. The loop will continue to check
            // for an earlier occurrence.
            if (nums[mid] == target) {
                index = mid;
            }
        }
        return index;
    }

    /**
     * Helper function to find the last occurrence of the target using binary search.
     * It continues searching in the right half of the array even after a match is found,
     * to find the latest possible index.
     */
    private static int findLast(int[] nums, int target) {
        int index = -1;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Avoids potential integer overflow

            if (nums[mid] <= target) {
                // If mid element is <= target, we might be on or before the last occurrence.
                // We need to search in the right half for a potentially later index.
                low = mid + 1;
            } else {
                // If mid element is > target, the last occurrence must be in the left half.
                high = mid - 1;
            }

            // If we find the target, store the index. The loop will continue to check
            // for a later occurrence.
            if (nums[mid] == target) {
                index = mid;
            }
        }
        return index;
    }
}