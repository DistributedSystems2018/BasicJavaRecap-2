package maincode;

public class Pascal {

	private static long binomial(int n, int k) {
		if (k > n - k)
			k = n - k;

		long b = 1;
		for (int i = 1, m = n; i <= k; i++, m--)
			b = b * m / i;
		return b;
	}

	public static void triangle(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(binomial(i, j));
			}
			System.out.println();
		}

	}

	public static String getNthLine(int n) {
		String output = "";
		for (int j = 0; j <= n; j++) {
			output += binomial(n, j);
			output += " ";
		}
		return output;
	}

}
