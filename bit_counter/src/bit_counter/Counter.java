package bit_counter;

public class Counter {
	
	public static void main(String[] args){
		System.out.println("Naive method: " + naive(15));
		System.out.println("Kernighan's method: " + kernighan(15));
		System.out.println("Absolute number: " + abs(-15));
	}
	
	private static int naive(int number){
		int counter = 0;
		
		for (int i = 7; i >= 0; i--){
			if(((1 << i) & number) != 0){
				counter++;
			}
		}
		
		return counter;
	}
	
	private static int kernighan(int number){
		int counter = 0;
		
		while(number != 0){
			number &= (number - 1);
			counter++;
		}
		
		return counter;
	}
	
	private static int abs(int number){
		int bit31 = number >> 31;
		return (number ^ bit31) - bit31;
	}
}
