package coding.problems.java;

import java.util.Stack;

// t: all operations are O(1), s: O(1)

class Node{
    int val;
    int min;

    public Node(int val, int min){
        this.val = val;
        this.min = min;
    }
}

public class MinStack{

    Stack<Node> stack;

    public MinStack(){
        this.stack = new Stack<Node>();
    }

    public void push(int val){
        if(stack.isEmpty()){
            stack.push(new Node(val, val));
        } else {
            stack.push(new Node(val, Integer.min(val, stack.peek().min)));
        }
    }

    public void pop() {
        if(stack.isEmpty()) System.out.println("trying to pop, stack empty");

        this.stack.pop();
    }

    public int top() {
        if(stack.isEmpty()) System.out.println("trying to get top, stack empty");

        return this.stack.peek().val;
    }

    public int getMin() {
        if(stack.isEmpty()) System.out.println("trying to get min value, stack empty");
        return this.stack.peek().min;
    }

}