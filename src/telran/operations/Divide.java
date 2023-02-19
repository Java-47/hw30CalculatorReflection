package telran.operations;

public class Divide {
	
    public double execute(double a, double b) {
        if (b == 0) {
            System.out.println("error divide by zero");
            return 0;
        }
		return a / b;
    }
}

