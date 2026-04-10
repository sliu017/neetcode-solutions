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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int sz = 1;
        ListNode cur = head;
        while(cur.next != null){
            cur = cur.next;
            sz++;
        }
        if(sz == 1){
            return null;
        }
        if(n == sz){
            return head.next;
        }
        int iter = 1;
    
        cur = head;
        ListNode prev = null;
        while(iter < sz-n){ //need +1 ?
            prev = cur;
            cur = cur.next;
            iter++;
        }
        // breaks when cur is the node before the skipped one
        if(cur.next == null){
            return head;
        } else if(cur.next.next == null){
            cur.next = null;
        } else {
            cur.next = cur.next.next;
            // cur = cur.next;
            // prev.next = cur;
        }
        return head;

        
    }
}
