package oak.codingprepration.java8.Programs;

public class MergeSort {
	private  Comparable[] aux; // auxiliary array for merges
	
	public static void main(String[] args)
	{
		MergeSort mergeSort=new MergeSort();
		Comparable[] unsortedArray = new Comparable[] { 7, 21, 2, 3, 4, 11, 1 };
		mergeSort.aux = new Comparable[unsortedArray.length]; // Allocate space just once.
		System.out.println("Unsorted Array:");
		mergeSort.printingArray(unsortedArray);
		mergeSort.sort(unsortedArray, 0, unsortedArray.length - 1);
		System.out.println("Sorted Array:");
		mergeSort.printingArray(unsortedArray);
	}

	public  void merge(Comparable[] a, int lo, int mid, int hi) { // Merge a[lo..mid] with a[mid+1..hi].
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) // Copy a[lo..hi] to aux[lo..hi].
			aux[k] = a[k];
		for (int k = lo; k <= hi; k++) // Merge back to a[lo..hi].
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (less(aux[j], aux[i]))
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
	}

	private  void sort(Comparable[] a, int lo, int hi) { // Sort a[lo..hi].
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(a, lo, mid); // Sort left half.
		sort(a, mid + 1, hi); // Sort right half.
		merge(a, lo, mid, hi); // Merge results.
	}
	
	public void printingArray(Comparable[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();

	}
	public boolean less(Comparable param, Comparable param1) {
		int result = param.compareTo(param1);
		if (result < 0)
			return true;
		return false;

	}

}
