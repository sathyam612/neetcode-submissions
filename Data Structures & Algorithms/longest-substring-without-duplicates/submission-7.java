class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> newMap = new HashMap<>();
        int l =0, res=0;
        for(int r=0;r<s.length();r++){
            if(newMap.containsKey(s.charAt(r))){
                l= Math.max(newMap.get(s.charAt(r))+1,l);
            }
            newMap.put(s.charAt(r),r);
            res = Math.max(res, r-l +1);
        }
        return res;
    }
}
