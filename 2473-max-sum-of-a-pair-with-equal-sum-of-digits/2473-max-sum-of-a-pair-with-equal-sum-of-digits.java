// Approach 1 -> Brute Force Method
// Time Complexity -> O(n^2)
// Space Complexity -> O(1)
/*class Solution {
    // Calculate Digit Sum of num
    public int isDigit(int n){
        int sum = 0;
        while(n > 0){
            sum += n % 10; // Extract last digit
            n = n/10; // Remove last digit
        }
        return sum;
    }
    public int maximumSum(int[] nums) {
        int n = nums.length;
        int maxSum = -1;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isDigit(nums[i])==isDigit(nums[j])){
                    int sum = nums[i] + nums[j];
                    maxSum = Math.max(maxSum, sum);
                }
            }
        }
        return maxSum;
    }
}*/


//------------------------------------------------------------------------------------------------------------------//
// Approach 2 -> Using Map
// Time Complexity -> O(n*k), k = number of digits in num
// Space Complexity -> O(n)
class Solution{
    public int digitSum(int n){
        int sum = 0;
        while(n > 0){
            sum += n%10;
            n = n/10;
        }
        return sum;
    }
    public int maximumSum(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        int maxSum = -1;

        for(int num : nums){
            int digisum = digitSum(num);

            // If a number with this digit sum exists, compute pair sum
            if(map.containsKey(digisum)){
                maxSum = Math.max(maxSum, map.get(digisum) + num);
            }

            // Update the map with the larger number for this digit sum
            if(map.containsKey(digisum)){
                map.put(digisum, Math.max(map.get(digisum), num));
            }else{
                map.put(digisum, num);
            }
        }
        return maxSum;
    }
}