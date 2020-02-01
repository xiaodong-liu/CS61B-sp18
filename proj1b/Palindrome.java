public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> items = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            items.addLast(word.charAt(i));
        }
        return items;
    }

    public boolean isPalindrome(String word) {
        return isPalindrome(word, 0, word.length() - 1);
    }

    private boolean isPalindrome(String word, int first, int last) {
        if (first >= last) {
            return true;
        }
        if (word.charAt(first) == word.charAt(last)) {
            return isPalindrome(word, first + 1, last - 1);
        } else {
            return false;
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        return isPalindrome(word, cc, 0, word.length() - 1);
    }

    private boolean isPalindrome(String word, CharacterComparator cc, int first, int last) {
        if (first >= last) {
            return true;
        }
        if (cc.equalChars(word.charAt(first), word.charAt(last))) {
            return isPalindrome(word, cc, first + 1, last - 1);
        } else {
            return false;
        }
    }
}
