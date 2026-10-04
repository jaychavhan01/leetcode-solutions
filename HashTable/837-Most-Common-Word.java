class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String words[] = paragraph.toLowerCase().replaceAll("[^a-zA-Z]", " ").split("\\s+");
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        HashMap<String,Integer> map = new HashMap<>();
        for(String word:words) {
           if (!word.isEmpty() && !bannedSet.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        String res="";
        int max = 0;
        for(Map.Entry<String,Integer> m:map.entrySet()) {
           if (m.getValue() > max) {
                res = m.getKey();
                max = m.getValue();
            }
        }
        return res;
    }
}