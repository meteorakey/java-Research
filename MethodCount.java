import java.util.HashMap;
import java.util.TreeMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map.Entry;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MethodCount {

    /**
       MethodList内のメソッド名をカウント
    **/
    public static void main(String args[]) {

	try {
	String filename = "MethodList";
	BufferedReader in = new BufferedReader(new FileReader(filename));
	String line;
	TreeMap<String, Integer> map = new TreeMap<String, Integer>();
	while ((line = in.readLine()) != null) {
	    if (map.containsKey(line)) {
		int count = map.get(line);
		count++;
		map.put(line, count);
	    } else {
		map.put(line, 1);
	    }
	}

	for (Entry en : map.entrySet()) {
	    System.out.println(en.getKey() + ", " + en.getValue());
	}
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}
