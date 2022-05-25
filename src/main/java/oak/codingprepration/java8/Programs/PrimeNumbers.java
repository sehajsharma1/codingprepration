package oak.codingprepration.java8.Programs;

public class PrimeNumbers {
	public static void main(String args[]) {
		int number = 25;
			System.out.printf("Does %d is prime? %s %s %s %n", number,isPrimeNumber(number), isPrime(number)
					);
	}

	public static boolean isPrime(int number) {
		int sqrt = (int) Math.sqrt(number) + 1;
		for (int i = 2; i < sqrt; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean isPrimeNumber(int number) {
		if (number == 2 || number == 3) {
			return true;
		}
		if (number % 2 == 0) {
			return false;
		}
		int sqrt = (int) Math.sqrt(number) + 1;
		for (int i = 3; i < sqrt; i += 2) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}


}
