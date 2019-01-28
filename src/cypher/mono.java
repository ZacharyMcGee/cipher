package cypher;
import java.util.Scanner;

public class mono {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter");
		String input = scan.nextLine();
		
		findDoubles(input);
		
	}
	
	public static void findTrigraphs(String s) {
		char[] charArray = s.toCharArray();

	}
	
	public static void findDoubles(String s) {
		char[] charArray = s.toCharArray();
		char[] doubleArray;
		char tempChar;
		
		for(int i = 0; i < charArray.length - 1; i++) {
			if(charArray[i] == charArray[i + 1]) {
				tempChar = charArray[i];
				System.out.println(tempChar);
			}
		}
	}
}
