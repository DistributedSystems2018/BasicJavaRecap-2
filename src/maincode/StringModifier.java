package maincode;

public class StringModifier {

	public static void replaceA(String toReplace) {
		if (toReplace.contains("aa")) {
			replaceA(toReplace.replace("aa", "a"));
		} else {
			System.out.println(toReplace);
		}
	}

}
