class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        
        for (int resultIdx = n - 1; resultIdx >= 0; resultIdx--) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            
            if (leftSquare > rightSquare) {
                result[resultIdx] = leftSquare;
                left++;
            } else {
                result[resultIdx] = rightSquare;
                right--;
            }
        }
        
        return result;
    }
}