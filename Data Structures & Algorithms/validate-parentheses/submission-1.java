class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        Map<Character, Character> mapper = new HashMap<>();
        mapper.put(')', '(');
        mapper.put('}', '{');
        mapper.put(']', '[');

        for(char c: s.toCharArray()){
            if(mapper.containsKey(c)){
                if(!stack.isEmpty() && stack.peek() == mapper.get(c)){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
            else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
