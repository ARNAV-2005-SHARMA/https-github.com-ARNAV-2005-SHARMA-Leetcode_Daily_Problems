// Approach -> Three-pass approach
// Time Complexxity -> O(n)
// Space Complexity -> O(n)
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] res = new int[n]; //new result array to store the result
        int idx = 0;

        // First Pass: Add elements smaller than pivot
        for(int i=0;i<n;i++){
            if(nums[i] < pivot){
                res[idx++] = nums[i];
            }
        }
        // Second Pass: Add elements equal to pivot
        for(int i=0;i<n;i++){
            if(nums[i] == pivot){
                res[idx++] = nums[i];
            }
        }
        // Third Pass: Add elements greater than pivot
        for(int i=0;i<n;i++){
            if(nums[i] > pivot){
                res[idx] = nums[i];
                idx++;
            }
        }
        return res;
    }
}