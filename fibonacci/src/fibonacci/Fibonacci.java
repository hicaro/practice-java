package fibonacci;

public class Fibonacci 
{
	public static void main(String args[])
	{
		Fibonacci.fibonacci(10);
	}
	
	private static void fibonacci(int n)
	{
		int a = 0, b = 1, aux;
		for (int i = 0; i < n; i++) {
			System.out.println(a);
			aux = a + b;
			a = b;
			b = aux;
		}
	}
}
