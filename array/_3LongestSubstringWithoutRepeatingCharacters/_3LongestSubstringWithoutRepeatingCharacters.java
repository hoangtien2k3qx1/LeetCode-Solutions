package array._3LongestSubstringWithoutRepeatingCharacters;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            if (!set.contains(c)) {
                set.add(c);
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }

        System.out.println(set);
        return maxLength;
    }
}

//ab abc e b e
// abcab

public class _3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcab";
        System.out.println(Solution.lengthOfLongestSubstring(s));
    }
}
