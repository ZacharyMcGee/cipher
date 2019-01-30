package cypher;
import java.util.Scanner;

public class mono {
	static char[] usCharArray = {      // The English Alphabet
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
	
	static char[] dataFreq = {       // The Frequency Dataset dataFreq[0] being the most freq
								'E', // E is the most frequently used letter
								'T',
								'A',
								'I',
								'N',
								'O',	
								'H',	
								'D',	
								'S',
								'G',
								'L',
								'R',
								'W',
								'U',
								'C',
								'F',
								'Y',
								'P',
								'B',
								'M',
								'V',
								'K',
								'Z',
								'X',
								'J',
								'Q' // The least frequently used
								};
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter");
		String input = scan.nextLine();
		
		System.out.println(swapLetters(input));	// Print results to console
	}
	
	// Swap letters by using the dataFreq dataset and freq of current input
	public static String swapLetters(String s) {
		char[] charArray = s.toCharArray();
		int[] freqCount = getLetterFrequency(s);
		freqCount = bubbleSort(freqCount);
		for(int i = 0; i < s.length(); i++) {
			boolean matched = false;
			int j = 0;
			while(!matched) {
				if(charArray[i] == usCharArray[j]) {
					charArray[i] = dataFreq[j];
					matched = true;
				}
				j++;
			}
		}
		return String.valueOf(charArray);
	}
	
	// Find the letter frequency in the input string
	public static int[] getLetterFrequency(String s) {
		char[] charArray = s.toCharArray();
		int[] freqCount = new int[26];
		for(int i = 0; i < s.length(); i++) {
			boolean matched = false;
			int j = 0;
			while(!matched) {
				if(charArray[i] == usCharArray[j]) {
					freqCount[j]++;
					matched = true;
				}
				j++;
			}
		}
		return freqCount;
	}
	
	// Sort the frequency of the letters
    public static int[] bubbleSort(int arr[]) 
    { 
        int n = arr.length; 
        for (int i = 0; i < n - 1; i++) 
            for (int j = 0; j < n - i - 1; j++) 
                if (arr[j] < arr[j + 1]) 
                { 
                    int temp = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp; 
                    
                    char tempChar = usCharArray[j];
                    usCharArray[j] = usCharArray[j+1];
                    usCharArray[j+1] = tempChar;
                } 
        return arr;
    } 
}
