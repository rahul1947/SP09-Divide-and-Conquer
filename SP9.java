package rsn170330.sp09;

import java.util.Arrays;
import java.util.Random;

public class SP9 {
	public static Random random = new Random();
	public static int numTrials = 100;
	
	public final static int T2 = 99;
	public final static int T3 = 99;
	
	public static void main(String[] args) {
		int Million = 1000000;
		int n = Million;
		int choice = 1 + random.nextInt(4);
		choice = 3;
		/*
		if (args.length > 0) {
			n = Integer.parseInt(args[0]);
		}
		if (args.length > 1) {
			choice = Integer.parseInt(args[1]);
		}
		*/
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i;
		}
		Timer timer = new Timer();
		switch (choice) {
		case 1:
			Shuffle.shuffle(arr);
			numTrials = 1;
			insertionSort(arr);
			//System.out.println(Arrays.toString(arr));
			break;
		case 2:
			//numTrials = 1;
			for (int i = 0; i < numTrials; i++) {
				Shuffle.shuffle(arr);
				mergeSort1(arr);
			}
			//System.out.println(Arrays.toString(arr));
			break; // etc
		case 3:
			//numTrials = 1;
			for (int i = 0; i < numTrials; i++) {
				Shuffle.shuffle(arr);
				//System.out.println(Arrays.toString(arr));
				mergeSort2(arr);
			}
			//System.out.println(Arrays.toString(arr));
			break;
		case 4:
			//numTrials = 1;
			for (int i = 0; i < numTrials; i++) {
				Shuffle.shuffle(arr);
				mergeSort3(arr);
			}
			//System.out.println(Arrays.toString(arr));
			break;
		}
		timer.end();
		timer.scale(numTrials);

		System.out.println("Choice: " + choice + "\n" + timer);
	}

	public static void insertionSort(int[] arr) {
		insertionSort(arr, 0, arr.length-1);
	}
	
	private static void insertionSort(int[] arr, int p, int r) {
		
		for (int i = p+1; i <= r; i++) {
			int key = arr[i];
			
			int j = i-1;
			// Find place for A[ i ] in sorted subarray A[ p..i-1 ].
			while (j >= p && key < arr[j]) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
		
	}

	public static void mergeSort1(int[] arr) {
		mergeSort1(arr, 0, arr.length-1);
	}
	
	private static void mergeSort1(int[] arr, int p, int r) {
		if (p < r) {
			int q = (p+r) / 2;
			mergeSort1(arr, p, q);
			mergeSort1(arr, q+1, r);
			merge1(arr, p, q, r);
		}
	}
	
	private static void merge1(int[] arr, int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;
		
		int L[] = new int[n1];
		int R[] = new int[n2];
		System.arraycopy(arr, p, L, 0, n1);
		System.arraycopy(arr, q+1, R, 0, n2);
		
		int i = 0, j = 0;
		for (int k = p; k <= r; k++) {
			if (j >= R.length || (i < L.length && L[i] <= R[j]))
				arr[k] = L[i++];
			else 
				arr[k] = R[j++];
		}
	}
	
	public static void mergeSort2(int[] arr) { 
		int[] brr = new int[arr.length];
		mergeSort2(arr, brr, 0, arr.length);
	}
	
	// sort a[left..left+n-1]
	private static void mergeSort2(int[] arr, int[] brr, int left, int n) {
		if (n < T2)
			insertionSort(arr, left, left+n-1);
		else {
			int Ln =  n / 2;
			mergeSort2(arr, brr, left, Ln);
			mergeSort2(arr, brr, left+Ln, n-Ln);
			merge2(arr, brr, left, left+Ln-1, left+n-1);
		}
	}
	
	// pre: a[p..r] and a[q+1..r] are in srted order
	private static void merge2(int[] a, int[] b, int p, int q, int r) {
		// merge a[p..q] and a[q+1..r] into a[p..r] in sorted order
		// use b for temporary storage
		
		System.arraycopy(a, p, b, p, r-p+1); // copy a[p..r] to b[p..r]
		
		int i = p, j = q+1;
		
		for (int k = p; k <= r; k++) {
			if (j > r || (i <= q && b[i] <= b[j])) 
				a[k] = b[i++];
			else 
				a[k] = b[j++];
		}
	}
	
	public static void mergeSort3(int[] arr) {
		int[] brr = new int[arr.length];
		System.arraycopy(arr, 0, brr, 0, arr.length);
		mergeSort3(arr, brr, 0, arr.length);
	}
	
	// pre: a[left...left+n-1] and b[left...left+n-1] has same elements
	private static void mergeSort3(int[] a, int[] b, int left, int n) {
		// sort a[left...left+n-1] or b[left...left+n-1] into a[left...left+n-1]
		
		if (n < T3)
			insertionSort(a, left, left+n-1);
		else {
			int Ln = n/2;
			// sort into B and merge into A
			mergeSort3(b, a, left, Ln); // sort into B
			mergeSort3(b, a, left+Ln, n-Ln); // sort into B
			merge3(a, b, left, left+Ln-1, left+n-1); // merge into A
		}
	}
	
	// pre: b[p..q] and b[q+1..r] are in sorted order
	private static void merge3(int[] a, int[] b, int p, int q, int r) {
		// merge b[p..q] and b[q+1..r] into a[p..r] in sorted order
		int i = p, j = q+1, k = p;
		
		while (i <= q && j <= r) {
			if (b[i] <= b[j])
				a[k++] = b[i++];
			else 
				a[k++] = b[j++];
		}
		
		while (i <= q)
			a[k++] = b[i++];
		
		while (j <= r)
			a[k++] = b[j++];
	}
	
	/**
	 * Timer class for roughly calculating running time of programs
	 * 
	 * @author rbk Usage: Timer timer = new Timer(); timer.start(); timer.end();
	 *         System.out.println(timer); // output statistics
	 */

	public static class Timer {
		long startTime, endTime, elapsedTime, memAvailable, memUsed;
		boolean ready;

		public Timer() {
			startTime = System.currentTimeMillis();
			ready = false;
		}

		public void start() {
			startTime = System.currentTimeMillis();
			ready = false;
		}

		public Timer end() {
			endTime = System.currentTimeMillis();
			elapsedTime = endTime - startTime;
			memAvailable = Runtime.getRuntime().totalMemory();
			memUsed = memAvailable - Runtime.getRuntime().freeMemory();
			ready = true;
			return this;
		}

		public long duration() {
			if (!ready) {
				end();
			}
			return elapsedTime;
		}

		public long memory() {
			if (!ready) {
				end();
			}
			return memUsed;
		}

		public void scale(int num) {
			elapsedTime /= num;
		}

		public String toString() {
			if (!ready) {
				end();
			}
			return "Time: " + elapsedTime + " msec.\n" + "Memory: " + (memUsed / 1048576) + " MB / "
					+ (memAvailable / 1048576) + " MB.";
		}
	}

	/**
	 * @author rbk : based on algorithm described in a book
	 */

	/* Shuffle the elements of an array arr[from..to] randomly */
	public static class Shuffle {

		public static void shuffle(int[] arr) {
			shuffle(arr, 0, arr.length - 1);
		}

		public static <T> void shuffle(T[] arr) {
			shuffle(arr, 0, arr.length - 1);
		}

		public static void shuffle(int[] arr, int from, int to) {
			int n = to - from + 1;
			for (int i = 1; i < n; i++) {
				int j = random.nextInt(i);
				swap(arr, i + from, j + from);
			}
		}

		public static <T> void shuffle(T[] arr, int from, int to) {
			int n = to - from + 1;
			Random random = new Random();
			for (int i = 1; i < n; i++) {
				int j = random.nextInt(i);
				swap(arr, i + from, j + from);
			}
		}

		static void swap(int[] arr, int x, int y) {
			int tmp = arr[x];
			arr[x] = arr[y];
			arr[y] = tmp;
		}

		static <T> void swap(T[] arr, int x, int y) {
			T tmp = arr[x];
			arr[x] = arr[y];
			arr[y] = tmp;
		}

		public static <T> void printArray(T[] arr, String message) {
			printArray(arr, 0, arr.length - 1, message);
		}

		public static <T> void printArray(T[] arr, int from, int to, String message) {
			System.out.print(message);
			for (int i = from; i <= to; i++) {
				System.out.print(" " + arr[i]);
			}
			System.out.println();
		}
	}
}
