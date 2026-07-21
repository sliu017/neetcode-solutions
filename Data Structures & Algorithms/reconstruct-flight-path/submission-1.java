class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> queues = new HashMap<>();

        for (List<String> tic : tickets) {
            String from = tic.get(0);
            String to = tic.get(1);

            if (!queues.containsKey(from)) {
                queues.put(from, new PriorityQueue<>());
            }

            queues.get(from).add(to);
        }

        LinkedList<String> ans = new LinkedList<>();
        Deque<String> stack = new ArrayDeque<>();

        stack.push("JFK");

        while (!stack.isEmpty()) {
            String cur = stack.peek();
            if (queues.containsKey(cur) && !queues.get(cur).isEmpty()) {
                String next = queues.get(cur).poll();
                stack.push(next);
            } else {
                ans.addFirst(stack.pop());
            }
        }

        return ans;
    }
}