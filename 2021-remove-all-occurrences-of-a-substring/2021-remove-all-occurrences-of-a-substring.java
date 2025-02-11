// Approach 1 -> Brute Method (find and remove)
// Time Complexity -> O(n)
// Space Complexity -> O(1)

/*class Solution{
    public String removeOccurrences(String s, String part){
        while(s.contains(part)){ // Check if 'part' exists in 's'
            s = s.replaceFirst(part, ""); // Remove the first occurrence of 'part'
        }
        return s;
        
    }
}*/

//-----------------------------------------------------------------------------------------------------------------------//
// Approach 2 -> Using StringBuilder
// Time Complexity -> O(n)
// Space Complexity -> O(1)

/*class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder();
        int n = part.length();

        for(char c : s.toCharArray()){
            sb.append(c); // Append the character to StringBuilder

            // Check if the last 'n' characters match 'part'
            if(sb.length()>=n && sb.substring(sb.length() - n).equals(part)){
                sb.delete(sb.length() - n, sb.length()); // Remove last occurrence of 'part'
            }
        }
        return sb.toString();
    }
}*/

//-------------------------------------------------------------------------------------------------------------//
// Approach 3 -> Brute Force 
// Time Complexity -> O(n)
// Space Complexity -> O(1)

class Solution{
    public String removeOccurrences(String s, String part){

        while(true){
            int index = s.indexOf(part);

            if(index==-1){
                break;
            }

            s = s.substring(0, index) + s.substring(index + part.length());
        }
        return s;
    }
}