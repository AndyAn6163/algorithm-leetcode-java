package algorithm.leetcode.stack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Stack;

public class LC0020ValidParentheses {

    private static final Logger logger = LogManager.getLogger(LC0020ValidParentheses.class);

    public static void main(String[] args) {

        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "()[]{}";
        String s4 = "([{}])";


        Solution solution = new Solution();
        boolean a = solution.isValid(s4);
        logger.info("a = {}", a);
    }
}

class Solution {

    private static final Logger logger = LogManager.getLogger(Solution.class);

    public boolean isValid(String s) {

        // The Character class wraps a value of the primitive type char in an object
        Stack<Character> charStack = new Stack<>();

        for(char character : s.toCharArray()){

            logger.info("charStack : {}", charStack);

            if(character=='(' || character=='{' || character=='['){
                // 欲判斷字元放在 Stack，只要 match 成功，就移出 Stack
                // 最糟的情況 [(, [, {]，必須要 "([{}])" 才會 return true
                // 最佳的情況 []，即 empty String ""，絕對會封閉
                charStack.push(character);
            }else {

                if(charStack.empty()){
                    // 表示第一個字元就是 )、}、]，")..."、"[..."、"{..."，不可能封閉
                    return false;
                }

                if(character==')' && charStack.peek()=='('){
                    // 表示本字元跟前一字元能夠封閉起來，移出判斷的 Stack
                    charStack.pop();
                } else if(character=='}' && charStack.peek()=='{'){
                    charStack.pop();
                } else if(character==']' && charStack.peek()=='['){
                    charStack.pop();
                } else {
                    return false;
                }
            }
        }
        // 最佳的情況 []，即 empty String ""，絕對會封閉，return true
        return charStack.empty();
    }
}
