package stack.easy;

import java.util.Stack;

public class _155_Min_Stack {

    /**
     * push(x) -- Push element x onto stack.
     * pop() -- Removes the element on top of the stack.
     * top() -- Get the top element.
     * getMin() -- Retrieve the minimum element in the stack.
     *
     *
     * two stacks
     * stack1, store in order //2,1
     * stack2, sorted min-max //2,1
     *
     * 2-1-3
     * stack1: 3-1-2
     * stack2: 1-2
     *
     */
    class MinStack {

        private Stack<Integer> stack1;
        private Stack<Integer> stack2;
        /** initialize your data structure here. */
        public MinStack() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            stack1.push(x);
            if(stack2.empty() || x <= stack2.peek()) {
                stack2.push(x);
            }
        }

        public void pop() {
            if(stack1.peek().equals(stack2.peek())) {
                stack2.pop();
            }
            stack1.pop();
        }

        public int top() {
            return stack1.peek();
        }

        public int getMin() {
            return stack2.peek();
        }
    }

    /**
     * one stack solution.
     *
     * stack保存和min的diff
     *
     * input 2,1
     * stack: -1,0 //1,2
     * min = 1
     */
    public class MinStackOne {
        long min;
        Stack<Long> stack;

        public MinStackOne(){
            stack=new Stack<>();
        }

        public void push(int x) {
            if (stack.isEmpty()){
                stack.push(0L);
                min=x;
            }else{
                stack.push(x-min);//Could be negative if min value needs to change
                if (x<min) min=x;
            }
        }

        public void pop() {
            if (stack.isEmpty()) return;

            long pop=stack.pop();

            if (pop<0)  min=min-pop;//If negative, increase the min value

        }

        public int top() {
            long top=stack.peek();
            if (top>0){
                return (int)(top+min);
            }else{
                return (int)(min);
            }
        }

        public int getMin() {
            return (int)min;
        }
    }
}
