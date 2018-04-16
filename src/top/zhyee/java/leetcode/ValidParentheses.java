package top.zhyee.java.leetcode;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Boolean b = false;
        Stack stack = new Stack();
        if (s.length() % 2 != 0) {
            return b;
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='{'||s.charAt(i)=='('||s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }
            else if(s.charAt(i)=='}'||s.charAt(i)==')'||s.charAt(i)==']'){
                if(stack.empty()){
                    return b;
                }
                char c = (char) stack.peek();
                if(c=='{'){
                    if(s.charAt(i)!='}'){
                        return b;
                    }
                }
                else if(c=='['){
                    if(s.charAt(i)!=']'){
                        return b;
                    }
                }
                else if(c=='('){
                    if(s.charAt(i)!=')'){
                        return b;
                    }
                }
                stack.pop();
            }
        }
        if(stack.empty()){
            b = true;
        }
        return b;
    }



    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("){"));
    }
}
