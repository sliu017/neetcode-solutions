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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(int i = 0; i < lists.length; i++){
            pq.add(lists[i]);
        }
        if(pq.isEmpty()){
            return null;
        }

        ListNode root = new ListNode();
        ListNode cur = root;

        while(!pq.isEmpty()){
            ListNode top = pq.poll();
            cur.next = top;
            cur = cur.next;

            top = top.next;
            if(top != null){
                pq.add(top);
            }

        }
        return root.next;
        
    }

}
