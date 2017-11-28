import acm.program.ConsoleProgram;

public class AlternatingCapitalLetter extends ConsoleProgram {
	public void run() {   
		println(altCaps("hello"));// returns "hElLo" 
		println(altCaps("section is awesome"));//returns "sEcTiOn Is AwEsOmE"
	}

	private String altCaps(String string) {
		String newString="";
		for (int i = 0; i < string.length(); i++) {
			char c=string.charAt(i);
			if (i%2==0) {
				newString+=Character.toLowerCase(c);
			}else {
				newString+=Character.toUpperCase(c);
			}
		}
		return newString;
	}
}
