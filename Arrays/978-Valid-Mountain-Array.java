class Solution {
    public boolean validMountainArray(int[] arr) {
        int max = Integer.MIN_VALUE;
        int ind = -1;
        for(int i=0;i<arr.length;i++) {
            if(arr[i]>max)
            {
                max = arr[i];
                ind = i;
            }
        }
        if(ind == 0 || ind == arr.length - 1)
            return false;
        for(int i=0;i<ind;i++) {
            if(arr[i]>=arr[i+1])
                return false;
        }
        for(int i=ind;i<arr.length-1;i++) {
            if(arr[i]<=arr[i+1])
                return false;
        }
        return true;
    }
}