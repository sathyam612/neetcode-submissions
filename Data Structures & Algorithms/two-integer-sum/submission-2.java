class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [][] original = new int[nums.length] [2];
        for(int i=0; i<nums.length; i++){
            original[i][0] = nums[i];
            original[i][1] = i;
        }

        Arrays.sort(original,(a,b)-> Integer.compare(a[0],b[0]));

        int left = 0 , right = nums.length -1;
        while(left<right){
            int sum = original[left][0]+ original[right][0];
            if( sum == target){
                return new int[]{Math.min(original[left][1], original[right][1]), Math.max(original[left][1], original[right][1])};
            }
            else if (sum < target){
                left++;
            }
            else{
                right--;
            }
        }
        return new int[]{0,0};
    }
}
