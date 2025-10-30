class Solution {
    public String getHint(String secret, String guess) {
        int bulls=0;
        int cows=0;
        List<Character> list = new ArrayList<>();
        for(int i=0;i<secret.length();i++){
            list.add(secret.charAt(i));
        }
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)){
                bulls++;
                list.set(i, '#');
            }
        }
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) != guess.charAt(i)) {
                if (list.contains(guess.charAt(i))) {
                    cows++;
                    list.remove(list.indexOf(guess.charAt(i)));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(bulls);
        sb.append("A");
        sb.append(cows);
        sb.append("B");

        return sb.toString();
    }
}