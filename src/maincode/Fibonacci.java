package maincode;

public class Fibonacci {
	public static int fibNum(int n) {
		if (n == 0 || n == 1) {
			return 1;
		} else {
			return fibNum(n - 1) + fibNum(n - 2);
		}
	}
}
