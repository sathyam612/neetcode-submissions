class NumArray {
    private final int[] prefix;
    public NumArray(int[] nums) {
        prefix = new int[nums.length];
        int cur = 0;
        for(int i=0; i<nums.length;i++){
            cur+=nums[i];
            prefix[i] = cur;
        }
    }
    
    public int sumRange(int left, int right) {
        int leftsum = left>0 ? prefix[left - 1] : 0;
        int rightsum = prefix[right];
        return rightsum - leftsum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */