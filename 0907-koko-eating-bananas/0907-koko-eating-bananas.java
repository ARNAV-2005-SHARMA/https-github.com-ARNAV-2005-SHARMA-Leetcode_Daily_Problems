// Approach -> Binary Search
// Time Complexity -> O(n log (max(piles)))
// Space Complexity -> O(1)
class Solution {
    public boolean canEat(int[] piles, int mid, int h){
        int hours = 0;

        for(int p : piles){
            hours += p/mid; // hours to eat bananas

            if(p%mid!=0){ // if remainder exist 
                hours++;
            }
        }
        if(hours<=h){
            return true;
        }
        return false;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int l = 1;

        int r = Integer.MIN_VALUE;
        for(int p : piles){
            r = Math.max(r, p); // r = max value in the array
        }

        while(l < r){
            int mid = l + (r - l)/2; // mid = Per hour I can eat mid nnumber of bananas

            if(canEat(piles, mid, h)){
                r = mid; // ignore the 2nd half (reduce the right)
            }else{
                l = mid+1;
            }
        }
        return l;
    }
}