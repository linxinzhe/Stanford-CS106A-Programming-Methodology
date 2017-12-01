import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import acm.graphics.GImage;
import acm.program.ConsoleProgram;
import java.util.ArrayList;

public class MutualFriend  extends ConsoleProgram{
	public void run() {
		HashMap<String,Integer> friend1=generateMap(1);
		HashMap<String,Integer> friend2=generateMap(2);
		
		HashMap<String,Integer> mutualFriend= mutualFriends(friend1,friend2);
		printMap(mutualFriend);
	}
	
	private HashMap<String,Integer>  mutualFriends(HashMap<String,Integer> map1,HashMap<String,Integer> map2) {
		HashMap<String,Integer> mutualFriend=new HashMap<>();
		Iterator<String> iterator = map1.keySet().iterator();
		while (iterator.hasNext()) {
			String name = iterator.next();
			int number=map1.get(name);
			if(map2.get(name)!=null&&number==map2.get(name)) {
				mutualFriend.put(name, number);
			}
		}
		return mutualFriend;
	}
	
	private void printMap(HashMap<String, Integer> map) {
		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			String name = iterator.next();
			print(name+"="+map.get(name)+" ");
		}
		println();
	}

	private HashMap generateMap(int i) {
		ArrayList<String> friendListRawText=new ArrayList();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("./friend_list.txt"));
			while(true) {
				String line=reader.readLine();
				if (line==null) {
					break;
				}else {
					friendListRawText.add(line);
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		HashMap<String,Integer> map=new HashMap<>();
		switch (i) {
		case 1:{
			String friendRawText=friendListRawText.get(0);
			String[] nameIntPairs = friendRawText.split(",");
			for (int j = 0; j < nameIntPairs.length; j++) {
				String[] nameInt = nameIntPairs[j].split("=");
				map.put(nameInt[0], Integer.valueOf(nameInt[1]));
			}
			break;}
		case 2:{
			String friendRawText=friendListRawText.get(1);
			String[] nameIntPairs = friendRawText.split(",");
			for (int j = 0; j < nameIntPairs.length; j++) {
				String[] nameInt = nameIntPairs[j].split("=");
				map.put(nameInt[0], Integer.valueOf(nameInt[1]));
			}
			break;}
		default:
			break;
		}
		return map;
	}

	
}
