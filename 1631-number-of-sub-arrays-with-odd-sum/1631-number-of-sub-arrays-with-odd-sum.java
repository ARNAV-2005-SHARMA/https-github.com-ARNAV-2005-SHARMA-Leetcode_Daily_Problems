// Approach 1 -> Brute Force Method
// Time Complexity -> O(n^2)
// Space Complexity -> O(1)
/*class Solution {
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int count = 0;
        int mod = (int) (1e+7);

        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum += arr[j];

                if(sum%2!=0){
                    count++;
                }
            }
        }
        return count;
    }
}*/

// Approach 2 -> Using Prefix-sum Array
// Time Complexity -> O(n)
// Space Complexity -> O(n)
class Solution{
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int p[] = new int[n];
        int mod = 1000000007;

        p[0] = arr[0];
        for(int i=1;i<n;i++){
            p[i] = p[i-1] + arr[i];
        }

        int count = 0;
        int evenC = 1; // evenC is 1 (In starting prefix sum  is 0 and 0 is Even number then even count is 1)
        int oddC = 0; // oddC store the odd sum count in prefix array

        for(int i=0;i<n;i++){
            if(p[i]%2==0){ // odd + even = odd
                count = (count+oddC) % mod;
                evenC++;
            }else{ // even + odd = odd
                count = (count+evenC) % mod;
                oddC++;
            }
        }
        return count;
    }
}