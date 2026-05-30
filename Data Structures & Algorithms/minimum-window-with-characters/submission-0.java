class Solution {
    public String minWindow(String s, String t) {
        if(t.length() == 0)return "";

        Map<Character,Integer> countT = new HashMap<>();
        for(Character entry: t.toCharArray()){
            countT.put(entry, countT.getOrDefault(entry,0)+1);
        }

        int[] res = {-1,-1};
        int resLength = Integer.MAX_VALUE;
        for(int i=0; i<s.length();i++){
            Map<Character,Integer> countS = new HashMap<>();
            for(int j=i; j<s.length(); j++){
                countS.put(s.charAt(j),countS.getOrDefault(s.charAt(j),0)+1);

                boolean flag = true;

                for(char c: countT.keySet()){
                    if(countS.getOrDefault(c,0)<countT.get(c)){
                        flag = false;
                        break;
                    }
                }

                if(flag && (j-i+1)<resLength){
                    resLength = j-i+1;
                    res[0] = i;
                    res[1] = j;
                }
            }
        }

        return resLength == Integer.MAX_VALUE ? "" : s.substring(res[0],res[1]+1);
    }
}
