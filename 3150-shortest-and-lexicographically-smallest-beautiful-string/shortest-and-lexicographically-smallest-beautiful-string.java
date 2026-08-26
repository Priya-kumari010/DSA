class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int left = 0, ones = 0;
        String ans = "";

        for (int right = 0; right < s.length(); right++) {

            if (s.charAt(right) == '1')
                ones++;

            while (ones == k) {

                // remove leading zeros
                while (s.charAt(left) == '0')
                    left++;

                String curr = s.substring(left, right + 1);

                if (ans.isEmpty()
                        || curr.length() < ans.length()
                        || (curr.length() == ans.length()
                            && curr.compareTo(ans) < 0)) {
                    ans = curr;
                }

                // remove first 1
                ones--;
                left++;
            }
        }

        return ans;
    }
}