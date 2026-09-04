class Solution {
    public String reverseWords(String s) {
        Stack<String> st =  new Stack<>();

        String[] words = s.trim().split("\\s+");

        for(String word : words){
            st.push(word);
        }

        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()){
            sb.append(st.pop());
            if (!st.isEmpty()) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}