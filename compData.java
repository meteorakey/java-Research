import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class compData {

	public static final String DIRPATH = "/Users/tatsuya/Documents/";
	public static final String ACTUAL = "ActualGroups_";
	public static final String TRUEGROUPS = "TrueGroups_";
	public static final String TXT = ".txt";



	public static void main(String args[]) {

		Set<String> classSet = new HashSet<String>();
		Set<String> compSet = new HashSet<String>();
		Set<String> result = new HashSet<String>();
		int count = 0;

		//一つ目
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.print("enter file name : ");
			String line = reader.readLine();
			if(line.equals("")) {
				System.out.println("end. ");
				return; 
			} else {
				String path = DIRPATH + TRUEGROUPS + line +TXT;
				System.out.println(line + "" + TXT);
				readGroupData(path, classSet);
			}
			//二つ目
			System.out.print("enter comp file name : ");
			line = reader.readLine();
			System.out.println(line);
			if(line.equals("")) {
				System.out.println("end. ");
				return; 
			} else {
				String path = DIRPATH + ACTUAL + line +TXT;
				System.out.println(line + "" + TXT);
				readGroupData(path, compSet);
			}

			//結果
			System.out.println("output compare result");
			Iterator<String> it = classSet.iterator();
			while (it.hasNext()) {
				String str = it.next();
				if (compSet.contains(str)) {
					count++;
					System.out.println(str);
				}
			}

			System.out.println(count);


		} catch (IOException e) {
			System.out.println(e);
		}

	}

	public static void readGroupData(String path, Set<String> compSet) {

		String tmp;

		try {
			FileReader filereader = new FileReader(path);
			BufferedReader reader = new BufferedReader(filereader);
			tmp = reader.readLine();
			while( (tmp = reader.readLine() ) != null ) {
				if ((tmp.length() == 0) || (tmp.contains("SimpleGroup") )) {
				} else {
					System.out.println(tmp);
					compSet.add(tmp);
				}
			}
			System.out.println(compSet.size());
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}


}
