class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[n];

        for(int i=0; i<n;i++){
            while(!stack.isEmpty() && temperatures[i] > stack.peek()[0]){
                int[] pair = stack.pop();
                res[pair[1]] = i - pair[1];
            }
            stack.push(new int[]{temperatures[i], i});
        }

        return res;
    }
}
