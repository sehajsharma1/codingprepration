package oak.codingprepration.java8.Programs;

import java.util.Random;

public class QuickSort {
	public static void main(String[] args) {
		QuickSort quickSort = new QuickSort();
		Comparable[] unsortedArray = new Comparable[] { 7, 21, 2, 3, 4, 11, 1 };
		System.out.println("Unsorted Array:");
		quickSort.printingArray(unsortedArray);
		quickSort.shuffleArray(unsortedArray);
		quickSort.sort(unsortedArray, 0, unsortedArray.length - 1);
		System.out.println("Sorted Array:");
		quickSort.printingArray(unsortedArray);

	}

	private void sort(Comparable[] array, int lo, int hi) {
		if (hi <= lo)
			return;
		int j = partition(array, lo, hi);
		sort(array, lo, j - 1); // Sort left part a[lo .. j-1].
		sort(array, j + 1, hi); // Sort right part a[j+1 .. hi].
	}

	private int partition(Comparable[] array, int lo, int hi) { // Partition into a[lo..i-1], a[i], a[i+1..hi].
		int i = lo, j = hi + 1; // left and right scan indices
		Comparable v = array[lo]; // partitioning item
		while (true) { // Scan right, scan left, check for scan complete, and exchange.
			while (less(array[++i], v))
				if (i == hi)
					break;
			while (less(v, array[--j]))
				if (j == lo)
					break;
			if (i >= j)
				break;
			exch(array, i, j);
		}
		exch(array, lo, j); // Put v = a[j] into position
		return j; // with a[lo..j-1] <= a[j] <= a[j+1..hi].
	}

	public boolean less(Comparable param, Comparable param1) {
		int result = param.compareTo(param1);
		if (result < 0)
			return true;
		return false;

	}

	public void exch(Comparable[] array, int param1, int param2) {
		Comparable temp = array[param1];
		array[param1] = array[param2];
		array[param2] = temp;

	}

	public void shuffleArray(Comparable[] array) {
		Random random = new Random();

		for (int i = 0; i < array.length; i++) {
			int randomIndexToSwap = random.nextInt(array.length);
			var temp = array[randomIndexToSwap];
			array[randomIndexToSwap] = array[i];
			array[i] = temp;
		}
		System.out.println("Shuffled Array:");
		printingArray(array);
	}

	public void printingArray(Comparable[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();

	}

}
