class Solution {
    public boolean isValid(String word) {
        if (word.length() < 3) return false;

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                if (Character.isLetter(c)) {
                    char lower = Character.toLowerCase(c);
                    if ("aeiou".indexOf(lower) != -1) {
                        vowels++;
                    } else {
                        consonants++;
                    }
                }
            } else {
                return false;
            }
        }

        return vowels > 0 && consonants > 0;
    }
}
