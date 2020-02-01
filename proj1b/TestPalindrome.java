import org.junit.Test;

import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } //Uncomment this class once you've created your Palindrome class.

    @Test
    public void testisPalindrome() {
        String[] Palindrome = {"racecar", "noon"};
        String[] Unpalindrome = {"horse", "rancor", "aaaaab"};
        for (int i = 0; i < Palindrome.length; i++) {
            assertTrue(palindrome.isPalindrome(Palindrome[i]));
        }
        for (int i = 0; i < Unpalindrome.length; i++) {
            assertFalse(palindrome.isPalindrome(Unpalindrome[i]));
        }

    }
}
