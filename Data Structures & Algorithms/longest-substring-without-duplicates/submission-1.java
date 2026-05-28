class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        if(s.length() == 0){
            return 1;
        }
        for(int i=0; i<s.length()-1;i++){
            Set<Character> newSet = new HashSet<>();
            for(int j=i; j<s.length()-1;j++){
                if(newSet.contains(s.charAt(j)))break;
                newSet.add(s.charAt(j));
            }
            res=Math.max(res,newSet.size());
        }

        return res;
    }
}
