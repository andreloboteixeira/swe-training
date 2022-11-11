import java.util.ArrayList;
import java.util.List;

// t: all operations are O(1) at cost of storing dynamic array and two integers for the last index, and min value O(1)
// recomputing the min is done inside the pop operation O(N) (we might have removed the min value),
// on the push it only takes O(1) as we already have the min

public class MinStack{

    List<Integer> stack;
    int lastIdx;
    int minVal;

    public MinStack(){
        this.stack = new ArrayList<Integer>();
        this.lastIdx = -1;
        this.minVal = Integer.MAX_VALUE;
    }

    public void push(int val){
        this.stack.add(val);
        this.lastIdx++;
        this.minVal = Integer.min(this.minVal, val);
    }

    public void pop(){
        this.stack.remove(lastIdx);
        this.lastIdx--;
        if(this.lastIdx > -1) {
            this.minVal = this.stack.get(this.lastIdx);
        } else {
            this.minVal = Integer.MAX_VALUE;
        }
        for(int i = this.lastIdx - 1; i >= 0; i--){
            this.minVal = Integer.min(this.minVal, this.stack.get(i));
        }
    }

    public int top(){
        return this.stack.get(this.lastIdx);
    }

    public int getMin(){
        return this.minVal;
    }

}