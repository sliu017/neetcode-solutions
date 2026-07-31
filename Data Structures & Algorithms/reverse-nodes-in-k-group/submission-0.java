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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curHead = head;
        ListNode prevOriginalHead = null;
        boolean first = true;
        while(curHead != null){
            ListNode scout = curHead;
            int pastHead = 0;
            while(scout != null && pastHead <= k-1 ){
                scout = scout.next;
                pastHead++;
            }
            if(pastHead < k){
                break;
            }

            ListNode node = curHead;
            pastHead = 0;
            ListNode prev = null;
            while(pastHead < k){
                if(pastHead == k-1){
                    curHead.next = node.next;
                }
                ListNode nxt = node.next;
                node.next = prev;
                prev = node;
                node = nxt;
                pastHead++;
            }
            if(first){
                head = prev;
                first = false;
            }
            // at this point, node is 4
            if(prevOriginalHead == null){
                // set prevOG to 1
                prevOriginalHead = curHead;
            } else {
                prevOriginalHead.next = prev;
                prevOriginalHead = curHead;
            }
            // set current head to 4
            curHead = node;
        }
        return head;
    }
}
