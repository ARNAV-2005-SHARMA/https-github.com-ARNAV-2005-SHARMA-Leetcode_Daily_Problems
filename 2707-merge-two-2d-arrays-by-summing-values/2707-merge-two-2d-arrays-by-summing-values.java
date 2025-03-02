// Approach 1 -> Using Hashmap and sorting
// Time Complexity -> O(m + n + N log N) , N = m+n
// Space Complexity -> O(m+n)
/*class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> list = new ArrayList<>();

        for(int i=0;i<m;i++){
            int id = nums1[i][0];
            int val = nums1[i][1];

            map.put(id, map.getOrDefault(id, 0) + val);
        }

        for(int i=0;i<n;i++){
            int id = nums2[i][0];
            int val = nums2[i][1];

            if(map.containsKey(id)){
                map.put(id, map.get(id) + val);
            }else{
                map.put(id, val);
            }
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            list.add(new int[]{entry.getKey(), entry.getValue()});
        }

        Collections.sort(list, (a, b) -> Integer.compare(a[0], b[0]));

        return list.toArray(new int[0][]);
    }
}*/



//--------------------------------------------------------------------------------------------------------------------//
// Approach 2 -> Two Pointer Approach
// Time Complexity -> O(m+n)
// Space Complexity -> O(m+n)
class Solution{
    public int[][] mergeArrays(int[][] nums1, int[][] nums2){
        int m = nums1.length;
        int n = nums2.length;

        int i=0;
        int j=0;
        List<int[]> list = new ArrayList<>();

        while(i<m && j<n){
            if(nums1[i][0] < nums2[j][0]){
                list.add(nums1[i]);
                i++;
            }
            else if(nums1[i][0] > nums2[j][0]){
                list.add(nums2[j]);
                j++;
            }
            else{ // if id exist in both array(1==1)
                list.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            }
        }

        while(i<m){
            list.add(nums1[i]);
            i++;
        }
        while(j<n){
            list.add(nums2[j]);
            j++;
        }

        return list.toArray(new int[0][]);
    }
}