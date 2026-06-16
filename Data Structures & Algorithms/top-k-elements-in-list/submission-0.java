class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for(int num : nums){
            counter.put(num, counter.getOrDefault(num,0) + 1);
        }

        PriorityQueue<Integer> p = new PriorityQueue<>((a,b) -> counter.get(a) - counter.get(b));

        for(int num : counter.keySet()){
            p.offer(num);
            if(p.size() > k){
                p.poll();
            }
        }

        int[] result = new int[k];

        for(int i=0;i<k;i++){
            result[i] = p.poll();
        }

        return result;
    }
}
