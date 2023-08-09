package utilities;

import java.util.Arrays;
import java.util.Scanner;

public class Utils {
	
	/* Check Integer */
	public static void checkInteger(int[] list) {

		try (Scanner scanner = new Scanner(System.in)) {

			System.out.print("Veuillez saisir un entier : ");
			Object entier = scanner.nextInt();

			if (entier instanceof Integer) {

				int e = (int)entier;
				System.out.println( "Vous recherchez le nombre " + e );
				System.out.println( "qui se trouve à la position " + searchDicho(e, list) );
				
			} else {
				
				System.out.print("Vous n'avez pas saisi un entier");
				checkInteger(list);
				
			}
		}
	}

	/*
	 * 
	 * 
	 
	/*
	 * Print Tableau
	 */
	public static void printArray(int[] T) {

		System.out.print("[ ");
		for (int j = 0; j < T.length; j++) {
			if (j < T.length - 1) {
				System.out.print(T[j] + ", ");
			} else {
				System.out.print(T[j] + " ");
			}
		}
		System.out.println("]");

	}

	/*
	 * Tri à bulles
	 */
	public static int[] bubbleSortOptimized(int[] T) {
		// ...

		int n = T.length - 1;
		int i = n;

		while (i > -1) {

			boolean is = true;

			for (int j = 0; j < n; j++) {

				if (T[j + 1] < T[j]) {

					int a = T[j];
					int b = T[j + 1];

					T[j] = b;
					T[j + 1] = a;

					is = false;

				}

			}

			if (is) {

				i = -1;
			}
		} // fin while

		return T;

	}// fin bubbleSortOptimized

	/*
	 * Tri par selection
	 */
	public static int[] sortBySelection(int[] T) {
		// ...

		int n = T.length;

		for (int i = 0; i <= n; i++) {

			int min = i;

			for (int j = i + 1; j < n; j++) {

				if (T[j] < T[min]) {
					min = j;
				}

			}

			if (min != i) {
				int a = T[i];
				int b = T[min];

				T[i] = b;
				T[min] = a;
			}
		}

		return T;

	}// fin sortBySelection

	/*
	 * Tri par insertion
	 */
	public static int[] sortByInsertion(int[] T) {
		// ...

		int n = T.length;

		for (int i = 0; i < n; i++) {

			int x = T[i];
			int j = i;

			while (j > 0 && T[j - 1] > x) {

				T[j] = T[j - 1];
				j--;
			}

			T[j] = x;
		}

		return T;

	}// fin sortByInsertion

	/*
	 * Tri par fusion
	 */
	public static int[] sortByFusion(int[] T) {
		// ...

		if (T.length <= 1) {

			return T;

		} else {
			int[] firtPart = sortByFusion(splice(T, 0, (int) Math.floor(T.length / 2)));
			int[] lastPart = sortByFusion(splice(T, (int) Math.floor(T.length / 2), T.length));
			return fusion(firtPart, lastPart);
		}

	}// fin sortByFusion

	public static int[] fusion(int[] A, int[] B) {
		// ...

		if (A.length == 0) {

			return B;

		} else if (B.length == 0) {

			return A;

		} else if (A[0] <= B[0]) {

			int[] A_ = { A[0] };
			int[] A__ = Arrays.copyOfRange(A, 1, A.length);

			return concatenationTableaux(A_, fusion(A__, B));

		} else {

			int[] B_ = { B[0] };
			int[] B__ = Arrays.copyOfRange(B, 1, B.length);

			return concatenationTableaux(B_, fusion(B__, A));

		}

	}// fin fusion

	public static int[] concatenationTableaux(int[] tab1, int[] tab2) {

		int len1 = tab1.length;
		int len2 = tab2.length;

		int[] res = new int[len1 + len2];

		System.arraycopy(tab1, 0, res, 0, len1);
		System.arraycopy(tab2, 0, res, len1, len2);

		return res;
	}

	public static int[] splice(int[] array, int startIndex, int endIndex) {

		// Récupère la tranche du tableau
		int[] splicedArray = Arrays.copyOfRange(array, startIndex, endIndex);
		// renvoie la tranche
		return splicedArray;
	}

	/* Tri rapide */
	public static int[] quickSort(int[] T, int p, int m) {

		if (m - p < 2) {
			return T;
		}

		int q = T[m - 1];
		int c = p;

		for (int i = p; i < m - 1; i++) {

			if (T[i] <= q) {

				int a = T[i];
				T[i] = T[c];
				T[c] = a;
				c++;
			}

		}

		int a = T[m - 1];
		T[m - 1] = T[c];
		T[c] = a;

		quickSort(T, p, c);
		quickSort(T, c + 1, m);

		return T;
	}

	/* Recherche dichotomique */
	public static int searchDicho(int e, int[] list) {
		
		if (list.length == 1) { return 0; }

		int m = (int) Math.floor(list.length / 2);

		if (list[m] == e) {

			return m;

		} else if (list[m] > e) {
			
			return searchDicho(e, splice(list, 0, m));

		} else {

			return m + searchDicho(e, splice(list, m, list.length ));

		}

	} // fin searchDicho

	
}
