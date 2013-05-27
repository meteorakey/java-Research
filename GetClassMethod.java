import java.lang.reflect.Method;
import java.util.ArrayList;

public class GetClassMethod {

    /**
       指定されたClassファイル内のユーザ定義メソッド名を取得
       第一引数にClassファイルを指定
       GetClassesMethods.sh専用
     **/
    public static void main(String args[]) {

	String targetClassName = args[0];
	targetClassName = targetClassName.replaceAll("/", ".");
	targetClassName = targetClassName.substring(2,targetClassName.length());
        Class  targetClass     = null;

        try {
            targetClass = Class.forName(targetClassName);
        } catch (ClassNotFoundException e) {
	    System.out.println("not found " + targetClassName);
	    System.exit(1);
	}
	//System.out.println("ClassName : " + targetClassName);
	Method[] list = targetClass.getDeclaredMethods();
	for (Method method : list) {
	    System.out.println(method.getName());
	    //System.out.println(method.toString());
	}

    }

}
