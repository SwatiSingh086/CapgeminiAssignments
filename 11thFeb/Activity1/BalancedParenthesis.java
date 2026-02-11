package Activity1;
import java.util.*;
import java.lang.*;

public class BalancedParenthesis {
	public static void main(String[] args) {
		String str= "({[]})";
		System.out.println(balanced(str));
	}

	public static boolean balanced(String str) {
		
		Deque<Character> stack= new ArrayDeque<>();
		
		for(char c: str.toCharArray()) {
			
			if(c=='{' || c=='(' || c=='[') {
				stack.push(c);
			}
			
			else if(c==')' || c=='}' || c==']') {
				if(stack.isEmpty()) return false;
				char top=stack.peek();
				if(c=='}' && top!='{'||
						c==')' && top!='('||
						c==']' && top!='[') {
					return false;
				}
				stack.pop();
			}
		}
		return stack.isEmpty();
	}
	
	
	
}
