// Approach 1 -> Brute Force Method(tle exist)
// Time Complexity -> O(n log n)
// Space Complexity -> O(1)

/*class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int op = 0;

        while(nums[0] < k){
            int x = nums[0];
            int y = nums[1];

            int newval = x * 2 + y;
            nums[0] = newval; // Replace first element
            nums[1] = Integer.MAX_VALUE; // Mark second element as removed
            op++;
            Arrays.sort(nums);  // Re-sort the array to maintain order
        }
        return op;
    }
}*/




//-------------------------------------------------------------------------------------------------------------------//
// Approach 2 -> Using Min Heap(Priority Queue)
// Time Complexity -> O(n log n)
// Space Complexity -> O(n)

// ---long is used to store the large values after operations in Priority Queue----//
class Solution{
    public int minOperations(int[] nums, int k){
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int op = 0;

        for(int num : nums){
            pq.add((long)num); // convert int to long 
        }

        while(pq.peek()<k){ // loop run until top element smaller than  k
            long x = pq.poll();
            long y = pq.poll();

            long newVal = x*2+y;
            pq.add(newVal);
            op++;
        }

        return op;
    }
}