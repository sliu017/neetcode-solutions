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
    public void reorderList(ListNode head) {
        ListNode tail = head;
        ListNode prevTail = null;
        int sz = 0;
        while(tail != null){
            prevTail = tail;
            tail = tail.next;
            sz++;
        }
        ListNode mid = head;
        ListNode prevMid = null;
        int iter = 0;
        while(iter < (sz+1)/2){
            prevMid = mid;
            mid = mid.next;
            iter++;
        }
        prevMid.next = null;
        ListNode reversed = reverse(mid);

        ListNode l1 = head;
        ListNode l2 = reversed;
        while(l1 != null && l2 != null){
            ListNode temp = l1.next;
            ListNode temp2 = l2.next;
            l1.next = l2;
            l2.next = temp;
            l1 = temp;
            l2 = temp2;
        }
        
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
