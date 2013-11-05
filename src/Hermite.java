import java.util.Scanner;

public class Hermite {

	private final static int N = 4;

	public static void pobierzDane(int[] x, int[] y, int[] yP, int n) {

		Scanner in = new Scanner(System.in);
		System.out.println("Witaj u¿ytkowniku!");

		// Wypelnianie tablicy x
		for (int i = 0; i < n; i++) {

			System.out.println("Podaj wartoœæ x dla x" + i + ":");
			x[i] = in.nextInt();

		}

		// Wypelnianie tablicy y
		for (int i = 0; i < n; i++) {

			System.out.println("Podaj wartoœci y dla x" + i + ":");
			y[i] = in.nextInt();

		}

		// Wypelnianie tablicy yP

		int iloscyP = (n / 2) + 1;

		for (int i = 0; i < iloscyP; i++) {

			System.out.println("Podaj wartoœci yP dla x" + 2 * i + ":");

			yP[2 * i] = in.nextInt();
		}

	}

	public static void pokazTabelke(int[] x, int[] y, int[] yP, int n) {
		
		System.out.println("Tabelka wartosci:");
		System.out.print("x:    ");
		for (int i = 0; i < n; i++) {

			System.out.print(" |"+ x[i]);
		}
		System.out.println();
		System.out.print("f(x): ");
		for (int i = 0; i < n; i++) {

			System.out.print(" |" + y[i]);

		}

		System.out.println();
		System.out.print("f'(x):");
		for (int i = 0; i < n; i++) {

			System.out.print(" |" + yP[i] );
		}
	}

	public static void  main(String[] arg) {
		
		int[] x = new int[10];
		int[] y = new int[10];
		int[] yP = new int[10];

		pobierzDane(x, y, yP, N);
		pokazTabelke(x,y,yP,N);
	}

}
