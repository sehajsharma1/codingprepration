package oak.codingprepration.java8.Programs;

public class Palindrome {
	public static void main(String[] args) {
		System.out.println("Is aaa palindrom?: " + isPalindromString("1234321"));

	}

	public static boolean isPalindromString(String text) {
		
		String reverse = reverse(text);
		
		if (text.equals(reverse)) {
			return true;
		}
		return false;
	}

	public static String reverse(String input) {
		if (input == null || input.isEmpty()) {
			return input;
		}
		return input.charAt(input.length() - 1) + reverse(input.substring(0, input.length() - 1));
	}     

}
