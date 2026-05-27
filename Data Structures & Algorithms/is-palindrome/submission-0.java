class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder newStr = new StringBuilder();
        for(char i: s.toCharArray()){
            if(Character.isLetterOrDigit(i)){
                newStr.append(Character.toLowerCase(i));
            }
        }
        return newStr.toString().equals(newStr.reverse().toString());
    }
}
