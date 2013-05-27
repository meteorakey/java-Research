import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class compGroupData {


	public static final String DIRPATH = "/Users/tatsuya/Documents/";
	public static final String ACTUAL = "ActualGroups_";
	public static final String TRUEGROUPS = "TrueGroups_";
	public static final String COMMON = "Common_";
	public static final String TXT = ".txt";



	public static void main(String args[]) {

		Map<String, Set<String>> groups = new HashMap<String, Set<String>>();
		Set<String> classSet = new HashSet<String>();
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
				System.out.println(TRUEGROUPS + "" + line + "" + TXT);
				readGroupData(path, groups);
			}

			//二つ目
			System.out.print("enter comp classname file : ");
			line = reader.readLine();
			if(line.equals("")) {
				System.out.println("end. ");
				return; 
			} else {
				String path = DIRPATH + COMMON + line +TXT;
				System.out.println(COMMON + "" + line + "" + TXT);
				readClassData(path, classSet);
			}

			//結果
			System.out.println("output compare result");
			Iterator<String> it = classSet.iterator();
			while (it.hasNext()) {
				String str = it.next();
				for (Map.Entry<String, Set<String>> entry : groups.entrySet()) {
					if (entry.getValue().contains(str)) {
						result.add(entry.getKey());
						System.out.println(entry.getKey() + "→" + str);
					}
				}
			}
			System.out.println("result : group num");
			it = result.iterator();
			while (it.hasNext()) {
				String str = it.next();
				System.out.println(str);
			}
			System.out.println(result.size());



		} catch (IOException e) {
			System.out.println(e);
		}

	}

	public static void readGroupData(String path, Map<String, Set<String>> groups) {

		String tmp;
		String key = null;
		Set<String> set = new HashSet<String>();

		try {
			FileReader filereader = new FileReader(path);
			BufferedReader reader = new BufferedReader(filereader);

			while( (tmp = reader.readLine() ) != null ) {
				if (tmp.contains("SimpleGroup")) {
					key = tmp;
					set = new HashSet<String>();
				} else if (tmp.length() == 0) {
					groups.put(key, set);
				} else {
					set.add(tmp);					
				}
			}
			System.out.println(groups.size());
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static Set<String> getSet(Set<String> set) {
		return set;
	}

	// 比較対象のクラス名ファイル読み込み
	public static void readClassData(String path, Set<String> compSet) {

		String tmp;

		try {
			FileReader filereader = new FileReader(path);
			BufferedReader reader = new BufferedReader(filereader);
			while( (tmp = reader.readLine() ) != null ) {
				compSet.add(tmp);
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
