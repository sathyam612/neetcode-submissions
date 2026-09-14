class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupMap = new HashMap<>();

        for(String str: strs){
            int[] count = new int[26];
            for(char s: str.toCharArray()){
                count[s - 'a']++;
            }
            String key = Arrays.toString(count);
            groupMap.putIfAbsent(key, new ArrayList<>());
            groupMap.get(key).add(str);
        }

        return new ArrayList<>(groupMap.values());
    }
}
