class Solution {
    public char kthCharacter(int k) {
        String prev = "a";
        StringBuilder sb=new StringBuilder();
        while(sb.length()<k){
            //firt make sb empty
            sb.setLength(0);
            //then append everything that was in diff string
            sb.append(prev);
            //then do next next of every char in sb and append to sb
            for(char c : prev.toCharArray()){
                if(c=='z') sb.append('a');
                else sb.append((char)(c+1));
            }
            //store sb in diff string
            prev=sb.toString();
        }
        return sb.charAt(k-1);
    }
}