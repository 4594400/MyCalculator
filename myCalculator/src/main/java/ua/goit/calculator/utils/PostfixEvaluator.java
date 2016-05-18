package ua.goit.calculator.utils;

import java.util.Stack;

public class PostfixEvaluator {
	

	public Double evaluate(String postfix) {
		Stack<Double> s = new Stack<Double>();
		char[] chars = postfix.toCharArray();

		int N = chars.length;

		for (int i = 0; i < N; i++) {
			char ch = chars[i];

			if (isOperator(ch)) {
				// Operator, simply pop out two numbers from stack and perfom
				// operation
				// Notice the order of operands
				switch (ch) {
				case '+':
					s.push(s.pop() + s.pop());
					break;
				case '*':
					s.push(s.pop() * s.pop());
					break;
				case '-':
					s.push(-s.pop() + s.pop());
					break;
				case '/':
					s.push(1 / s.pop() * s.pop());
					break;
				case '^':
					Double x = s.pop();
					s.push(Math.pow(s.pop(), x));
					break;
				}
			} else if (Character.isDigit(ch)) {
				// Number, push to the stack
				s.push(0.0);
				while (Character.isDigit(chars[i]))
					s.push(10.0 * s.pop() + (chars[i++] - '0'));
			}
		}

		// The final result should be located in the bottom of stack
		// Otherwise return 0.0
		if (!s.isEmpty())
			return s.pop();
		else
			return 0.0;
	}

	/**
	 * Check if the character is an operator
	 */
	private static boolean isOperator(char ch) {
		return ch == '*' || ch == '/' || ch == '+' || ch == '-' || ch == '^';
	}

}
