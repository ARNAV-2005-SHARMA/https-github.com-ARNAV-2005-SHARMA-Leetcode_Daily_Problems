class Solution {
    public int reverse(int x) {
        int n1 = -2147483648;
        int n2 = 2147483647;
        
        long rev = 0, rem;
        while(x!=0){
            rem = x % 10;
            rev = rev * 10 + rem;
            x = x / 10;
        }
        if(rev <n1 || rev>n2){
            return 0;
        }
        return (int)rev;//convert the long datatype to int datatype
    }
}