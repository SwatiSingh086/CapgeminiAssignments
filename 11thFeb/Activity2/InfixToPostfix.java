package Activity2;
import java.util.*;
import java.lang.*;


public class InfixToPostfix {

    public static void main(String[] args) {
        String infix = "A+B*C";
        System.out.println(convert(infix));
    }

    public static String convert(String infix) {

        StringBuilder result = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : infix.toCharArray()) {

          
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            }

            else if (c == '(') {
                stack.push(c);
            }

            
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); 
            }

          
            else {
                while (!stack.isEmpty() &&
                        precedence(stack.peek()) >= precedence(c)) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static int precedence(char c) {
        if (c == '+' || c == '-') return 1;
        if (c == '*' || c == '/') return 2;
        if (c == '^') return 3;
        return -1;
    }
}

