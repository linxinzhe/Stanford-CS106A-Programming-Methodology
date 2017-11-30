import acm.program.ConsoleProgram;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.ArrayList;

public class HowPrime extends ConsoleProgram {
	public void run() {
		ArrayList<MyNum> numList=generateList(2,1000);

		for (int i = 0; i < numList.size(); i++) {
			MyNum prime=numList.get(i);
			if (!prime.isCrossed) {
				for (int j = i+1; j < numList.size(); j++) {
					MyNum num=numList.get(j);
					if (num.num%prime.num==0) {
						num.isCrossed=true;
					}
				}
			}
		}
		printArr(numList);
	}

	class MyNum{
		int num=0;
		boolean isCrossed=false;

		public MyNum(int num,boolean isCrossed) {
			this.num=num;
			this.isCrossed=isCrossed;
		}
	}

	private ArrayList<MyNum> generateList(int start,int end){
		ArrayList<MyNum> numList=new ArrayList<MyNum>();
		for (int i = start; i < end+1; i++) {
			numList.add(new MyNum(i, false));
		}
		return numList;
	}

	private void printArr(ArrayList<MyNum> arr) {
		for (int i = 0; i < arr.size(); i++) {
			MyNum num=arr.get(i);
			if (!num.isCrossed) {
				print(num.num);
				print(" ");
			}
		}
		println();
	}
}
