// Approach 1 -> Using Stack
// Time Complexity -> O(n)
// Space Complexity -> O(1)

/*class Solution {
    public String clearDigits(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();


        for(char c : s.toCharArray()){
            if(c >= 'a' && c <= 'z'){ // push non-digit character to stack
                st.push(c);
            }else if(!st.isEmpty()){
                st.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}*/



//-----------------------------------------------------------------------------------------------------------------------------//
// Approach 2 -> Brute Force Method
// Time Complexity -> O(n)
// Space Complexity -> O(1)

/*class Solution{
    public String clearDigits(String s){
        int i = 0;
        StringBuilder sb = new StringBuilder(s);

        while(i < sb.length()){
            if(Character.isDigit(sb.charAt(i))){
                sb.deleteCharAt(i); // Remove digit

                if(i > 0){
                    sb.deleteCharAt(i-1); // Remove closest left non-digit
                    i--; // Move back to check previous character after deletion
                }
            }else{
                i++; // Move forward only if no deletion occurs
            }
        }
        return sb.toString();
    }
}*/


//--------------------------------------------------------------------------------------------------------------------//
// Approach 3 -> Use StringBuilder
// Time Complexity -> O(n)
// Sapce Complexity -> O(1)
class Solution{
    public String clearDigits(String s){
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){
            if(c >= 'a' && c <= 'z'){
                sb.append(c);
            }
            else if(sb.length() > 0){
                sb.deleteCharAt(sb.length()-1); // delete the previous non-digit character
            }
        }
        return sb.toString();
    }
}