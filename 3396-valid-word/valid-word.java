class Solution {
    public boolean isValid(String word) {
       
        if(word.length()<3)
        return false;
        if (!word.matches("[A-Za-z0-9]+")) {
            return false;
        }

        boolean hasVowel = false;
        boolean hasConsonant = false;

        for (char ch : word.toCharArray()) {
            if (Character.isLetter(ch)) {
                char lowerCh = Character.toLowerCase(ch);
                if ("aeiou".indexOf(lowerCh) != -1) {
                    hasVowel = true;
                } else {
                    hasConsonant = true;
                }
            }
        }

        return hasVowel && hasConsonant;
    }

}