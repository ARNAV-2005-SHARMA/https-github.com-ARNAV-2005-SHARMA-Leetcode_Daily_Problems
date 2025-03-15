// Approach 1 -> Using Recursion(tle exist)
// Time Complexity -> O(2^n)
// Space Complexity -> O(n)
/*class Solution {
    public int solve(int[] nums, int i, int k){
        if(k==0){
            return 0; // no more houses to be covered
        }
        if(i>=nums.length){ // invalid path
            return Integer.MAX_VALUE;
        }
        int take = Math.max(nums[i], solve(nums, i+2, k-1));
        int notTake = solve(nums, i+1, k);

        return Math.min(take, notTake);
    }
    public int minCapability(int[] nums, int k) {
        return solve(nums, 0, k);
    }
}*/


//-------------------------------------------------------------------------------------------------//
// Approach 2 -> Using Memoization (Top-Down DP)
// Time Complexity -> O(n*k)
// Space Complexity -> O(n*k) + O(n) (Recursion stack)
/*class Solution {
    public int solve(int[] nums, int i, int k, int dp[][]){
        if(k==0){
            return 0; // no more houses to be covered
        }
        if(i>=nums.length){ // invalid path
            return Integer.MAX_VALUE;
        }

        if(dp[i][k]!=-1){
            return dp[i][k];
        }
        int take = Math.max(nums[i], solve(nums, i+2, k-1, dp));
        int notTake = solve(nums, i+1, k, dp);

        return dp[i][k] = Math.min(take, notTake);
    }
    public int minCapability(int[] nums, int k) {
        int dp[][] = new int[nums.length][k+1];

        for(int row[] : dp){
            Arrays.fill(row, -1);
        }
        return solve(nums, 0, k, dp);
    }
}*/



//-----------------------------------------------------------------------------------------------------------------------//
// Approach 3 -> Using Binary Search
// Time Complexity -> O(log(maxC) * n)
// Space Complexity -> O(1)
class Solution{
    public boolean isSolve(int[] nums, int mid, int k){
        int house = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=mid){
                house++;
                i++; // skipping ajdacent house
            }
        } 
        return house >=k; // We managed to rob atleast k houses
    }
    public int minCapability(int[] nums, int k){
        int n = nums.length;
        int small = 0;
        int large = 0;
        for(int i=0;i<n;i++){
            small = Math.min(small, nums[i]);
        }
        for(int i=0;i<n;i++){
            large = Math.max(large, nums[i]);
        }

        int left = small;
        int right = large;
        int res = 0;

        while(left <= right){
            int mid = left + (right - left) / 2; // mid =  capability

            if(isSolve(nums, mid, k)==true){
                res = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return res;
    }
}