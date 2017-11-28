import acm.program.ConsoleProgram;

public class PigLatin extends ConsoleProgram{
	public void run() {   
		println(pigLatin("elephant"));// returns "elephantyay" 
		println(pigLatin("aardvark"));// returns "aardvarkyay"	
		
		println(pigLatin("switch")); //returns "itchsway"
		println(pigLatin("string"));// returns "ingstray"
	}

	private String pigLatin(String string) {
		char[] vowel={'a','e','i','o','u'};
		for (int i = 0; i < vowel.length; i++) {
			if (string.startsWith(String.valueOf(vowel[i]))) {
				return string+"yay";
			}
		}
		
		for (int i = 0; i < string.length(); i++) {
			char c=string.charAt(i);
			
			for (int j = 0; j < vowel.length; j++) {
				if (vowel[j]==c) {
					String head=string.substring(0, i);
					String tail=string.substring(i);
					return tail+head+"ay";
				}
			}
		}
		return null;
	}
	
	
}
