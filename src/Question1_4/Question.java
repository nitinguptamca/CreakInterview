package Question1_4;

public class Question {
	public static boolean isAnagram(String s1, String s2) {
		s1 = s1.replaceAll("\\s", "");
		s2 = s2.replaceAll("\\s", "");
		if (s1.length() != s2.length())
			return false;
		char[] ArrayS1 = s1.toLowerCase().toCharArray();
		char[] ArrayS2 = s2.toLowerCase().toCharArray();
		ArrayS1 = insertionSort(ArrayS1);
		ArrayS2 = insertionSort(ArrayS2);
		for (int i = 0; i < ArrayS2.length; i++) {
			if(ArrayS1[i]!=ArrayS2[i]) {
				
				return false;
			
			}
		}
		return true;
		
	}

	private static char[] insertionSort(char[] arrayS1) {
		char temp;
		for (int i = 1; i < arrayS1.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arrayS1[j] < arrayS1[j - 1]) {
					temp = arrayS1[j];
					arrayS1[j] = arrayS1[j - 1];
					arrayS1[j - 1] = temp;
				}
			}
		}
		return arrayS1;
	}

	public static boolean anagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		int[] letters = new int[256];
		int num_unique_chars = 0;
		int num_completed_t = 0;
		char[] s_array = s.toCharArray();
		for (char c : s_array) { // count number of each char in s.

			if (letters[c] == 0)
				++num_unique_chars;
			System.out.println(letters[c]);
			++letters[c];
		}
		for (int i = 0; i < t.length(); ++i) {
			int c = (int) t.charAt(i);
			if (letters[c] == 0) { // Found more of char c in t than in s.
				return false;
			}
			--letters[c];
			if (letters[c] == 0) {
				++num_completed_t;
				if (num_completed_t == num_unique_chars) {
					// it’s a match if t has been processed completely
					return i == t.length() - 1;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isAnagram("nitingupta 234324", "n itim gu pta 234 324"));

		/*
		 * String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello",
		 * "leeoh"}}; for (String[] pair : pairs) { String word1 = pair[0]; String word2
		 * = pair[1]; boolean anagram = anagram(word1, word2); System.out.println(word1
		 * + ", " + word2 + ": " + anagram); }
		 */
	}
}
