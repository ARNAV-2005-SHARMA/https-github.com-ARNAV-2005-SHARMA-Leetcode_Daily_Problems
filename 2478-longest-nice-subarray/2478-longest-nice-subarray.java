// Approach 1 -> Brute Force with bit manipulation
// Time Complexity -> O(n^2)
// Space Complexity -> O(1)
/*class Solution {
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
}*/



//------------------------------------------------------------------------------------------------------------------------//
// Approach 2 -> Sliding Window Approach 
// Time Complexity -> O(n)
// Space Complexity -> O(1)
class Solution{
    public int longestNiceSubarray(int[] nums){
        int n = nums.length;
        int i = 0;
        int j = 0;

        int res = 1;
        int mask = 0;

        while(j < n){
            // Shrink the window if there is an overlap
            while((nums[j] & mask)!=0){
                mask = mask ^ nums[i]; // Remove the effect of nums[i]
                i++;
            }

            res = Math.max(res, j-i+1); // store the max length
            mask = mask | nums[j]; // Add nums[j] to the mask
            j++; // increment pointer 
        }
        return res;
    }
}