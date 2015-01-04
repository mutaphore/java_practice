import java.util.*;

public class Fib
{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n, nthFib;

		System.out.print("Enter n: ");
		n = in.nextInt();
		System.out.println("Nth fib num is " + fib(n));
	}

	static int fib(int n) {

		if (n == 1 || n == 0)
			return 1;
		else {
			return fib(n - 2) + fib(n - 1);
		}
	}
}