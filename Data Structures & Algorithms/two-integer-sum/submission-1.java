class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> newMap = new HashMap<>();
        for(int i=0; i<nums.length;i++){
            int diff = target - nums[i];
            if(newMap.containsKey(diff)){
                return new int[]{newMap.get(diff), i};
            }
            newMap.put(nums[i], i);
        }
        return new int[]{0,0};
    }
}
