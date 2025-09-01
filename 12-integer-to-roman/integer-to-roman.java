class Solution {
    public String intToRoman(int num) {
        int[]a1 = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[]a2 = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int i=0;
        StringBuilder ans = new StringBuilder();
        while(num!=0){
            if(num>=a1[i]){
                ans.append(a2[i]);
                num-=a1[i];
            }else{
                i++;
            }
        }
        return ans.toString();
    }
}
