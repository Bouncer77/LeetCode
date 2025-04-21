package pro.kosenkov.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 13. Roman to Integer
 * Easy
 * Topics
 * Companies
 * Hint
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 * Example 2:
 * <p>
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 3:
 * <p>
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 15
 * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */

public class Task_13_RomanToInteger {

    public static void main(String[] args) {
        // System.out.println(romanToInt("MDCXCV"));
        System.out.println(romanToInt("D"));
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> romanLetterMap = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );

        for (Map.Entry entry : romanLetterMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println(s);

        // Переводим в арабский цифры
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);

            // Ноль как число не входит во множество чисел, записываемых римскими цифрами.
            if (!romanLetterMap.containsKey(curChar)) {
                return 0;
            }

            arr[i] = romanLetterMap.get(curChar);
        }

        System.out.println(Arrays.toString(arr));


        // Вычитания
        if (arr.length == 1) {
            return arr[0];
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i] < arr[i + 1]) {
                list.add(arr[i + 1] - arr[i]);
                i++;

                if (i == arr.length - 2) {
                    list.add(arr[i + 1]);
                    break;
                }

                continue;
            }

            list.add(arr[i]);

            if (i == arr.length - 2) {
                list.add(arr[i + 1]);
                break;
            }

        }

        System.out.println(list);

        // Получение результата
        return list.stream().reduce(0, Integer::sum);
    }
}
