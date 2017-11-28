import acm.program.ConsoleProgram;

public class RemoveAllOccurrences extends ConsoleProgram{
	public void run() {   

		println(removeAllOccurrences("Summer is here!", 'e'));
		
	}

	private String removeAllOccurrences(String string, char occurrence) {
		String newString="";
		for (int i = 0; i < string.length(); i++) {
			char c=string.charAt(i);
			if(c!=occurrence) {
				newString+=c;
			}
		}
		return newString;
	}
}
