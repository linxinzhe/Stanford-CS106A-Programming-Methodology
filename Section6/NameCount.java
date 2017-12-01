import java.util.HashMap;
import java.util.Iterator;

import acm.program.ConsoleProgram;

public class NameCount extends ConsoleProgram {
	public void run() {
		HashMap<String, Integer> nameMap=new HashMap<>();
		while(true) {
			String name=readLine("Enter name:");
			if (name==null||name.equals("")) {
				break;
			}
			if (nameMap.get(name)!=null) {
				int count=nameMap.get(name);
				nameMap.put(name, count+1);
			}else {
				nameMap.put(name, 1);
			}
		}
		
		Iterator<String> iterator = nameMap.keySet().iterator();
		while(iterator.hasNext()) {
			String name=iterator.next();
			int num=nameMap.get(name);
			println("Entry ["+name+"] has count "+num);
		}
		
	}
	
	
}
