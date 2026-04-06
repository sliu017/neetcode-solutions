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
    public ListNode reverseList(ListNode head) {
        ArrayList<ListNode> lst = new ArrayList<ListNode>();
        if(head == null){
            return null;
        }
        ListNode cur = head;
        ListNode prev = null;
        while(true){
            lst.add(cur);
            if(cur.next == null){
                break;
            } else {
                cur = cur.next;
            }
        }
        Collections.reverse(lst);
        for(int i = 0; i < lst.size()-1; i++){
            lst.get(i).next = lst.get(i+1);
        }
        lst.get(lst.size()-1).next = null;
        return lst.get(0);
    }
}
