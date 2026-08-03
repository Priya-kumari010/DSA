class Solution {
    public void duplicateZeros(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            if (arr[i] == 0) {

                // Shift elements one step to the right
                for (int j = n - 2; j > i; j--) {
                    arr[j + 1] = arr[j];
                }

                // Duplicate the zero
                arr[i + 1] = 0;

                // Skip the duplicated zero
                i++;
            }
        }
    }
}