import java.io.BufferedReader;
import java.io.FileReader;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.StringBuffer;

public class GetSubSetList {
    public static void main(String args[]) {

	String fileName = "MethodListCounted";

	try {
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    String line;
	    TreeMap<String, String> map = new TreeMap<String, String>();
	    while((line = br.readLine()) != null) {
		String[] strs = line.split(",");
		map.put(strs[0], strs[1]);
	    }

	    Boolean flag = false;
	    int total =0 ;
	    int count = 0;
	    int unique = 0;
	    for (Entry<String, String> entry : map.entrySet()) {
		total++;
		String method = entry.getKey();
		StringBuffer sb = new StringBuffer();
		//sb.append(method + ",");
		sb.append(method + ", " + entry.getValue() + "\n");
		for (Entry<String, String> checkedEntry : map.entrySet()) {
		    if (method.compareTo(checkedEntry.getKey()) > 0) {
			if (isSubSet(method, checkedEntry.getKey())) {
			    count++;
			    flag = true;
			    //sb.append(checkedEntry.getKey() + "\t");
			    sb.append(checkedEntry.getKey() + ", " + checkedEntry.getValue() + " ");
			}
		    }
		}
		if(flag) {
		    unique++;
		    System.out.println(sb.toString() + "\n");
		    flag = false;
		}

	    }
	    System.out.println(count + "," + unique + "," + total);
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }

    private static Boolean isSubSet(String method, String candidate) {

	if(method.equals(candidate)) return false;
	method = method.toLowerCase();
	String strs[] = candidate.split("(?<=[A-Z])(?=[A-Z][a-z])|(?<=[a-z])(?=[A-Z])");
	int count = 0;
	for (String str : strs) {
	    str = str.toLowerCase();
	    if (method.contains(str)
		&& !str.equals("get") && !str.equals("set") && !str.equals("add")
		) count++;
	}

	if (count > 1) return true;

	return false;
    }
}
