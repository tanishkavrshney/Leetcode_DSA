class Solution {
    public int maxArea(int[] arr) {
        int i=0;
        int j=arr.length-1;
        int maxAr=0;
        while(i<=j){
            int area=(Math.min(arr[i],arr[j])) * (j-i);
            maxAr=Math.max(maxAr,area);
            if(arr[i]<arr[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return maxAr;
    }
}