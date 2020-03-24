import java.util.Scanner;

public class Annotations {
	
	static void printTriangle(int size) {
		for (int i = 1; i <= size; i++) {
			printRowOfNumbers(i);
		}
		
		for (int i = size - 1; i >= 1; i--) {
			printRowOfNumbers(i);
		}
	}
	
	static void printRowOfNumbers(int lastNumber) {
		for (int i = 1; i <= lastNumber; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static void main (String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		
		printTriangle(size);
		
	}
}
