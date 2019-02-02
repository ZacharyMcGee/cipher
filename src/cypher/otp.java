package cypher;

import java.math.BigInteger;

public class otp {
	public static void main(String args[]) {
		String crib = "this problem was was too easy";
		String cribHex = stringToHex(crib);


		
		String xorMessage1 = "16840c56b2ec1560c206c101d89adbd808ce90a2fce4842f335a91297d";
		String xorMessage2 = "16840005fffd0e61801ad6039a81dfc608ce90a8fce48460604b912870";
		String xorMessage3 = "04831705f3bc147fc509cd0d94cdc8ce5fd883bffcf68432334b983377";
		String xorMessage4 = "0f890051b2f5092fcd1384039e8bd3c84d999eb5fcf68e22334c9922700";
		String xorMessage5 = "118d1c05e6f4022fd705d608d89ddbd85bd09fafb9e28d25615a9e3961";
		String xorMessage6 = "0f954551fbf1022fc11e841f91989ac349cad1b9b9f58560744d953b70";
		
		
		String[] xorBoth = new String[36];
		xorBoth[0] = "00000" + xorHex(xorMessage1, xorMessage2);
		xorBoth[1] = xorHex(xorMessage1, xorMessage3);
		xorBoth[2] = "190D0C0700191C4F0F1545024611081045570E1700120A0D0016080B0D";
		xorBoth[3] = "0" + xorHex(xorMessage1, xorMessage5);
		xorBoth[4] = xorHex(xorMessage1, xorMessage6);
		xorBoth[5] = xorHex(xorMessage2, xorMessage3);
		xorBoth[6] = xorHex(xorMessage2, xorMessage4);
		xorBoth[7] = "0" + xorHex(xorMessage2, xorMessage5);
		xorBoth[8] = xorHex(xorMessage2, xorMessage6);
		xorBoth[9] = xorHex(xorMessage3, xorMessage4);
		xorBoth[10] = xorHex(xorMessage3, xorMessage5);
		xorBoth[11] = "0" + xorHex(xorMessage3, xorMessage6);
	    xorBoth[12] = xorHex(xorMessage4, xorMessage5);
		xorBoth[13] = xorHex(xorMessage4, xorMessage6);
		xorBoth[14] = xorHex(xorMessage5, xorMessage6);
		xorBoth[15] = "00000" + xorHex(xorMessage2, xorMessage1);
		xorBoth[16] = xorHex(xorMessage3, xorMessage1);
		xorBoth[17] = xorHex(xorMessage4, xorMessage1);
		xorBoth[18] = "0" + xorHex(xorMessage5, xorMessage1);
		xorBoth[19] = xorHex(xorMessage6, xorMessage1);
		xorBoth[20] = xorHex(xorMessage3, xorMessage2);
		xorBoth[21] = xorHex(xorMessage4, xorMessage2);
		xorBoth[22] = "0" + xorHex(xorMessage5, xorMessage2);
		xorBoth[23] = xorHex(xorMessage6, xorMessage2);
		xorBoth[24] = xorHex(xorMessage4, xorMessage3);
		xorBoth[25] = xorHex(xorMessage5, xorMessage3);
		xorBoth[26] = "0" + xorHex(xorMessage6, xorMessage3);
	    xorBoth[27] = xorHex(xorMessage5, xorMessage4);
		xorBoth[28] = xorHex(xorMessage6, xorMessage4);
		xorBoth[29] = xorHex(xorMessage6, xorMessage5);

		for(int j = 0; j < 15; j++) {
			System.out.println("ATTEMPT #" + j + "@@@@@@@@@@@");
			System.out.println(xorBoth[j] + " " + xorBoth[j].length());
			for(int i = 0; i < 10; i++) {
				//String xorTrim = xorBoth[j].substring(i, i + testwordHex.length());
				String result = xorHex(xorBoth[j], cribHex);
				//for(int k = 0; k < i; k++) {
				//	System.out.print(".");
				//}
				System.out.print(hexToAscii(result));
				//for(int k = 0; k < xorBoth[j].length() - i; k++) {
				//	System.out.print(".");
				//}
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
