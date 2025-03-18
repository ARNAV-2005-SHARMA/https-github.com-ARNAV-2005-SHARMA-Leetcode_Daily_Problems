// Approach 1 -> Brute Force with bit manipulation
// Time Complexity -> O(n^2)
// Space Complexity -> O(1)
class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int res = 0;

        for(int i=0;i<n;i++){
            int mask = 0;
            for(int j=i;j<n;j++){
                if((nums[j] & mask) != 0){ 
                    break; // if And not equal to zero then break the subarray
                }
                mask = mask | nums[j]; 
                res = Math.max(res, j-i+1);
            }
        }
        return res;
    }
}