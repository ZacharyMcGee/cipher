package cypher;
import java.util.Scanner;
import java.math.BigInteger;

public class otp {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		String message = "Hello World";
		String message2 = "the program";
		String key = "supersecret";
		String testWord = "sowhat";
		String messageHex = stringToHex(message);
		String message2Hex = stringToHex(message2);
		String testwordHex = stringToHex(testWord);
		String keyHex = stringToHex(key);

		//String xorMessage1 = xorHex(messageHex, keyHex);
		//String xorMessage2 = xorHex(message2Hex, keyHex);
		
		String messageee1 = stringToHex("kcilwhzvsba");
		String messageee2 = stringToHex("lvuwegrwwla");
		String xorMessage1 = xorHex(messageee1, keyHex);
		String xorMessage2 = xorHex(messageee2, keyHex);

		
		//String xorMessage1 = "16840c56b2ec1560c206c101d89adbd808ce90a2fce4842f335a91297d";
		//String xorMessage2 = "16840005fffd0e61801ad6039a81dfc608ce90a8fce48460604b912870";
		
		System.out.println(xorMessage1);
		System.out.println(xorMessage2);
		
		String xorBoth = xorHex(xorMessage1, xorMessage2);
		
		System.out.println(xorBoth);
		
		System.out.println(testwordHex.length());
		System.out.println(xorBoth.length());
		
		System.out.println(xorBoth);

		for(int i = 0; i < xorBoth.length(); i++) {
				String xorTrim = xorBoth.substring(i, i + testwordHex.length());
				String result = xorHex(xorTrim, testwordHex);
				for(int j = 0; j < i; j++) {
					System.out.print(".");
				}
				System.out.print(hexToAscii(result));
				for(int j = 0; j < xorBoth.length() - i; j++) {
					System.out.print(".");
				}
				System.out.println();
		}
		
	}
	
	  public static String stringToHex(String str){
		  
		  char[] chars = str.toCharArray();
		  
		  StringBuffer hex = new StringBuffer();
		  for(int i = 0; i < chars.length; i++){
		    hex.append(Integer.toHexString((int)chars[i]));
		  }
		  
		  return hex.toString();
	  }
	  
	public static String xorHex(String str1, String str2) {
		BigInteger i1 = new BigInteger(str1, 16);
		BigInteger i2 = new BigInteger(str2, 16);
		BigInteger res = i1.xor(i2);
		String str3 = res.toString(16);
		return str3;
	}
	
	public static String hexToBinary(String hex) {
	    int i = Integer.parseInt(hex, 16);
	    String bin = Integer.toBinaryString(i);
	    return bin;
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
