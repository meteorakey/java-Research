import java.util.HashMap;
import java.util.TreeMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map.Entry;
import java.io.FileNotFoundException;
import java.io.IOException;

public class WordCount {
    public static void main(String args[]) {

        try {
	    String filename = "MethodList";
	    BufferedReader in = new BufferedReader(new FileReader(filename));
	    String line;
	    TreeMap<String, Integer> map = new TreeMap<String, Integer>();
	    while ((line = in.readLine()) != null) {

		String[] strs = line.split("(?<=[A-Z])(?=[A-Z][a-z])|(?<=[a-z])(?=[A-Z])");
		for (String str : strs) {
		    //System.out.println(str);
		    if (map.containsKey(str)) {
			int count = map.get(str);
			count++;
			map.put(str, count);
		    } else {
			map.put(str, 1);
		    }
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
