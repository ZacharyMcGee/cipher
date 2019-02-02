package cypher;
import java.util.Arrays;

public class feistel_block {
	final static int ROUNDS = 16;
	final static int BLOCK_SIZE = 32;
	
	public static void main(String args[]) {
		String message = "Here's a Message";
		String messageEnc = encrypt(message);
		System.out.println(messageEnc);
		String messageDec = decrypt(messageEnc);
		System.out.println(hexToAscii(messageDec));
	}
	
	private static char function(char c, char[] key, int i) {
	    return (char) (c + (key[i % key.length]));    
	}
	
	public static String encrypt(String s) {
		char[] KEY = {'T', 'H', 'I', 'S', 'I', 'S', 'A', 'K', 'E', 'Y', '1', '2', '3'};

		s = stringToHex(s);
		String leftStr = s.substring(0, s.length() / 2);
		String rightStr = s.substring((s.length() / 2), s.length());
    
		char[] left = leftStr.toCharArray();
		char[] right = rightStr.toCharArray();
		char[] temp;
    
		System.out.println(Arrays.toString(left) + "" + Arrays.toString(right));
		for(int r = 1; r <= ROUNDS; r++) {
			for(int i = 0; i < right.length; i++){
				left[i] ^= (function(right[i], KEY, r));
			}
			System.out.println ("Encryption Round: " + r + " - " + Arrays.toString(left) + " " + Arrays.toString(right));
			temp = left; 
			left = right; 
			right = temp; 
		}
		String finished = String.valueOf(left) + String.valueOf(right);
		return finished;
	}
	
	public static String decrypt(String s) {
		char[] KEY = {'T', 'H', 'I', 'S', 'I', 'S', 'A', 'K', 'E', 'Y', '1', '2', '3'};
		String leftStr = s.substring(0, s.length() / 2);
		String rightStr = s.substring((s.length() / 2), s.length());
    
		char[] left = leftStr.toCharArray();
		char[] right = rightStr.toCharArray();
		char[] temp;
		
		for(int r = ROUNDS; r >= 1; r--) {
			temp = left; 
			left = right; 
			right = temp;
			for(int i = 0; i < right.length; i++) {
				left[i] ^= (function(right[i], KEY, r));
			}
			System.out.println ("Decryption Round: " + r + " - " + Arrays.toString(left) + " " + Arrays.toString(right));
		}
		String finished = String.valueOf(left) + String.valueOf(right);
		return finished;
	}
	
	public static String stringToHex(String str){  
		char[] chars = str.toCharArray();
		  
		StringBuffer hex = new StringBuffer();
		for(int i = 0; i < chars.length; i++){
		  hex.append(Integer.toHexString((int)chars[i]));
		}
		  
		return hex.toString();
	}
	  
	private static String hexToAscii(String hexStr) {
		StringBuilder output = new StringBuilder("");
		    
		for (int i = 0; i < hexStr.length(); i += 2) {
			if(i + 1 < hexStr.length()){
				String str = hexStr.substring(i, i + 2);
				output.append((char) Integer.parseInt(str, 16));
			}
		}
		return output.toString();
	}
}
