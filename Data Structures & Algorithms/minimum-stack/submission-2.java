class MinStack {
    private Stack<Long> stack;
    long min;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(0L);
            min = val;
        }
        else{
            stack.push(val - min);
            if(val < min){
                min = val;
            }
        }
    }
    
    public void pop() {
        if(stack.isEmpty()) return;

        long value = stack.pop();
        if(value < 0){
            min = min - value;
        }
    }
    
    public int top() {
        long topVal = stack.peek();

        if(topVal > 0){
            return (int) (topVal + min);
        }
        else{
            return (int) min;
        }
    }
    
    public int getMin() {
        return (int) min;
    }
}
