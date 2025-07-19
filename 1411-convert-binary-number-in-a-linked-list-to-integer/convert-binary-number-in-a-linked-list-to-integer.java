/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        ListNode temp = head;
        int[] binary = new int[32]; 
        int length = 0;

        while (temp != null) {
            binary[length++] = temp.val;
            temp = temp.next;
        }
        int ans = 0;
        for (int i = 0; i < length; i++) {
            ans += binary[length - 1 - i] * Math.pow(2, i);
        }

        return ans;

    }
}