class Solution {
    private List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList<>();
        backtrack(nums, target, new ArrayList<>(),0);
        return result;
    }

    private void backtrack(int[] nums, int remaining, List<Integer> current, int start){

        if(remaining == 0){
            result.add(new ArrayList<>(current));
            return;
        }

        if(remaining < 0){
            return;
        }


        for(int i = start; i<nums.length;i++){

            current.add(nums[i]);
            backtrack(nums, remaining-nums[i],current,i);
            current.remove(current.size() -1);
        }
    }
}
