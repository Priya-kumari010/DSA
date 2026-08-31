class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int first = -1;
        int prevCritical = -1;
        int min = Integer.MAX_VALUE;

        ListNode prev = head;
        ListNode curr = head.next;

        int index = 1;
        int last = -1;

        while (curr.next != null) {

            // Check critical point
            if ((curr.val > prev.val && curr.val > curr.next.val) ||
                (curr.val < prev.val && curr.val < curr.next.val)) {

                // First critical point
                if (first == -1) {
                    first = index;
                }

                // Previous critical point exists
                if (prevCritical != -1) {
                    min = Math.min(min, index - prevCritical);
                }

                prevCritical = index;
                last = index;
            }

            prev = curr;
            curr = curr.next;
            index++;
        }

        // Less than 2 critical points
        if (first == -1 || first == last) {
            return new int[]{-1, -1};
        }

        int max = last - first;

        return new int[]{min, max};
    }
}