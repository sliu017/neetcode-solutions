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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0); // dummy
        ans.next = new ListNode(0);
        ListNode head = ans;
        int carry = 0;
        while(l1 != null || l2 != null){
            ans = ans.next;
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            if(carry == 1){
                sum++;
            }
            carry = sum >= 10 ? 1 : 0;
            ans.val = sum % 10;
            ans.next = new ListNode(0);
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(carry == 1){
            ans.next = new ListNode(1);
            ans.next.next = null;
        } else {
            ans.next = null;
        }
        return head.next;
        // handle unequal l1/l2 lengths
    }
}
