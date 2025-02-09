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


class Solution{
    public long countBadPairs(int[] nums){
        int n = nums.length;
        long res = 0;

        for(int i=0;i<n;i++){
            nums[i] = nums[i] - i;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 1);

        for(int i=1;i<n;i++){
            int countOfJ = map.getOrDefault(nums[i], 0);
            int totalPairs = i;
            res += totalPairs - countOfJ;

            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return res;
    }
}