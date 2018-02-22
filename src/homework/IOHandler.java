package homework;

import java.util.Scanner;

import maincode.Fibonacci;
import maincode.Pascal;

public class IOHandler {

	private Scanner sc;

	public IOHandler() {
		sc = new Scanner(System.in);
	}

	public void readIO() {
		System.out.println(sc.nextLine());
	}

	public void sumIO() {
		String[] numbers = sc.nextLine().split(" ");
		if (numbers.length != 2) {
			System.out.println("Error: expecting 2 numbers only (separated by space)");
			return;
		}
		int num1 = Integer.parseInt(numbers[0]);
		int num2 = Integer.parseInt(numbers[1]);
		System.out.println(num1 + num2);
	}

	public void printIOLength() {
		System.out.println(sc.nextLine().length());
	}

	public void countWordsIO() {
		System.out.println(sc.nextLine().split("\\s+").length);
	}

	public void printFibAndPascal() {
		int n = sc.nextInt();
		System.out.println("Pascal row: " + Pascal.getNthLine(n) + "and fib number: " + Fibonacci.fibNum(n));
	}

	public void cleanup() {
		sc.close();
	}

}
