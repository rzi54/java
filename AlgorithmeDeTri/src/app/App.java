/**
 * 
 */
package app;

import utilities.Utils;
import java.util.Arrays;
import java.util.Scanner;

/*
 * @author Rzi
 *
 */
public class App {

	public static int valueInput;
	public static Scanner scanner = new Scanner(System.in);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		start();

	} 

	private static void start() {

		System.out.println("--------------------------------------\n");
		System.out.println("> Algorithmes de tri et autres\n");
		System.out.println("--------------------------------------\n");

		menu();
	}

	public static int readInput(int menuType) {

		String input = scanner.next();

		try {

			valueInput = Integer.parseInt(input);

		} catch (NumberFormatException e) {

			System.out.println("> Erreur de saisie. Vous devez saisir un nombre entier !");
			System.out.println("");

			switch (menuType) {
			case 0:
				menu();
				break;

			case 1:
				endMenu();
				break;

			case 2:
				searchDicho();
				break;
			}
		}

		return valueInput;
	}

	public static void menu() {

		System.out.println("Menu contextuel : ");
		System.out.println("");
		System.out.println("1) Tri à bulle");
		System.out.println("2) Tri par sélection");
		System.out.println("3) Tri par insertion");
		System.out.println("4) Tri par fusion ");
		System.out.println("5) Tri rapide ");
		System.out.println("6) Recherche dichotomique ");
		System.out.println("");
		System.out.print("Veuillez saisir une action : ");

		int e = readInput(0);

		switch (e) {

		case 1:
			bubbleSort();
			endMenu();
			break;

		case 2:
			sortBySelection();
			endMenu();
			break;

		case 3:
			sortByInsertion();
			endMenu();
			break;

		case 4:
			sortByFusion();
			endMenu();
			break;

		case 5:
			quickSort();
			endMenu();
			break;

		case 6:
			searchDicho();
			endMenu();
			break;

		}

		menu();

	}

	public static void endMenu() {

		System.out.println("> Que souhaitez-vous faire ?\n");
		System.out.println("1) Revenir au menu principal");
		System.out.println("2) Quitter le programme\n");
		System.out.print("Veuillez saisir une action : ");

		int e = readInput(1);

		switch (e) {

		case 1:
			System.out.println("> Retour menu");
			System.out.println("--------------------------------------");
			menu();
			break;

		case 2:
			System.out.println("> Sortie du programme");
			System.out.println("");
			System.out.println("Au revoir et à bientôt !");
			System.exit(0);
			break;
		}

	}

	private static void bubbleSort() {

		// Tri à bulles
		System.out.println("--------------------------------------\n");
		System.out.println("> Début - Tri à bulles\n");
		System.out.println("> Tableau non trié :");
		int[] T1 = { 5, 1, 4, 2, 8 };
		System.out.println(Arrays.toString(T1)+"\n");
		int[] T1_tri = Utils.bubbleSortOptimized(T1);
		System.out.println("> Tableau trié :");
		System.out.println(Arrays.toString(T1_tri)+"\n");
		System.out.println("> Fin - Tri à bulles\n");
		System.out.println("--------------------------------------\n");

	}

	private static void sortBySelection() {

		// Tri par selection
		System.out.println("--------------------------------------\n");
		System.out.println("> Début - Tri par selection\n");
		System.out.println("> Tableau non trié :");
		int[] T2 = { 5, 1, 4, 2, 3 };
		System.out.println(Arrays.toString(T2)+"\n");
		int[] T2_tri = Utils.sortBySelection(T2);
		System.out.println("> Tableau trié :");
		System.out.println(Arrays.toString(T2_tri)+"\n");
		System.out.println("> Fin - Tri par selection\n");
		System.out.println("--------------------------------------\n");

	}

	private static void sortByInsertion() {

		// Tri par selection
		System.out.println("--------------------------------------\n");
		System.out.println("> Début - Tri par insertion\n");
		System.out.println("> Tableau non trié :");
		int[] T3 = { 5, 1, 4, 2, 3 };
		System.out.println(Arrays.toString(T3)+"\n");
		int[] T3_tri = Utils.sortByInsertion(T3);
		System.out.println("> Tableau trié :");
		System.out.println(Arrays.toString(T3_tri)+"\n");
		System.out.println("> Fin - Tri par insertion\n");
		System.out.println("--------------------------------------\n");

	}

	private static void sortByFusion() {

		// Tri par fusion
		System.out.println("--------------------------------------\n");
		System.out.println("> Début - Tri par fusion\n");
		System.out.println("> Tableau non trié :");
		int[] T4 = { 38, 27, 43, 3, 9, 82, 10 };
		System.out.println(Arrays.toString(T4)+"\n");
		int[] T4_tri = Utils.sortByFusion(T4);
		System.out.println("> Tableau trié :");
		System.out.println(Arrays.toString(T4_tri)+"\n");
		System.out.println("> Fin - Tri par fusion\n");
		System.out.println("--------------------------------------\n");
	}

	private static void quickSort() {

		// Tri rapide
		System.out.println("--------------------------------------\n");
		System.out.println("> Début - Tri rapide\n");
		System.out.println("> Tableau non trié :");
		int[] T5 = { 38, 27, 43, 3, 9, 82, 10 };
		System.out.println(Arrays.toString(T5)+"\n");
		int[] T5_tri = Utils.quickSort(T5, 0, 7);
		System.out.println("> Tableau trié :");
		System.out.println(Arrays.toString(T5_tri)+"\n");
		System.out.println("> Fin - Tri rapide\n");
		System.out.println("--------------------------------------\n");

	}

	private static void searchDicho() {

		// Recherche dichotomique
		System.out.println("--------------------------------------\n");
		System.out.println("> Début - Recherche dichotomique\n");
		System.out.println("> Tableau non trié:");
		int[] T6 = { 38, 27, 43, 3, 9, 82, 10 };
		System.out.println(Arrays.toString(T6)+"\n");
		System.out.println("> Tri du tableau par 'tri rappide'\n");
		int[] T6_tri = Utils.quickSort(T6, 0, 7);
		System.out.println("> Tableau trié :");
		System.out.println(Arrays.toString(T6_tri)+"\n");
		System.out.println("> Fin - Tri rapide \n");
		System.out.print("Quel nombre recherchez-vous dans le tableau ?\n\n");
		int e = readInput(2);
		System.out.println("Le nombre "+e+" se trouve à la position : "+Utils.searchDicho(e, T6_tri)+"\n");
		System.out.println("--------------------------------------");

	}
	
	
} // fin App