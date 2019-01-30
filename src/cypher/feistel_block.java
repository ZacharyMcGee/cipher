package cypher;

import java.nio.charset.Charset;
import java.util.Arrays;

public class feistel_block {
	public static int rounds = 14;
	public final static int key = 8;
	public final static String mkey = "HELLOWORLD";
	private static final Charset UTF_8 = Charset.forName("UTF-8");
	public static void main(String args[]) {
		encrypt("HEYYYYY");
	}

	public static void encrypt(String s) {
		s = toBinary(s);
		char[] charArray = s.toCharArray();
		for(int i = 0; i < (s.length() / 32); i++) {
			split(s.substring(i * 32, (i+1) * 32));
		}
	}
	
	public static String toBinary(String s) {
		byte[] bytes = s.getBytes(UTF_8);
		  StringBuilder binary = new StringBuilder();
		  for (byte b : bytes)
		  {
		     int val = b;
		     for (int i = 0; i < 8; i++)
		     {
		        binary.append((val & 128) == 0 ? 0 : 1);
		        val <<= 1;
		     }
		  }
		  s = binary.toString();
		 return s;
	}
	
	public static String split(String s) {
		String leftStr = s.substring(0, s.length() / 2);
		String rightStr = s.substring(s.length() / 2, s.length());
		
	    int[] left = new int[leftStr.length()];
	    int[] right = new int[rightStr.length()];
	    
	    for (int i = 0; i < leftStr.length(); i++) {

	    }
	    System.out.println ("=====RIGHT=====");
	    for(int r = 1; r <= rounds; r++) {
	        for(int i = 0; i < right.length; i++){
	            left[i] ^= (scramble(right[i], key, r));
	        }
	        System.out.println ("ENC"+r +" "+Arrays.toString(left) +" "+Arrays.toString(right));
	        int[] temp = left; 
	        left = right; 
	        right = temp; // swap after
	    }
	    for(int r = rounds; r >= 1; r--) {
	        int[] temp = left; left = right; right = temp; // swap before on decrypt
	        for(int i = 0; i < right.length; i++) {
	            left[i] ^= (scramble(right[i], key, r));
	        }
	        System.out.println ("DEC"+r + " "+Arrays.toString(left) +" "+Arrays.toString(right));
	    }
		return s;
	}
	
	private static int scramble(int character, int key, int roundNumber) {
	    return (int) Math.pow(6 * roundNumber * key, character) % 15;
	}
}
