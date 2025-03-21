// Approach 1 -> Using Frequency Array
// Time Complexity -> O(n+m), n = length of magazine String, m = length of ransomNote String
// Space Complexity -> O(1)
/*class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int m[] = new int[26]; // Array to store magazine letter counts

        // Count the occurrences of each letter in magazine
        for(char c : magazine.toCharArray()){
            m[c - 'a']++;
        }

        // Check if ransomNote can be constructed
        for(char c : ransomNote.toCharArray()){
            if(m[c-'a']==0){  // If the letter is missing
                return false;
            }

            m[c-'a']--; // Use one letter
        }
        return true;
    }
}*/



//------------------------------------------------------------------------------------------------------------------------------------//

// Approach 2 -> Using HashMap
// Time Complexity -> O(n+m)
// Space Complexity -> O(26) = O(1), (since the alphabet size is fixed to 26)
class Solution{
    public boolean canConstruct(String ransomNote, String magazine){
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : magazine.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(char c : ransomNote.toCharArray()){
            if(!map.containsKey(c) || map.get(c)<=0){
                return false;
            }
            map.put(c, map.get(c)-1);
        }
        return true;
    }
}