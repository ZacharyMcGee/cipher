package cypher;
import java.util.Scanner; // Import Scanner

public class cypher {
	static char[] usCharArray = {
								  'a', // 0
								  'b', // 1
								  'c', // 2
								  'd', // 3
								  'e', // 4
								  'f', // 5
								  'g', // 6
								  'h', // 7
								  'i', // 8
								  'j', // 9
								  'k', // 10
								  'l', // 11
								  'm', // 12
								  'n', // 13
								  'o', // 14
								  'p', // 15
								  'q', // 16
								  'r', // 17
								  's', // 18
								  't', // 19
								  'u', // 20
								  'v', // 21
								  'w', // 22
								  'x', // 23
								  'y', // 24
								  'z'  // 25
						  		};
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in); // Create Scanner object
	    System.out.print("Enter Caesar Cipher to decode: "); // Prompt input
		String input = scan.nextLine(); // Set input to next line 
		input = input.toLowerCase(); // Make everything lowercase 
		char[] inputArray = input.toCharArray(); // Make the string a char array
		
		// Now we loop through 26 times, the max amount of combinations for a caesar cipher
		for(int i = 0; i < usCharArray.length; i++) { 
			System.out.println("Key: " + i + " - Output: " + letterShift(inputArray)); // Print Result
		}
	}

	public static String letterShift(char[] c) {
		for(int i = 0; i < c.length; i++) {
			c[i] = incrementChar(c[i]); // Change current char to next char for every char(Shift up 1)
		}
		return String.valueOf(c);
	}
	
	public static char incrementChar(char c) {
		c = usCharArray[getIndex(c)]; // We get the index of the current char
		return c;
	}
	
	public static int getIndex(char c) {
		for(int i = 0; i < usCharArray.length; i++) {
			if(c == usCharArray[i]) { // Look for the current char
				return (i + 1) % 26; // Return the next char and make sure we loop around if at end
			}
		}
		return -1; // Return negative if we don't find anything(not implemented)
	}
}
