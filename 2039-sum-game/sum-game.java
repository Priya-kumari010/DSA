class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int sum = 0;
        int q = 0;

        for (int i = 0; i < n; i++) {

            if (num.charAt(i) == '?') {
                if (i < n / 2)
                    q++;
                else
                    q--;
            } else {
                int digit = num.charAt(i) - '0';

                if (i < n / 2)
                    sum += digit;
                else
                    sum -= digit;
            }
        }

        if (q % 2 != 0)
            return true;

        return sum + (q / 2) * 9 != 0;
    }
}