// Approach 1 -> Brute Force Method
// Time Complexity -> O(n^2)
// Space Complexity -> O(1)
/*class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long count = 0;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                long id = j - i;
                long sum = nums[j] - nums[i];

                if(id!=sum){
                    count++;
                }
            }
        }
        return count;
    }
}*/

//---------------------------------------------------------------------------------------------------------------------------//
// Approach 2 -> Using HashMap
// Time Complexity -> O(n)
// Space Complexity -> O(n)
class Solution{
    public long countBadPairs(int[] nums){
        int n = nums.length;
        long res = 0;

        // Convert nums[i] to nums[i] - i
        for(int i=0;i<n;i++){
            nums[i] = nums[i] - i;
        }

        Map<Integer, Integer> map = new HashMap<>(); // key -> Number, value -> frequency
        map.put(nums[0], 1); // first number & its frequency in map

        for(int i=1;i<n;i++){
            int countOfJ = map.getOrDefault(nums[i], 0); // Count of previous occurrences of nums[i] (before ith index)
            int totalPairs = i; // total number of previous elements (before ith index (0 to i-1))
            res += totalPairs - countOfJ; // Bad pairs = totalPairs - good pairs

            // Correctly update the frequency map
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return res;
    }
}