// Approach 1 -> Simple sorting on starting point
// Time Complexity -> O(nlogn)
// Space Complexity -> O(1)
class Solution {
    public int countDays(int days, int[][] meetings) {

        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        int res = 0;
        int start = 0;
        int end = 0;

        for(int m[] : meetings){
            if(m[0] > end){
                res += m[0] - end - 1;
            }   
            end = Math.max(end, m[1]);
        }
        if(days > end){
            res += days - end;
        }
        return res;
    }
}