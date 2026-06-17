class MedianFinder {
    private PriorityQueue<Integer> lower;
    private PriorityQueue<Integer> upper;

    public MedianFinder() {
        lower = new PriorityQueue<>((a,b)-> b-a);
        upper = new PriorityQueue<>((a,b)-> a-b);
    }
    
    public void addNum(int num) {
        lower.offer(num);

        if(!upper.isEmpty() && lower.peek() > upper.peek()){
            upper.offer(lower.poll());
        }

        if(lower.size() > upper.size() + 1){
            upper.offer(lower.poll());
        }
        else if (upper.size() > lower.size()){
            lower.offer(upper.poll());
        }
    }
    
    public double findMedian() {
        if(lower.size() > upper.size()){
            return lower.peek();
        }

        return (lower.peek() + upper.peek()) / 2.0;
    }
}
