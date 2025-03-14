// Approach 1 -> Using Brute Force
// Time Complexity -> O(maxC * n)
// Space Complexity -> O(1)
/*class Solution {
    public int maximumCandies(int[] candies, long k) {
        int n = candies.length;
        int maxC = 0;
        int totalC = 0;

        for(int i=0;i<n;i++){
            totalC += candies[i];
            maxC = Math.max(maxC, candies[i]);
        }

        if(totalC < k){
            return 0;
        }

        for(int i=maxC; i>=1;i--){
            long count = 0;

            for(int j=0;j<n;j++){
                count += candies[j]/i; // how many children can get c candies from this pile
            }
            if(count >= k){
                return i;
            }
        }
        return 0;
    }
}*/


// Approach 2 -> Binary Search
// Time Complexity -> O(n * log(maxC))
// Space COmplexity -> O(1)
class Solution{
    public boolean helper(int[] candies, int mid, long k){
        int n = candies.length;
        long count = 0;

        for(int i=0;i<n;i++){
            count += candies[i] / mid;
            if(count>=k){ // all children got mid candies
                return true; // early return 
            }
        }
        return false;
    }
    public int maximumCandies(int[] candies, long k){
        int n = candies.length;
        long totalC = 0; // Use long to prevent overflow
        int maxC = 0;

        for(int i=0;i<n;i++){
            totalC += candies[i];
            maxC = Math.max(maxC, candies[i]);
        }

        if(totalC < k){
            return 0;
        }

        int l = 1;
        int r = maxC;
        int res = 0;

        while(l<=r){
            int mid = l + (r-l)/ 2;

            if(helper(candies, mid, k)){
                res = mid;
                l = mid + 1; // Valid mid found, try for a larger one
            }else{
                r = mid - 1; // Try smaller value
            }
        }
        return res;
    }
}