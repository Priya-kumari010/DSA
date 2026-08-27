class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();
        int[] count = new int[26];

        // Count characters of s
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Match target from left to right
        int matched = 0;

        while (matched < n) {
            int x = target.charAt(matched) - 'a';

            if (count[x] == 0) {
                break;
            }

            count[x]--;
            matched++;
        }

        // Try to make the answer greater
        int start = (matched == n) ? n - 1 : matched;

        for (int i = start; i >= 0; i--) {

            // Restore character at current position
            if (i < matched) {
                count[target.charAt(i) - 'a']++;
            }

            int curr = target.charAt(i) - 'a';

            // Find smallest character greater than target[i]
            for (int j = curr + 1; j < 26; j++) {

                if (count[j] > 0) {

                    StringBuilder ans =
                        new StringBuilder(target.substring(0, i));

                    ans.append((char) ('a' + j));
                    count[j]--;

                    // Add remaining characters in sorted order
                    for (int k = 0; k < 26; k++) {
                        while (count[k] > 0) {
                            ans.append((char) ('a' + k));
                            count[k]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }
}