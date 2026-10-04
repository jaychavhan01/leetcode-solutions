class Solution {
    public int[] separateDigits(int[] nums) {

        ArrayList<Integer> ar = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {

            String s = String.valueOf(nums[i]);

            for(int j = 0; j < s.length(); j++) {
                ar.add(s.charAt(j) - '0');
            }
        }

        int[] a = new int[ar.size()];

        for(int i = 0; i < ar.size(); i++) {
            a[i] = ar.get(i);
        }

        return a;
    }
}