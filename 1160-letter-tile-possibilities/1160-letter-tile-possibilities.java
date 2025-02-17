// Approach 1 -> Using Recursion and Backtracking
// Time Complexity -> O(n!)
// Space Complexity -> O(n)

/*class Solution {
    public void solve(String tiles, boolean vis[], Set<String> set, StringBuilder curr){
        set.add(curr.toString()); // Add the current valid sequence
        for(int i=0;i<tiles.length();i++){
            if(vis[i]==true){
                continue;
            }
            // try
            vis[i] = true;
            curr.append(tiles.charAt(i));

            // explore
            solve(tiles, vis, set, curr); // recursive

            // backtrack
            vis[i] = false;
            curr.deleteCharAt(curr.length()-1); // remove the last char
        }
    }
    public int numTilePossibilities(String tiles) {
        int n = tiles.length();

        StringBuilder curr = new StringBuilder();
        boolean vis[] = new boolean[n];
        Set<String> set = new HashSet<>();

        solve(tiles, vis, set, curr);
        return set.size()-1; // Subtract 1 to exclude the empty sequence
    }
}*/


//--------------------------------------------------------------------------------------------------------------------------------//
// Approach 2 -> Using Count of Character + Backtracking
// Time Complexity -> O(n!)
// Space Complexity -> O(n)
class Solution{
    private int total; // Use a class-level variable to keep track of count
    public void solve(int arr[]){
        total++; // Increase count for a valid sequence

        for(int i=0;i<26;i++){
            if(arr[i]==0){
                continue;
            }
            arr[i]--; // Choose letter
            solve(arr); // Recursive call
            arr[i]++; // Backtrack
        }
    }
    public int numTilePossibilities(String tiles){
        int arr[] = new int[26]; // Frequency array
        total = 0;

        for(char c : tiles.toCharArray()){
            arr[c - 'A']++; // Count occurrences of each letter
        }
        solve(arr);
        return total - 1; // Subtract 1 to exclude the empty sequence
    }
}