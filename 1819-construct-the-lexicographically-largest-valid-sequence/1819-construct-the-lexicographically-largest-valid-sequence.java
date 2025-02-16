// Approach 1 -> Using Backtracking template
// Time Complexity -> O(n!)
// Space Complexity -> O(n)
class Solution {
    // Recursive Function
    public boolean solve(int i, int n, int[] res, boolean vis[]){
        // Base case: If we have filled all positions, return true
        if(i>=res.length){ 
            return true;
        }
        // Skip already filled positions to reduce unnecessary recursion
        if(res[i]!=-1){
            return solve(i+1, n, res, vis);
        }
        // Try placing the largest possible number first
        for(int num=n;num>=1;num--){
            if(vis[num]==true){
                continue; // Skip if the number is already used
            }
            // 1).try
            vis[num] = true;
            res[i] = num;

            // 2).explore
            // Special case: '1' only occupies one position
            if(num==1){
                if(solve(i+1, n, res, vis)==true){
                    return true;
                }
            }else{
                // Second occurrence of 'num' at index (i + num)
                int j = num + i;
                // Check if the second position is available
                if(j<res.length && res[j]==-1){
                    res[j] = num; // Place 'num' at both positions

                    if(solve(i+1, n, res, vis)==true){
                        return true;  // If we found a solution, stop searching
                    }
                    res[j] = -1; // Undo placement (Backtracking)
                }
            }
            // 3).undo
            // Undo the placement and mark 'num' as unused(unvisited)
            vis[num] = false;
            res[i] = -1;
        }
        return false; // No valid sequence found in this branch
    }
    public int[] constructDistancedSequence(int n) {
        int res[] = new int[2*n-1];
        Arrays.fill(res, -1);

        boolean vis[] = new boolean[n+1]; // To track visited number
        
        solve(0, n, res, vis);
        return res;
    }
}