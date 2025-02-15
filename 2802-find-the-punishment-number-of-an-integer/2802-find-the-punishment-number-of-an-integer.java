// Approach 1-> Recursion
// Time Complexity -> O(n * 2^(log10(n^2)))
// Space Complexity -> O(log10(n^2))
/*class Solution {
    public boolean check(int square, int curr, int target){
        if(square==0){
            if(curr==target){
                return true;
            }else{
                return false;
            }
        }
        // recursive call 
        // If n=1000, then use recursive call of 10^4 (only one test case)
        return check(square/10, curr+square%10, target) || check(square/100, curr+square%100, target) || check(square/1000, curr+square%1000, target) || check(square/10000, curr+square%10000, target);
    }
    public int punishmentNumber(int n) {
        int punish = 0;

        for(int num=1;num<=n;num++){
            int sq = num * num;

            if(check(sq, 0, num)==true){
                punish += sq;
            }
        }
        return punish;
    }
}*/

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
// Approach 2 -> Using Recursion
// // Time Complexity -> O(n * 2^(log10(n^2)))
// Space Complexity -> O(n * log10(n^2))
class Solution{
    public boolean check(int i, int curr, String s, int num){
        if(i==s.length()){
            return curr==num; // return true if equal
        }
        if(curr>num){
            return false;
        }
        boolean possible = false;
        for(int j=i;j<s.length();j++){
            String sub = s.substring(i, j+1);
            int add = Integer.parseInt(sub);

            if(curr > num){ // Early exit to avoid unnecessary recursion
                break;
            }
            possible = possible || check(j+1, curr+add, s, num);

            if(possible==true){
                return true;
            }
        }
        return possible;
    }
    public int punishmentNumber(int n){
        int punish = 0;

        for(int num=1;num<=n;num++){
            int sq = num*num;
            String s = Integer.toString(sq);

            if(check(0, 0, s, num)==true){
                punish += sq;
            }
        }
        return punish;
    }
}