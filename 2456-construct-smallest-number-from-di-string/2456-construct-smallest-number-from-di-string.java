// Approach 1 -> Using Stack
// Time Complexity -> O(n)
// Space Commplexity -> O(n)
class Solution {
    public String smallestNumber(String pattern) {
        int counter = 1;
        int n = pattern.length();
        StringBuilder curr = new StringBuilder();
        Stack<Character> st = new Stack();
        
        for(int i=0;i<=n;i++){
            st.push((char)(counter + '0')); // int to char
            counter++; // always increase the counter

            if(i==n || pattern.charAt(i)=='I'){ // if 'i' pointer reach the end of the string
                while(!st.isEmpty()){
                    curr.append(st.pop());
                }
            }
        }
        return curr.toString();
    }
}