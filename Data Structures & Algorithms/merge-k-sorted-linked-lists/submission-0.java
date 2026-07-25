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
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> a[0] - b[0]); // value, index    
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null){
                pq.add(new int[]{lists[i].val, i});
            }
        }
        if(pq.isEmpty()){
            return null;
        }
        
        ListNode root = new ListNode();
        ListNode cur = root;

        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int ind = top[1];
            cur.val = top[0];
            if(lists[ind].next != null){
                lists[ind] = lists[ind].next;
                pq.add(new int[]{lists[ind].val, ind});
            }
            if(!pq.isEmpty()){
                cur.next = new ListNode();
                cur = cur.next;
            }
        }
        return root;
        
    }

}
