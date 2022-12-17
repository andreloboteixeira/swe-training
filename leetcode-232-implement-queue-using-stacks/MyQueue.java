import java.util.*;

public class MyQueue{

    Stack<Integer> out;
    Stack<Integer> in;

    MyQueue(){
        this.in = new Stack<>();
        this.out = new Stack<>();
    }

    public void push(int x){
        this.in.push(x);
    }

    public int peek(){
        if(this.out.empty()){
            while(!this.in.empty()){
                this.out.push(this.in.pop());
            }
        }
        return this.out.peek();
    }

    public int pop(){
        if(this.out.empty()){
            while(!this.in.empty()){
                this.out.push(this.in.pop());
            }
        }
        return this.out.pop();
    }

    public boolean empty(){
        return this.in.empty() && this.out.empty();
    }

}
