class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> counter = new HashMap<>();
        for(char c: tasks){
            counter.put(c,counter.getOrDefault(c,0)+1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);

        maxHeap.addAll(counter.values());

        int time =0;
        Queue<int[]> cooldown = new LinkedList<>();

        while(!maxHeap.isEmpty() || !cooldown.isEmpty()){
            time++;

            if(!maxHeap.isEmpty()){

                int count = maxHeap.poll() -1;

                if(count>0){
                    cooldown.offer(new int[]{count, time + n});
                }
            }


            if(!cooldown.isEmpty() && cooldown.peek()[1] == time){
                maxHeap.offer(cooldown.poll()[0]);
            }
        }

        return time;
    }
}
