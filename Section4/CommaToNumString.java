import acm.program.*; 
import acm.graphics.*; 
public class CommaToNumString extends ConsoleProgram{

	public void run() {   
		while (true) {
			String digits = readLine("Enter a numeric string: "); 
			if (digits.length() == 0) break; 
			println(addCommasToNumericString(digits));
		}
	}

	private String addCommasToNumericString(String digits) {
		String digitsWithCommas="";
		for (int i = 0; i < digits.length(); i++) {
			if(i!=0&&i%3==0) {
				digitsWithCommas=","+digitsWithCommas;
			}
			digitsWithCommas=digits.charAt(digits.length()-1-i)+digitsWithCommas;
		}
		return digitsWithCommas;
	}

}
