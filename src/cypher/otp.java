package cypher;
import java.util.Scanner;
import java.math.BigInteger;

public class otp {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		String message = "Hello World";
		String message2 = "the program";
		String key = "supersecret";
		String testWord = "please";
		String messageHex = stringToHex(message);
		String message2Hex = stringToHex(message2);
		String testwordHex = stringToHex(testWord);
		String keyHex = stringToHex(key);

		//String xorMessage1 = xorHex(messageHex, keyHex);
		//String xorMessage2 = xorHex(message2Hex, keyHex);
		
		//String messageee1 = stringToHex("kcilwhzvsba");
		//String messageee2 = stringToHex("uozckikhdet");
		//String hexMessage1 = xorHex(messageee1, keyHex);
		//String hexMessage2 = xorHex(messageee2, keyHex);

		
		String xorMessage1 = "16840c56b2ec1560c206c101d89adbd808ce90a2fce4842f335a91297d";
		String xorMessage2 = "16840005fffd0e61801ad6039a81dfc608ce90a8fce48460604b912870";
		String xorMessage3 = "04831705f3bc147fc509cd0d94cdc8ce5fd883bffcf68432334b983377";
		String xorMessage4 = "0f890051b2f5092fcd1384039e8bd3c84d999eb5fcf68e22334c9922700";
		String xorMessage5 = "118d1c05e6f4022fd705d608d89ddbd85bd09fafb9e28d25615a9e3961";
		String xorMessage6 = "0f954551fbf1022fc11e841f91989ac349cad1b9b9f58560744d953b70";
		
		
		String[] xorBoth = new String[16];
		xorBoth[0] = "0" + xorHex(xorMessage1, xorMessage2);
		xorBoth[1] = "0" + xorHex(xorMessage1, xorMessage3);
		xorBoth[2] = "0" + xorHex(xorMessage1, xorMessage4);
		xorBoth[3] = "0" + xorHex(xorMessage1, xorMessage5);
		xorBoth[4] = "0" + xorHex(xorMessage1, xorMessage6);
		xorBoth[5] = "0" + xorHex(xorMessage2, xorMessage3);
		xorBoth[6] = "0" + xorHex(xorMessage2, xorMessage4);
		xorBoth[7] = "0" + xorHex(xorMessage2, xorMessage5);
		xorBoth[8] = "0" + xorHex(xorMessage2, xorMessage6);
		xorBoth[9] = "0" + xorHex(xorMessage3, xorMessage4);
		xorBoth[10] = "0" + xorHex(xorMessage3, xorMessage5);
		xorBoth[11] = "0" + xorHex(xorMessage3, xorMessage6);
	    xorBoth[12] = "0" + xorHex(xorMessage4, xorMessage5);
		xorBoth[13] = "0" + xorHex(xorMessage4, xorMessage6);
		xorBoth[14] = "0" + xorHex(xorMessage5, xorMessage6);

		for(int j = 0; j < 14; j++) {
			System.out.println("ATTEMPT #" + j + "@@@@@@@@@@@");
			for(int i = 0; i < xorBoth[j].length() - 16; i++) {
				String xorTrim = xorBoth[j].substring(i, i + testwordHex.length());
				String result = xorHex(xorTrim, testwordHex);
				for(int k = 0; k < i; k++) {
					System.out.print(".");
				}
				System.out.print(hexToAscii(result));
				for(int k = 0; k < xorBoth[j].length() - i; k++) {
					System.out.print(".");
				}
				System.out.println();
		}
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
