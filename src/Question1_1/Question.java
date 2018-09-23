package Question1_1;

public class Question {

	public static boolean isUniqueCharacters(String str) {
		boolean flag = false;
		for (int i = 0; i < str.length(); i++)
			for (int j = i + 1; j < str.length(); j++)
				if (str.charAt(i) == str.charAt(j))
					return false;
		return true;
	}

	public static String returnUniqueChars(String str) {
		String uniqueChars = "";
		boolean[] charSet=new boolean[256];
		for (int i=0 ;i< str.length();i++) {
			int value=str.charAt(i);
			if(charSet[value]) {
				
			}else {
				if(!charSet[value]) uniqueChars +=Character.valueOf((char) value);
				charSet[value]=true;
			}
		}
		return uniqueChars;
	}

	public static boolean isUniqueCharacters1(String str) {
		boolean[] chararr = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int value = str.charAt(i);
			if (chararr[value]) {
				return false;
			} else {
				chararr[value] = true;
			}
		}
		return true;
	}

	public static boolean isUniqueChars(String str) {
		int checker = 0;
		for (int i = 0; i < str.length(); ++i) {
			System.out.println(str.charAt(i));
			int val = str.charAt(i) - 'a';
			int tmp = checker & (1 << val);
			if (tmp > 0)
				return false;
			checker |= (1 << val);
		}
		return true;
	}

	public static boolean uniqueChar(String str) {
		boolean[] char_set = new boolean[512];
		for (int i = 0; i < char_set.length; i++) {
			int val = str.charAt(i);
			if (char_set[val]) {
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}

	public static boolean isUniqueChars2(String str) {
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val]) {
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}

	public static void main(String[] args) {
		// System.out.println(isUniqueCharacters("n2tkm"));
	///	System.out.println(isUniqueCharacters1("n2tkmn"));
		System.out.println(isUniqueChars("n2tkmnk2tqwert"));

	}

}
