class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])) {
                int count = map.get(arr[i]);
                map.put(arr[i], count + 1);
            } 
            else {
                map.put(arr[i], 1);
            }
        }
        ArrayList<Integer> ar = new ArrayList<>();
        for(int val : map.values()) {
            if(ar.contains(val)) {
                return false;
            }
            else {
                ar.add(val);
            }
        }
        return true;

    }
}