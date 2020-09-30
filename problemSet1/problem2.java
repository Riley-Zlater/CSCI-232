package problemSet1;

import java.util.Stack;

public class problem2 {

	public static boolean balanceChecker(String input) {
		
		Stack<Character> myStack = new Stack<Character>();
		char paranthesis;
		
		for (int i = 0; i < input.length(); i++) {
			paranthesis = input.charAt(i);
			
			if (paranthesis == '('|| paranthesis == '{' || paranthesis == '[') {
				myStack.push(paranthesis);
				continue;
			}
			
			if (myStack.isEmpty()) {
				return false;
			}
			
			if (paranthesis == ')' || paranthesis == ']' || paranthesis == '}') {
				myStack.pop();
			}
		}
		
		return (myStack.isEmpty());
	}
	
	public static void main(String[] args) {
		String[] test = {"({[]})", "((()))((()))", "([{]]})", "{}[](){"};

		for (String input: test) {
			if (balanceChecker(input)) {
				System.out.println("Testing: "+ input + " The paranthesis are balanced.");
			} else {
				System.out.println("Testing: " + input + " The paranthesis are NOT balanced.");
			}
		}
	}
}
