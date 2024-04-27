package algorithm.leetcode.stack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Stack;


public class STACK155 {

    Logger logger = LogManager.getLogger(getClass());

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */

    class MinStack1 {

        // two stack
        /*
        新資料進來
        1. stack 使用 push() 將新資料放進 Stack 中。
        2. minStack 必須判斷新資料是否有比「目前最上面」還要小。
        2.1 如果有，就把新資料 push() 進 minStack，此時該資料會位在 minStack 的「最上面」，代表目前最小值。
        2.2 如果沒有，就把 minStack 「目前最上面」的資料，再 push() 進 minStack 一次，表示在新增資料後，「最小值」不變。
        3. 取得最小值就直接取 minStack 目前最上面的值

        例如
        stack    3
        minstack 3

        stack    3 4
        minstack 3 3

        stack    3 4 2
        minstack 3 3 2
         */

        // https://alrightchiu.github.io/SecondRound/stack-neng-gou-zai-o1qu-de-zui-xiao-zhi-de-minstack.html

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        public MinStack1() {

        }

        // 推入
        public void push(int val) {
            // Java stack.pop 叫做 stack.peek
            stack.push(val);
            if (minStack.empty() || val < minStack.peek()) {
                minStack.push(val);
            } else {
                minStack.push(minStack.peek());
            }
            logger.info("stack after push: stack {}", stack);
            logger.info("stack after push: minStack {}", minStack);
        }

        // 彈出
        public void pop() {
            if (stack.empty()) {
                return;
            }
            stack.pop();
            minStack.pop();
            logger.info("stack after pop: stack {}", stack);
            logger.info("stack after pop: minStack {}", minStack);
        }

        // 顯示最上值
        public int top() {
            if (stack.empty()) {
                return 0;
            }
            logger.info("stack show top: {}", stack.peek());
            return stack.peek();
        }

        // 顯示最小值
        public int getMin() {
            if (stack.empty()) {
                return 0;
            }
            logger.info("stack getMin: {}", minStack.peek());
            return minStack.peek();
        }
    }

    class MinStack2 {

        int min = Integer.MAX_VALUE;
        Stack<Integer> stack2 = new Stack<>();

        public MinStack2() {

        }

        public void push(int val) {
            logger.info("stack2 before push new data: {}", val);
            logger.info("stack2 before push old min: {}", min);
            if(val<min){
                stack2.push(min);
                min = val;
            }
            stack2.push(val);
            logger.info("stack2 after push new min: {}", min);
            logger.info("stack2 after push: {}", stack2);
            // 如果判斷進來的資料是最小值，就 push 2 次，先 push 目前最小值，再 push 進來的資料 (新的最小值) (先 old min 再 new min)
            // 如果判斷進來的資料不是最小值，就單純 push 1 次，push 進來的資料
        }

        public void pop() {
            // 如果 pop 的東西是目前最小值 (代表之前有 push 過兩次，先是 old min 再 new min (新近來資料))
            // 因此 pop 兩次後，再命 min 為 old min (第二個 pop)
            if(stack2.pop() == min) {
                min=stack2.pop();
                logger.info("stack2 after pop new min: {}", min);
                logger.info("stack2 after pop: {}", stack2);
            }
            // 如果 pop 的東西不是目前最小值，則只需要 pop 一次，這個再 if 就 pop 過了所以不用寫
        }

        public int top() {
            logger.info("stack2 top: {}", stack2.peek());
            return stack2.peek();
        }

        public int getMin() {
            logger.info("stack2 getMin: {}", min);
            return min;
        }
    }

    public static void main(String[] args) {
        STACK155 stack155 = new STACK155();
        MinStack1 minStack1 = stack155.new MinStack1();
        minStack1.push(-2);
        minStack1.push(0);
        minStack1.push(-3);
        minStack1.getMin(); // return -3
        minStack1.pop();
        minStack1.top();    // return 0
        minStack1.getMin(); // return -2

        System.out.println("============================");

        MinStack2 minStack2 = stack155.new MinStack2();
        minStack2.push(-2);
        minStack2.push(0);
        minStack2.push(-3);
        minStack2.getMin(); // return -3
        minStack2.pop();
        minStack2.top();    // return 0
        minStack2.getMin(); // return -2

    }

}
