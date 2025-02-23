// Approach 1 -> Brute Force Method(tle exist)
// Time Complexity ->  O(n * m log m) + O(n log n) = O(n * m log m)
// Space Complexity -> O(n)
class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<grid.length;i++){
            Arrays.sort(grid[i]);
            for(int j=grid[i].length-1;j>=Math.max(0, grid[i].length - limits[i]);j--){
                list.add(grid[i][j]);
            }
        }

        list.sort(Collections.reverseOrder());

        long sum = 0;
        for(int i=0;i<Math.min(k, list.size());i++){
            sum += list.get(i);
        }
        return sum;
    }
}

// Approach 2 -> Use Max Heap(Priority Queue)
// Time Complexity -> O(n * m log (n * m)) = O(n * m log m)
// Space Complexity -> O(n)
/*class Solution{
    public long maxSum(int[][] grid, int[] limits, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<grid.length;i++){
            Arrays.sort(grid[i]); // sort every row 

            for(int j=grid[i].length-1;j>=Math.max(0, grid[i].length - limits[i]);j--){
                pq.add(grid[i][j]);
            }
        }

        long sum = 0;
        while(!pq.isEmpty() && k>0){
            sum += pq.poll();
            k--;
        }
        return sum;
    }
}*/