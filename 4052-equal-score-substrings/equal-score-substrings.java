class Solution {
    public boolean scoreBalance(String s) {
        for(int i=0;i<s.length();i++){
            if(check(i,s)){
                return true;
            }
        }
        return false;
    }
    public boolean check(int n,String s){
        int add1=0;
        int add2=0;
        for(int i=0;i<=n;i++){
            add1+=(s.charAt(i)-'a')+1;
        }
        for(int i=n+1;i<s.length();i++){
            add2+=(s.charAt(i)-'a')+1;
        }
        return add1==add2;
    }
}