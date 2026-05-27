class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i=0; i< numbers.length;i++){
            int l = i+1, r=numbers.length -1;
            int diff = target - numbers[i];
            while(l<=r){
                int mid = l + (r-l)/2;
                if(numbers[mid] == diff){
                    return new int[]{i+1, mid+1};
                }
                else if(numbers[mid] < diff){
                    l= mid +1;
                }
                else{
                    r=mid-1;
                }
            }
        }
        return new int[]{0,0};
    }
}
