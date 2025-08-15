class Solution {
    public boolean isPowerOfFour(int n) {
        // int curr=1;
        // while(curr<=n){
        //     if(curr==n) return true;
        //     curr*=4;
        // }
        // return false;

        if(n<=0) return false;
        return (n&(n-1))==0 && n%3==1;
    }
}