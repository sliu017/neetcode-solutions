class MinStack {
    Stack<Integer> s;
    Stack<Integer> m;
    public MinStack() {
        s = new Stack<Integer>();
        m = new Stack<Integer>();
    }
    
    public void push(int val) {
        s.push(val);
        if(m.isEmpty() || val <= m.peek()){
            m.push(val);
        }
    }
    
    public void pop() {
        int v = s.pop();
        if(m.peek() == v){
            m.pop();
        }
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return m.peek();
    }
}
