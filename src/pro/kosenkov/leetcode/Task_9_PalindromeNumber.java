package pro.kosenkov.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 9. Palindrome Number
 * Solved
 * Easy
 * Topics
 * Companies
 * Hint
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * Example 2:
 *
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 *
 * Constraints:
 *
 * -231 <= x <= 231 - 1
 *
 *
 * Follow up: Could you solve it without converting the integer to a string?
 * */

public class Task_9_PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        if (x == 0)
            return true;

        List<Integer> a = new ArrayList<>();
        while (x != 0) {
            a.add(x % 10);
            x = x / 10;
        }

        // System.out.println(a.toString());

        for (int i = 0, j = a.size() - 1; i < a.size() / 2; i++, j--) {
            if (!Objects.equals(a.get(i), a.get(j))) {
                return false;
            }
        }

        return true;
    }
}
