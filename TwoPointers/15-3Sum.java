
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {

            // Skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int p = i + 1;
            int q = n - 1;

            while (p < q) {

                long sum = (long) nums[i] + nums[p] + nums[q];

                if (sum < 0) {
                    p++;
                }
                else if (sum > 0) {
                    q--;
                }
                else {

                    ans.add(Arrays.asList(
                            nums[i],
                            nums[p],
                            nums[q]
                    ));

                    p++;
                    q--;

                    // Skip duplicates
                    while (p < q && nums[p] == nums[p - 1])
                        p++;

                    while (p < q && nums[q] == nums[q + 1])
                        q--;
                }
            }
        }

        return ans;
    }
}