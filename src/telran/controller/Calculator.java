package telran.controller;

import java.lang.reflect.Method;

public class Calculator {

	public double calc(double a, double b, String operation)
			throws IllegalArgumentException, ClassNotFoundException, IllegalAccessException, NoSuchMethodException {
		try {
			Class<?> clazzOperation = Class.forName("telran.operations." + operation);

			Method method = clazzOperation.getDeclaredMethod("execute", double.class, double.class);
			return (double) method.invoke(clazzOperation.getDeclaredConstructor().newInstance(), a, b);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Double.NaN;
	}

	public static void main(String[] args) throws NumberFormatException, IllegalArgumentException,
			ClassNotFoundException, IllegalAccessException, NoSuchMethodException {
		if (args.length < 3) {
			System.out.println("Wrong arguments count. Need 3 args");
			return;
		}

		Calculator calculator = new Calculator();
		double res = calculator.calc(Double.parseDouble(args[0]), Double.parseDouble(args[1]), args[2]);
		System.out.println(res);
	}

}
