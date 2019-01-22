package Lambda_Expression;

import lombok.Data;

public class Lambda_Expression {

	public static void main(String args[]) {
		Lambda_Expression lambdaExpression = new Lambda_Expression();

		// with type declaration
		MathOperation addition = (int a, int b) -> a + b;
		// with out type declaration
		MathOperation subtraction = (a, b) -> a - b;
		// with return statement along with curly braces
		MathOperation multiplication = (int a, int b) -> {
			return a * b;
		};
		// without return statement and without curly braces
		MathOperation division = (int a, int b) -> a / b;
		
		System.out.println("10 + 5 = " + lambdaExpression.operate(10, 5, addition));
		System.out.println("10 - 5 = " + lambdaExpression.operate(10, 5, subtraction));
		System.out.println("10 x 5 = " + lambdaExpression.operate(10, 5, multiplication));
		System.out.println("10 / 5 = " + lambdaExpression.operate(10, 5, division));

		GreetingService greetService1 = message -> System.out.println("Hello " + message);

		greetService1.sayMessage("Assaduzzaman");
	}

	interface MathOperation {
		int operation(int a, int b);
	}

	interface GreetingService {
		void sayMessage(String message);
	}

	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}

}
