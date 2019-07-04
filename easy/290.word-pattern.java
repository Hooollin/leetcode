import java.util.Map;

/*
 * @lc app=leetcode id=290 lang=java
 *
 * [290] Word Pattern
 *
 * https://leetcode.com/problems/word-pattern/description/
 *
 * algorithms
 * Easy (35.06%)
 * Likes:    654
 * Dislikes: 82
 * Total Accepted:    144.6K
 * Total Submissions: 411K
 * Testcase Example:  '"abba"\n"dog cat cat dog"'
 *
 * Given a pattern and a string str, find if str follows the same pattern.
 * 
 * Here follow means a full match, such that there is a bijection between a
 * letter in pattern and a non-empty word in str.
 * 
 * Example 1:
 * 
 * 
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * 
 * Example 2:
 * 
 * 
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 * 
 * Example 3:
 * 
 * 
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 * 
 * Example 4:
 * 
 * 
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 * 
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains
 * lowercase letters that may be separated by a single space.
 * 
 */
class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> chstr = new HashMap<>();
        Map<String, Character> strch = new HashMap<>();
        int patternIdx = 0;
        String[] words = str.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < words.length; i++) {
            if (!strch.containsKey(words[i])) {
                if (chstr.containsKey(pattern.charAt(patternIdx))) {
                    return false;
                }
                strch.put(words[i], pattern.charAt(patternIdx));
                chstr.put(pattern.charAt(patternIdx), words[i]);
            } else {
                if (!chstr.containsKey(pattern.charAt(patternIdx))) {
                    return false;
                }
                if (!chstr.get(pattern.charAt(patternIdx)).equals(words[i])) {
                    return false;
                }
            }
            patternIdx += 1;
        }
        return true;
    }
}
